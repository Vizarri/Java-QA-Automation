package tests;

import contains.Urls;
import framework.Browser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        Browser browser = Browser.getInstance();

        browser.open(Urls.ACTION_URL);
        browser.setImplicitWait(0, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        Browser.getInstance().getWebDriver();
        Browser.getInstance().quitBrowser();
    }
}
