package ru.levelup.at.build.tools.homework5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivTest extends AbstractCalculatorTest {

    @DataProvider
    private Object[][] divLongDataProvider() {
        return new Object[][] {
            {0, 5, 0},
            {4, 2, 2},
            {100, 3, 33},
            {-45, 9, -5}
        };
    }

    @DataProvider
    private Object[][] divDoubleDataProvider() {
        return new Object[][] {
            {0.0, 1.0, 0.0},
            {9.3, 3.0, 3.1},
            {-30.48, -12.7, 2.4},
            {25567.0, -21.5, -1189.163}
        };
    }

    @Test(dataProvider = "divLongDataProvider")
    public void divLongTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "divDoubleDataProvider")
    public void divDoubleTest(Double a, Double b, Double expected) {
        Double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void divByZeroLongTest() {
        long actual = calculator.div(1, 0);
    }

    @Test(expectedExceptions = {NumberFormatException.class})
    public void divByZeroDoubleTest() {
        Double actual = calculator.div(1.0, 0);
    }
}
