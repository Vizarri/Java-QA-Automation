package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static Browser browser;
    private WebDriver webDriver;

    private Browser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");


        webDriver = new ChromeDriver(chromeOptions);
    }

    public static Browser getInstance() {
        if (browser == null) {
            browser = new Browser();
        }
        return browser;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void open(String url) {
        webDriver.get(url);
    }

    public void setImplicitWait(long time, TimeUnit timeUnit) {
        webDriver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    public void quitBrowser() {
        Browser.getInstance().getWebDriver().quit();
        browser = null;
    }
}
