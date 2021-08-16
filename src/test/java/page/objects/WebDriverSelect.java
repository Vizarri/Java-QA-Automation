package page.objects;

import framework.Browser;
import org.openqa.selenium.WebDriver;

public abstract class WebDriverSelect {
    protected WebDriver webDriver;

    public WebDriverSelect() {
        this.webDriver = Browser.getInstance().getWebDriver();
    }

}
