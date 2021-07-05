package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSinTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] sinDoubleDataProvider() {
        return new Object[][] {
            {0.0, 0.0},
            {(Math.PI / 6), 0.5},
            {Math.PI, 0.0},
            {(Math.PI * 1.5), -1.0}
        };
    }

    @Test(dataProvider = "sinDoubleDataProvider")
    public void sinDoubleTest(Double a, Double expected) {
        Double actual = calculator.sin(a);
        assertEquals(actual, expected, 0.001);
    }
}
