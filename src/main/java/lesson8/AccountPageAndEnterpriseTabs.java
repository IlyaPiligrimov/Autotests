package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AccountPageAndEnterpriseTabs {

    private SelenideElement windowFeedback = $(By.xpath("//a[@class='site_button long openmodal']"));
    private SelenideElement inputName = $(By.xpath("//input[@name='f_Name']"));
    private SelenideElement inputEmail = $(By.xpath("//input[@name='f_Mail']"));
    private SelenideElement inputPhone = $(By.xpath("//input[@name='f_Phone']"));

    private SelenideElement inputYourQuestions = $(By.xpath("//textarea"));
    private SelenideElement ButtonSend = $(By.xpath("//button[@class='site_button big']"));







@Step("Ввод и отправка данных в форму обратной связи")
    public SuccessPage enterpriseTabs() {


        windowFeedback.getWrappedElement().click();
        inputName.getWrappedElement().sendKeys("Jack");
        inputEmail.getWrappedElement().sendKeys("222222@gmail.com");
        inputPhone.getWrappedElement().sendKeys("89881111111");
        inputYourQuestions.getWrappedElement().sendKeys("This service is not good");
        ButtonSend.getWrappedElement().click();
        return page (SuccessPage.class) ;
    }
}
