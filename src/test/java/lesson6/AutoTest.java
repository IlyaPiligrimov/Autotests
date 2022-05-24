package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoTest {
    WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        System.out.println("Метод выполнился 1 раз перед всеми тестами класса");
    }

    @BeforeEach
    void beforeEach() {
        this.driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        driver.manage().window().setSize(new Dimension(2000, 1000));//изменение размера окна
        driver.get("https://turborender.com/blog/");
        LanguagePage languagePage;
        BasePage basePage;
        NavigationPage navigationPage;
        System.out.println("Метод выполняется перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка")
    public void languageCheckFr() throws InterruptedException {
        new LanguagePage(driver)
                .clickLanguage()
                .clickToTabs()
                .singIn()
                .enterpriseTabs();

        Assertions.assertAll(
                () -> Assertions.assertTrue(new AccountPageAndEnterpriseTabs(driver).messageThanks.isDisplayed()),
                () -> Assertions.assertEquals(new AccountPageAndEnterpriseTabs(driver).messageThanksText.isDisplayed(), false)
        );


    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }

}
