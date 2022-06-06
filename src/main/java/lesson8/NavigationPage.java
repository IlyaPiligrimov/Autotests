package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class NavigationPage  {



    private SelenideElement menu = $(By.xpath("//header"));
    private SelenideElement features = $(By.xpath("//div[@class='topmenu']/ul/li[1]"));
    private SelenideElement prices = $(By.xpath("//div[@class='topmenu']/ul/li[2]"));
    private SelenideElement useCases = $(By.xpath("//div[@class='topmenu']/ul/li[3]"));
    private SelenideElement enterprise = $(By.xpath("//div[@class='topmenu']/ul/li[4]"));
    private SelenideElement desktopApp = $(By.xpath("//div[@class='topmenu']/ul/li[5]"));






@Step("Клик на все вкладки меню")
    public SingInPage clickToTabs() {

        menu.hover();
        prices.hover();
        useCases.hover();
        enterprise.hover();
       desktopApp.hover();
        return page (SingInPage.class);
    }
}



