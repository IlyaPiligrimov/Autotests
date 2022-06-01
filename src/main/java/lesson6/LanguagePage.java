package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguagePage extends BasePage {

    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='lang']")
    public WebElement languageList;

    @FindBy(xpath = "//span[text()='Fr']")
    public WebElement langFr;

    @FindBy(xpath = "//span[text()='Tr']")
    public WebElement langTr;
@Step("Смена языка на Турецкий, затем на Французский")
    public NavigationPage clickLanguage() {
        actions.moveToElement(languageList).click()
                .moveToElement(langTr).click()
                .build().perform();

        actions.moveToElement(languageList).click()
                .moveToElement(langFr).click()
                .build().perform();

        return new NavigationPage(driver);

    }

}







