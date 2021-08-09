package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteOpener {
    String nameOfWebDriver;
    String driverLocation;
    String AUTOMATION_PRACTICE_URL;
    WebDriver webDriver;

    public WebsiteOpener(String webDriver, String driverLocation, String AUTOMATION_PRACTICE_URL) {
        this.nameOfWebDriver = webDriver;
        this.driverLocation = driverLocation;
        this.AUTOMATION_PRACTICE_URL = AUTOMATION_PRACTICE_URL;
    }

    public void openWebsite() {
        System.setProperty(nameOfWebDriver, driverLocation);
        webDriver = new ChromeDriver();
        webDriver.get(AUTOMATION_PRACTICE_URL);
    }


}
