package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageAndEnterpriseTabs extends BasePage {
    public AccountPageAndEnterpriseTabs(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@class='site_button long openmodal']")
    public WebElement windowFeedback;

    @FindBy(xpath = "//input[@name='f_Name']")
    public WebElement inputName;

    @FindBy(xpath = "//input[@name='f_Mail']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@name='f_Phone']")
    public WebElement inputPhone;

    @FindBy(xpath = "//textarea")
    public WebElement inputYourQuestions;

    @FindBy(xpath = "//button[@class='site_button big']")
    public WebElement ButtonSend;

    @FindBy(xpath = "//div[@class='closebut']")
    public WebElement messageThanks;

    @FindBy(xpath = "//div[@id='suctext']")
    public WebElement messageThanksText;

@Step("Ввод и отправка данных в форму обратной связи")
    public LanguagePage enterpriseTabs() {
        driver.get("https://turborender.com/fr/enterprise/");
        actions.moveToElement(windowFeedback).click().build().perform();
        actions.moveToElement(inputName).click().sendKeys("Jack").build().perform();
        actions.moveToElement(inputEmail).click().sendKeys("222222@gmail.com").build().perform();
        actions.moveToElement(inputPhone).click().sendKeys("89881111111").build().perform();
        actions.moveToElement(inputYourQuestions).click().sendKeys("This service is not good").build().perform();
        actions.moveToElement(ButtonSend).click().build().perform();
        return new LanguagePage(driver);
    }
}
