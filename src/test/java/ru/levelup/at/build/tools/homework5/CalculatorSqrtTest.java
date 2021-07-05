package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSqrtTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] sqrtDoubleDataProvider() {
        return new Object[][] {
            {0.0, 0.0},
            {9.0, 3.0},
            {598.9, 24.472},
            {1000000.0, 1000.0}
        };
    }

    @Test(dataProvider = "sqrtDoubleDataProvider")
    public void sqrtDoubleTest(Double a, Double expected) {
        Double actual = calculator.sqrt(a);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void sqrtNegativeDoubleTest() {
        Double actual = calculator.sqrt(-2.0);
        assertEquals(actual, Double.NaN, 0.001);
    }
}

