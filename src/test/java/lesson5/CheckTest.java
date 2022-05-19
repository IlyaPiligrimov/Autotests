package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static java.lang.Thread.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Action action;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        System.out.println("Метод выполнился 1 раз перед всеми тестами класса");
    }

    @BeforeEach
    void beforeEach() {
        this.driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        driver.manage().window().setSize(new Dimension(2000, 1000));//изменение размера окна
        driver.get("https://turborender.com/blog/");
        System.out.println("Метод выполняется перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка смены языка на французкий")
    public void languageCheckFr() {
        driver.findElement(By.xpath("//div[@class='lang']")).click();
        driver.findElement(By.xpath("//span[text()='Fr']")).click();
        assertTrue(driver.getCurrentUrl().contains("fr/blog/"));
    }

    @Test
    @DisplayName("Смена языка на турецкий")
    public void languageCheckTr() {
        driver.findElement(By.xpath("//div[@class='lang']")).click();//смена языка
        driver.findElement(By.xpath("//span[text()='Tr']")).click();
        assertFalse(driver.getCurrentUrl().contains("fr/blog/"));
    }

    @Test
    @DisplayName("Проверка ввода и отправки")
    public void inputEditCheck() {
        driver.findElement(By.xpath("//div[1]/form/input[1]")).sendKeys("222222223@gmail.com");
        driver.findElement(By.xpath("//button[1]")).click();
        assertFalse(driver.findElement(By.id("success")).isDisplayed());
    }

    @Test
    @DisplayName("Авторизация")
    public void singInCheck() {
        driver.findElement(By.xpath("//header/div/div[1]/div/div[3]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("222222223@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@class='site_button block']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//div[@class='header__exit']")).click();
        assertTrue(driver.getCurrentUrl().contains("auth/login"));
    }

    @Test
    @DisplayName("Вкладка цены")
    public void priceCheck() {
        driver.findElement(By.xpath("//a[@href='/prices/']")).click();
        driver.findElement(By.xpath("//a[@class='site_button padding ']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        assertTrue(driver.findElement(By.xpath("//button[@class='site_button block']")).isDisplayed());
    }

    @Test
    @DisplayName("Проверка обратной связи")
    public void enterpriseCheck() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/enterprise/']")).click();
        driver.findElement(By.xpath("//a[@class='site_button long openmodal']")).click();
        driver.findElement(By.xpath("//input[@name='f_Name']")).sendKeys("Иванов");
        driver.findElement(By.xpath("//input[@name='f_Mail']")).sendKeys("222222223@gmail.com");
        driver.findElement(By.xpath("//input[@name='f_Phone']")).sendKeys("89822222222");
        driver.findElement(By.xpath("//textarea")).sendKeys("service good");
        driver.findElement(By.xpath("//button[@class='site_button big']")).click();
        Thread.sleep(5000);
        assertFalse(driver.findElement(By.xpath("//div[@class='closebut']")).isDisplayed());
    }


    @AfterEach
    void afterEach() {
        driver.quit();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполнилнится после всех тестов");
    }

}

