package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LanguagePage  {


    private SelenideElement languageList = $(By.xpath("//div[@class='lang']"));
    private SelenideElement langFr = $(By.xpath("//span[text()='Fr']"));
    private SelenideElement langTr = $(By.xpath("//span[text()='Tr']"));



@Step("Смена языка на Турецкий, затем на Французский")
    public NavigationPage clickLanguage() {

    languageList.getWrappedElement().click();
    langFr.getWrappedElement().click();
    languageList.getWrappedElement().click();
    langTr.getWrappedElement().click();

        return page (NavigationPage.class);

    }

}







