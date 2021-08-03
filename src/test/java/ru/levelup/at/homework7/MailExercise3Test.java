package ru.levelup.at.homework7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.java.homework7.ConfProperties;
import ru.levelup.at.java.homework7.MailInboxPage;
import ru.levelup.at.java.homework7.MailLoginPage;

public class MailExercise3Test extends AbstractSeleniumTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void loginNewLetterDeleteTest() {

        var mailLoginPage = new MailLoginPage(driver);
        mailLoginPage.open();
        mailLoginPage.login(ConfProperties.getProperty("login"),
            ConfProperties.getProperty("password"));
        assertThat(mailLoginPage.getActualLoginText()).isEqualTo("vasilina_levelup@mail.ru");

        var mailInboxPage = new MailInboxPage(driver);
        mailInboxPage.createLetter("vasilina_levelup@mail.ru",
            "Test Delete Subject", "Test Delete Text");

        mailInboxPage.getSelfLetters();
        assertThat(mailInboxPage.getLetterContactTo(0)).containsIgnoringCase("vasilina_levelup@mail.ru");
        assertThat(mailInboxPage.getLetterSubject(0)).containsIgnoringCase("Test Delete Subject");
        assertThat(mailInboxPage.getLetterText(0)).containsIgnoringCase("Test Delete Text");

        mailInboxPage.deleteSelfLetters();

        var mailTrashPage = mailInboxPage.clickTrashButton();
        assertThat(mailTrashPage.getLetterContactTo(0)).containsIgnoringCase("vasilina_levelup@mail.ru");
        assertThat(mailTrashPage.getLetterSubject(0)).containsIgnoringCase("Test Delete Subject");
        assertThat(mailTrashPage.getLetterText(0)).containsIgnoringCase("Test Delete Text");

        mailTrashPage.logout();
    }

}
