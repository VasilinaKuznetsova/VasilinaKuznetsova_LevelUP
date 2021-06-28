package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] subLongDataProvider() {
        return new Object[][] {
            {2, 2, 0},
            {4, 7, -3},
            {-9, -30, 21}
        };
    }

    @DataProvider
    private Object[][] subDoubleDataProvider() {
        return new Object[][] {
            {2.2, 2.5, -0.3},
            {-1.8, -7.1, 5.3},
            {-9.5, 6.4, -15.9}
        };
    }

    @Test(dataProvider = "subLongDataProvider")
    public void subLongTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "subDoubleDataProvider")
    public void subDoubleTest(Double a, Double b, Double expected) {
        Double actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.001);

    }
}
