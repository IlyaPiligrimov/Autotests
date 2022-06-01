package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends BasePage {

    public NavigationPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//header")
    private WebElement menu;

    @FindBy(xpath = "//div[@class='topmenu']/ul/li[1]")
    private WebElement features;

    @FindBy(xpath = "//div[@class='topmenu']/ul/li[2]")
    private WebElement prices;

    @FindBy(xpath = "//div[@class='topmenu']/ul/li[3]")
    private WebElement useCases;

    @FindBy(xpath = "//div[@class='topmenu']/ul/li[4]")
    private WebElement enterprise;

    @FindBy(xpath = "//div[@class='topmenu']/ul/li[5]")
    private WebElement desktopApp;

@Step("Клик на все вкладки меню")
    public SingInPage clickToTabs() {

        actions.moveToElement(menu).moveToElement(features).click().build().perform();
        actions.moveToElement(prices).click().build().perform();
        actions.moveToElement(useCases).click().build().perform();
        actions.moveToElement(enterprise).click().build().perform();
        actions.moveToElement(desktopApp).click().build().perform();
        return new SingInPage(driver);
    }
}



