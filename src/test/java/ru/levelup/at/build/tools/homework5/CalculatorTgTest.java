package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTgTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] tgDoubleDataProvider() {
        return new Object[][] {
            {0.0, 0.0},
            {(Math.PI / 4), 1.0},
            {Math.PI, 0.0},
            {(Math.PI / 6), 0.577}
        };
    }

    @Test(dataProvider = "tgDoubleDataProvider")
    public void tgDoubleTest(Double a, Double expected) {
        Double actual = calculator.tg(a);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void tgNegativeDoubleTest() {
        Double actual = calculator.tg(Math.PI / 2);
        assertEquals(actual, Double.NaN, 0.001);
    }
}
