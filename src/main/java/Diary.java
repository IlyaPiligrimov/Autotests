import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Diary {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.farm.turborender.com/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("login")).sendKeys("222222223@gmail.com");//login

       driver.findElement(By.id("password")).sendKeys("123456");//password

Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]")).click();//вход




        driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[2]/a")).click();//вкладка платежи
        driver.manage().window().setSize(new Dimension(2000,1000));//изменение размера окна

        Thread.sleep(2000);



        driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[3]/a")).click();//вкладка профиль
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[4]/a")).click();//фм
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[5]/a")).click();//гпу
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[6]/a")).click();//инструкции
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/ul/li[7]/a")).click();//акции

        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.TAB);
        List<String> tables = new ArrayList<>(driver.getWindowHandles());//новая вкладка
        driver.switchTo().window(tables.get(1));
      driver.get("https://turborender.com/blog/");



        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[1]/div/div[3]/div[2]/div")).click();//смена языка


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[1]/div/div[3]/div[2]/ul/li[1]/a")).click();//смена языка

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/form/input[1]")).sendKeys("222222223@gmail.com");//password

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/form/button")).click();//подписка

        Thread.sleep(2000);
        driver.findElement(By.xpath(" //*[@id=\"success\"]/div/div[1]")).click();

        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(tables.get(0));


     driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[3]/i")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
