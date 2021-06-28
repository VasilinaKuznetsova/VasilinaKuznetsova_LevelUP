package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorIsNegativeTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] isNegativeLongDataProvider() {
        return new Object[][] {
            {789, false},
            {-1, true},
            {0, false}
        };
    }

    @Test(dataProvider = "isNegativeLongDataProvider")
    public void isNegativeLongTest(long a, boolean expected) {
        assertEquals(calculator.isNegative(a), expected);
    }

}
