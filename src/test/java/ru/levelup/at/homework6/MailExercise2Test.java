package ru.levelup.at.homework6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailExercise2Test extends AbstractSeleniumTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void loginNewLetterInFolderTest() {
        WebElement loginInput = driver.findElement(By.name("login"));
        loginInput.sendKeys("vasilina_levelup");
        driver.findElement(By.cssSelector("[data-testid='enter-password']")).click();

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("seleniumTest");
        driver.findElement(By.cssSelector("[data-testid='login-to-mail']")).click();

        WebElement actualLogin = driver.findElement(By.cssSelector("[data-testid='whiteline-account']"));
        String actualLoginText = actualLogin.getAttribute("aria-label");

        assertThat(actualLoginText).isEqualTo("vasilina_levelup@mail.ru");

        driver.findElement(By.cssSelector("[href='/compose/']")).click();

        WebElement letterContactTo = driver
            .findElement(By.xpath("//*[@data-type='to']//input"));
        letterContactTo.sendKeys("vasilina_levelup@mail.ru");

        WebElement letterSubject = driver
            .findElement(By.xpath("//*[contains(@class, 'subject')]//input"));
        letterSubject.sendKeys("Тест Test Subject");

        WebElement letterText = driver
            .findElement(By.xpath("//*[@role='textbox']"));
        letterText.sendKeys("Test Text");

        driver.findElement(By.cssSelector("[title='Отправить']")).click();
        try {
            driver.findElement(By.cssSelector("[title='Закрыть']")).click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            driver.findElement(By.cssSelector("[title='Закрыть']")).click();
        }

        driver.findElement(By.cssSelector("[href='/sent/']")).click();

        String actualSentLetterContactTo = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__item_correspondent')]//span"))
            .getAttribute("title");

        String actualSentLetterSubject = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__subject')]//span"))
            .getText();

        String actualSentLetterText = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__snippet')]//span"))
            .getText();

        assertThat(actualSentLetterContactTo).isEqualTo("vasilina_levelup@mail.ru");
        assertThat(actualSentLetterSubject).isEqualTo("Self: Тест Test Subject");
        assertThat(actualSentLetterText).isEqualTo("Test Text");


        driver.findElement(By.cssSelector("[href='/1/']")).click();
        String actualFolderLetterContactTo = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__item_correspondent')]//span"))
            .getAttribute("title");

        String actualFolderLetterSubject = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__subject')]//span"))
            .getText();

        String actualFolderLetterText = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__snippet')]//span"))
            .getText();

        assertThat(actualFolderLetterContactTo).containsIgnoringCase("vasilina_levelup@mail.ru");
        assertThat(actualFolderLetterSubject).containsIgnoringCase("Тест Test Subject");
        assertThat(actualFolderLetterText).containsIgnoringCase("Test Text");

        driver.findElement(By.cssSelector("[data-testid='whiteline-account']")).click();
        driver.findElement(By.xpath("//*[text() = 'Выйти']")).click();

    }

}
