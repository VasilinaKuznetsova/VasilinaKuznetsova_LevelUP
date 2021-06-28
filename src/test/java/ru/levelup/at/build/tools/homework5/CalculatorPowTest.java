package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorPowTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] powDoubleDataProvider() {
        return new Object[][] {
            {5.0, 0.0, 1.0},
            {1.0, 99.0, 1.0},
            {4.0, 1.0, 4.0},
            {2.0, -2.0, 0.25},
            {9.3, 3.0, 804.357},
            {-45.1, 6.0, 8415099419.29}
        };
    }

    @Test(dataProvider = "powDoubleDataProvider")
    public void powDoubleTest(Double a, Double b, Double expected) {
        Double actual = calculator.pow(a, b);
        assertEquals(actual, expected, 0.001);
    }

}
