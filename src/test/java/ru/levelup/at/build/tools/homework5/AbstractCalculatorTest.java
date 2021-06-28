package ru.levelup.at.build.tools.homework5;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.qa.at.calculator.Calculator;

public abstract class AbstractCalculatorTest {
    protected Calculator calculator;

    @BeforeMethod
    public void calculatorSetUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void calculatorTearDown() {
        calculator = null;
    }
}
