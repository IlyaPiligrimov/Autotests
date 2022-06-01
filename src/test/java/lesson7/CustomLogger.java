package lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class CustomLogger implements WebDriverListener {
    private static Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("Search element" + locator.toString());
        Allure.step("Search" + locator.toString());
        Allure.addAttachment("Screnshot",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }
}
