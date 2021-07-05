package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorCosTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] cosDoubleDataProvider() {
        return new Object[][] {
            {0.0, 1.0},
            {(Math.PI / 3), 0.5},
            {Math.PI, -1.0},
            {(Math.PI / 2), 0.0}
        };
    }

    @Test(dataProvider = "cosDoubleDataProvider")
    public void cosDoubleTest(Double a, Double expected) {
        Double actual = calculator.cos(a);
        assertEquals(actual, expected, 0.001);
    }
}
