package ru.levelup.at.homework6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailExercise1Test extends AbstractSeleniumTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void loginNewLetterTest() {
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
        letterContactTo.sendKeys("vas.kuznetsova@gmail.com");

        WebElement letterSubject = driver
            .findElement(By.xpath("//*[contains(@class, 'subject')]//input"));
        letterSubject.sendKeys("Test Subject");

        WebElement letterText = driver
            .findElement(By.xpath("//*[@role='textbox']"));
        letterText.sendKeys("Test Text");

        driver.findElement(By.cssSelector("[title='Сохранить']")).click();
        driver.findElement(By.cssSelector("[title='Закрыть']")).click();

        driver.findElement(By.cssSelector("[href='/drafts/']")).click();

        String actualLetterContactTo = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__item_correspondent')]//span"))
            .getAttribute("title");

        String actualLetterSubject = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__subject')]//span"))
            .getText();

        String actualLetterText = driver
            .findElement(By.xpath("//*[contains(@class, 'llc__snippet')]//span"))
            .getText();

        assertThat(actualLetterContactTo).isEqualTo("vas.kuznetsova@gmail.com");
        assertThat(actualLetterSubject).isEqualTo("Test Subject");
        assertThat(actualLetterText).isEqualTo("Test Text");

        driver.findElement(By.xpath("//*[contains(@class, 'llc__content')]"))
              .click();
        driver.findElement(By.cssSelector("[title='Отправить']")).click();
        try {
            driver.findElement(By.cssSelector("[title='Закрыть']")).click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            driver.findElement(By.cssSelector("[title='Закрыть']")).click();
        }

        driver.findElement(By.cssSelector("[href='/sent/']")).click();
        List<WebElement> sentItems = driver
            .findElements(By.xpath("//*[contains(@class, 'llc__content')]"));
        assertThat(sentItems).hasSizeGreaterThan(0);

        driver.findElement(By.cssSelector("[href='/drafts/']")).click();
        List<WebElement> draftEmptyItems = driver
            .findElements(By.xpath("//*[contains(@class, 'dataset__empty')]"));
        assertThat(draftEmptyItems).hasSizeGreaterThan(0);


        driver.findElement(By.cssSelector("[data-testid='whiteline-account']")).click();
        driver.findElement(By.xpath("//*[text() = 'Выйти']")).click();

    }

}
