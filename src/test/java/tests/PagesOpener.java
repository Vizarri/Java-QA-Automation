package tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PagesOpener {
    WebsiteOpener websiteOpener = new WebsiteOpener("webdriver.chrome.driver", "src/test/resources/chromedriver.exe", Urls.AUTOMATION_PRACTICE_URL);

    @BeforeEach
    public void setUp() {
        websiteOpener.openWebsite();
    }

    @ParameterizedTest
    @ArgumentsSource(ArgumentsForParameterization.class)
    public void testSelenium(String button, String title, String trueTitle) {
        WebElement webElement = websiteOpener.webDriver.findElement(By.xpath(button));
        webElement.click();
        WebElement titleCatalog = websiteOpener.webDriver.findElement(By.cssSelector(title));
        String titleText = titleCatalog.getText();
        Assertions.assertTrue(titleText.toLowerCase().contains(trueTitle));
    }

    @AfterEach
    public void tearDown() {
        websiteOpener.webDriver.quit();
    }
}
