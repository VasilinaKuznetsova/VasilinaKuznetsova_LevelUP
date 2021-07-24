package ru.levelup.at.homework7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.java.homework7.ConfProperties;
import ru.levelup.at.java.homework7.MailInboxPage;
import ru.levelup.at.java.homework7.MailLoginPage;

public class MailExercise2Test extends AbstractSeleniumTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void loginNewLetterInFolderTest() {

        var mailLoginPage = new MailLoginPage(driver);
        mailLoginPage.open();
        mailLoginPage.login(ConfProperties.getProperty("login"),
            ConfProperties.getProperty("password"));
        assertThat(mailLoginPage.getActualLoginText()).isEqualTo("vasilina_levelup@mail.ru");

        var mailInboxPage = new MailInboxPage(driver);
        mailInboxPage.createLetter("vasilina_levelup@mail.ru",
            "Тест Test Subject", "Test Text");

        var mailSentPage = mailInboxPage.clickSentButton();
        assertThat(mailSentPage.getLetterContactTo(0)).isEqualTo("vasilina_levelup@mail.ru");
        assertThat(mailSentPage.getLetterSubject(0)).isEqualTo("Self: Тест Test Subject");
        assertThat(mailSentPage.getLetterText(0)).isEqualTo("Test Text");

        var mailTestPage = mailSentPage.clickTestButton();
        assertThat(mailTestPage.getLetterContactTo(0)).isEqualTo("vasilina_levelup@mail.ru");
        assertThat(mailTestPage.getLetterSubject(0)).isEqualTo("Self: Тест Test Subject");
        assertThat(mailTestPage.getLetterText(0)).isEqualTo("Test Text");

        mailTestPage.logout();
    }

}
