package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson7.CustomLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@Epic("Render Farm business card")
public class AutoTest {
    WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        System.out.println("Метод выполнился 1 раз перед всеми тестами класса");
    }

    @BeforeEach
    void beforeEach() {
        this.driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        new WebDriverWait(driver, Duration.ofSeconds(5));
        new Actions(driver);
        driver.manage().window().setSize(new Dimension(2000, 1000));//изменение размера окна
        driver.get("https://turborender.com/blog/");
        System.out.println("Метод выполняется перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка")
    @Feature("Визитка")
    @Story("Тест визитки ")
    public void languageCheckFr() {
        new LanguagePage(driver)
                .clickLanguage()
                .clickToTabs()
                .singIn()
                .enterpriseTabs();

        Assertions.assertAll(
                () -> Assertions.assertTrue(new AccountPageAndEnterpriseTabs(driver).messageThanks.isDisplayed()),
                () -> Assertions.assertFalse(new AccountPageAndEnterpriseTabs(driver).messageThanksText.isDisplayed())
        );


    }

    @AfterEach
    void afterEach() {
        LogEntries logEntries = (driver.manage().logs().get(LogType.BROWSER));
        for (LogEntry logEntry : logEntries){
            Allure.addAttachment("Element", logEntry.getMessage());
        }
        driver.quit();
    }

}
