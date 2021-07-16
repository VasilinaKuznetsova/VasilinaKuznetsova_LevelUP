package ru.levelup.at.homework6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailExercise3Test extends AbstractSeleniumTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void loginNewLetterDeleteTest() {
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
        letterSubject.sendKeys("Test Delete Subject");

        WebElement letterText = driver
            .findElement(By.xpath("//*[@role='textbox']"));
        letterText.sendKeys("Test Delete Text");

        driver.findElement(By.cssSelector("[title='Отправить']")).click();
        try {
            driver.findElement(By.cssSelector("[title='Закрыть']")).click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            driver.findElement(By.cssSelector("[title='Закрыть']")).click();
        }

        driver.findElement(By.cssSelector("[href='/inbox/']")).click();

        driver.findElement(By.xpath("//*[contains(@class, 'metathread__contain')]"))
              .click();

        String actualInboxLetterContactTo = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__item_correspondent')]//span"))
            .getAttribute("title");

        String actualInboxLetterSubject = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__subject')]//span"))
            .getText();

        String actualInboxLetterText = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__snippet')]//span"))
            .getText();

        assertThat(actualInboxLetterContactTo).containsIgnoringCase("vasilina_levelup@mail.ru");
        assertThat(actualInboxLetterSubject).containsIgnoringCase("Test Delete Subject");
        assertThat(actualInboxLetterText).containsIgnoringCase("Test Delete Text");


        driver.findElement(By.xpath("//*[contains(@class, 'metathread__contain')]//div[@class='checkbox']"))
              .click();
        driver.findElement(By.cssSelector("[title='Удалить']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'layer__submit-button')]//span[text() = 'Очистить']"))
              .click();

        driver.findElement(By.cssSelector("[href='/trash/']")).click();
        String actualDeleteLetterContactTo = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__item_correspondent')]//span"))
            .getAttribute("title");

        String actualDeleteLetterSubject = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__subject')]//span"))
            .getText();

        String actualDeleteLetterText = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__snippet')]//span"))
            .getText();

        assertThat(actualDeleteLetterContactTo).containsIgnoringCase("vasilina_levelup@mail.ru");
        assertThat(actualDeleteLetterSubject).containsIgnoringCase("Test Delete Subject");
        assertThat(actualDeleteLetterText).containsIgnoringCase("Test Delete Text");

        driver.findElement(By.cssSelector("[data-testid='whiteline-account']")).click();
        driver.findElement(By.xpath("//*[text() = 'Выйти']")).click();

    }

}
