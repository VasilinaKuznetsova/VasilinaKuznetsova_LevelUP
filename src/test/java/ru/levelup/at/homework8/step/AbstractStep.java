package ru.levelup.at.homework8.step;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.java.homework8.MailDraftsPage;
import ru.levelup.at.java.homework8.MailInboxPage;
import ru.levelup.at.java.homework8.MailLoginPage;
import ru.levelup.at.java.homework8.MailSentPage;
import ru.levelup.at.java.homework8.MailTestPage;
import ru.levelup.at.java.homework8.MailTrashPage;

public abstract class AbstractStep {

    private WebDriver driver;

    protected MailLoginPage loginPage;
    protected MailDraftsPage draftsPage;
    protected MailInboxPage inboxPage;
    protected MailSentPage sentPage;
    protected MailTestPage testPage;
    protected MailTrashPage trashPage;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new MailLoginPage(driver);
        draftsPage = new MailDraftsPage(driver);
        inboxPage = new MailInboxPage(driver);
        sentPage = new MailSentPage(driver);
        testPage = new MailTestPage(driver);
        trashPage = new MailTrashPage(driver);
    }
}
