package ru.levelup.at.homework7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.java.homework7.ConfProperties;
import ru.levelup.at.java.homework7.MailInboxPage;
import ru.levelup.at.java.homework7.MailLoginPage;

public class MailExercise1Test extends AbstractSeleniumTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void loginNewLetterTest() {

        var mailLoginPage = new MailLoginPage(driver);
        mailLoginPage.open();
        mailLoginPage.login(ConfProperties.getProperty("login"),
            ConfProperties.getProperty("password"));
        assertThat(mailLoginPage.getActualLoginText()).isEqualTo("vasilina_levelup@mail.ru");

        var mailInboxPage = new MailInboxPage(driver);
        mailInboxPage.createDraftLetter("vas.kuznetsova@gmail.com",
            "Test Subject", "Test Text");

        var mailDraftsPage = mailInboxPage.clickDraftsButton();
        assertThat(mailDraftsPage.getLetterContactTo(0)).isEqualTo("vas.kuznetsova@gmail.com");
        assertThat(mailDraftsPage.getLetterSubject(0)).isEqualTo("Test Subject");
        assertThat(mailDraftsPage.getLetterText(0)).isEqualTo("Test Text");

        mailDraftsPage.sendLetter(0);

        var mailSentPage = mailDraftsPage.clickSentButton();
        assertThat(mailSentPage.getLetterItems()).hasSizeGreaterThan(0);

        mailDraftsPage = mailSentPage.clickDraftsButton();
        assertThat(mailDraftsPage.getDraftEmptyItems()).hasSizeGreaterThan(0);

        mailDraftsPage.logout();
    }

}
