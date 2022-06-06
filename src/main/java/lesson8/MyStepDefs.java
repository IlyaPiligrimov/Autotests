package lesson8;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static com.codeborne.selenide.Selenide.open;

public class MyStepDefs {

    @When("ClickLanguage")
    public void clicklanguage() {
        open("https://turborender.com/");

        new LanguagePage().clickLanguage();

    }

    @And("ClickToTabs")
    public void clicktotabs() {
        new NavigationPage().clickToTabs();

    }

    @When("SingIn  {string},{string}")
    public void singinLogins() throws Throwable {
        new SingInPage().singIn("222222223@gmail.com","123456");

    }


    @And("FeedBack")
    public void feedback() {
        open("https://turborender.com/fr/enterprise/");
        new AccountPageAndEnterpriseTabs().enterpriseTabs();
    }

    @Then("Check")
    public void check() {
        new SuccessPage().check();

    }



    @After(value = "@close")
    public void quitBrowser(){
        Selenide.closeWebDriver();
    }


}
