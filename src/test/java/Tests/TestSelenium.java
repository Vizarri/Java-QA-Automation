package Tests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class TestSelenium {
    private WebDriver webDriver;
    private static final String AUTOMATION_PRACTICE_URL = "http://automationpractice.com/index.php";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(AUTOMATION_PRACTICE_URL);
    }

    @ParameterizedTest
    @ArgumentsSource(Arguments.class)
    public void testSelenium(String button, String title, String trueTitle) {
        WebElement webElement = webDriver.findElement(By.xpath(button));
        webElement.click();
        WebElement titleCatalog = webDriver.findElement(By.cssSelector(title));
        String titleText = titleCatalog.getText();
        Assert.assertTrue(titleText.toLowerCase().contains(trueTitle));
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
