package lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuccessPage {

     private SelenideElement messageThanks = $(By.xpath("//div[@class='closebut']"));
     private SelenideElement messageThanksText = $(By.xpath("//div[@id='suctext']"));


     public void check (){




          Assertions.assertAll(
                  () -> messageThanks.shouldBe(visible),
                  () -> messageThanksText.shouldBe(visible)
          );
     }
}
