package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] multLongDataProvider() {
        return new Object[][] {
            {0, 0, 0},
            {1, 7, 7},
            {5, 8, 40}
        };
    }

    @DataProvider
    private Object[][] multDoubleDataProvider() {
        return new Object[][] {
            {2.0, 2.0, 4.0},
            {1.8, 3.3, 5.94},
            {-77.9, -91.2, 7104.48},
            {-5.8, 200.1, -1160.58}
        };
    }

    @Test(dataProvider = "multLongDataProvider")
    public void multLongTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "multDoubleDataProvider")
    public void multDoubleTest(Double a, Double b, Double expected) {
        Double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 0.001);
    }
}
