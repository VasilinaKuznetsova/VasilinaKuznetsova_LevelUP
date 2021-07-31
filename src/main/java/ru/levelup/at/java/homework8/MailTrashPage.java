package ru.levelup.at.java.homework8;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailTrashPage extends AbstractBasePage {

    @FindBy(css = "[href='/compose/']")
    private WebElement composeButton;

    @FindBy(css = "[href='/drafts/']")
    private WebElement draftsButton;

    @FindBy(css = "[href='/sent/']")
    private WebElement sentButton;

    @FindBy(css = "[href='/1/']")
    private WebElement testButton;

    @FindBy(xpath = "//*[contains(@class, 'llc__item_correspondent')]//span")
    private List<WebElement> letterContactToItems;

    @FindBy(xpath = "//*[contains(@class, 'llc__subject')]//span")
    private List<WebElement> letterSubjectItems;

    @FindBy(xpath = "//*[contains(@class, 'llc__snippet')]//span")
    private List<WebElement> letterTextItems;

    @FindBy(css = "[data-testid='whiteline-account']")
    private WebElement accountButton;

    @FindBy(xpath = "//*[text() = 'Выйти']")
    private WebElement logoutButton;

    public MailTrashPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }

    public String getLetterContactTo(int letterIndex) {
        var letterContactTo = letterContactToItems.get(letterIndex);
        return letterContactTo.getAttribute("title");
    }

    public String getLetterSubject(int letterIndex) {
        var letterSubject = letterSubjectItems.get(letterIndex);
        return letterSubject.getText();
    }

    public String getLetterText(int letterIndex) {
        var letterText = letterTextItems.get(letterIndex);
        return letterText.getText();
    }

    public MailSentPage clickSentButton() {
        sentButton.click();
        return new MailSentPage(driver);
    }

    public MailDraftsPage clickDraftsButton() {
        draftsButton.click();
        return new MailDraftsPage(driver);
    }

    public MailTestPage clickTestButton() {
        testButton.click();
        return new MailTestPage(driver);
    }

    public void logout() {
        accountButton.click();
        logoutButton.click();
    }


}
