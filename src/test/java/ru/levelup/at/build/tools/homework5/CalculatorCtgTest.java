package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorCtgTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] ctgDoubleDataProvider() {
        return new Object[][] {
            {(Math.PI / 2), 0.0},
            {(Math.PI / 4), 1.0},
            {(Math.PI * 1.5), 0.0},
            {(Math.PI / 3), 0.577}
        };
    }

    @Test(dataProvider = "ctgDoubleDataProvider")
    public void ctgDoubleTest(Double a, Double expected) {
        Double actual = calculator.ctg(a);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void ctgNegativeDoubleTest() {
        Double actual = calculator.ctg(0.0 / 2);
        assertEquals(actual, Double.NaN, 0.001);
    }
}
