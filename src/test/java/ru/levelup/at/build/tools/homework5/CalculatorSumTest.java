package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] sumLongDataProvider() {
        return new Object[][] {
            {2, 2, 4},
            {4, 7, 11},
            {-9, -30, -39}
        };
    }

    @DataProvider
    private Object[][] sumDoubleDataProvider() {
        return new Object[][] {
            {2.2, 2.5, 4.7},
            {-1.8, -7.1, -8.9},
            {-9.5, 6.4, -3.1}
        };
    }

    @Test(dataProvider = "sumLongDataProvider")
    public void sumLongTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "sumDoubleDataProvider")
    public void sumDoubleTest(Double a, Double b, Double expected) {
        Double actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.001);

    }
}
