package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SingInPage {


    private final SelenideElement login = $(By.xpath("//input[@name='login']"));
    private final SelenideElement password = $(By.xpath("//input[@name='password']"));
    private final SelenideElement buttonSingIn = $(By.xpath("//button[@class='site_button block']"));
    private final SelenideElement singInbuttonRedirect = $(By.xpath("//header/div/div[1]/div/div[3]/div[1]/a[1]"));


    @Step("Авторизация")
    public AccountPageAndEnterpriseTabs singIn(String logins,String passwords)  {





        singInbuttonRedirect.getWrappedElement().findElement(By.xpath("//header/div/div[1]/div/div[3]/div[1]/a[1]")).click();
        login.getWrappedElement().click();
        login.getWrappedElement().sendKeys(logins);
        password.getWrappedElement().click();
        password.getWrappedElement().sendKeys(passwords);
        buttonSingIn.getWrappedElement().click();


        return page(AccountPageAndEnterpriseTabs.class);
    }


}

