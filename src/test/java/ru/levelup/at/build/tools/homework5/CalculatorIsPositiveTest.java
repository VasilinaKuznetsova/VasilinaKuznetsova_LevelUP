package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorIsPositiveTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] isPositiveLongDataProvider() {
        return new Object[][] {
            {789, true},
            {-1, false},
            {0, false}
        };
    }

    @Test(dataProvider = "isPositiveLongDataProvider")
    public void isPositiveLongTest(long a, boolean expected) {
        assertEquals(calculator.isPositive(a), expected);
    }

}
