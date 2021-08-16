package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SteamLanguage extends WebDriverSelect {
    private static final String LANGUAGE_LOC = "//*[@id='language_pulldown']";
    private static final String ENGLISH_LANGUAGE_LOC = "//*[@id='language_dropdown']/div/a[@href='?l=english']";
    public static String currentLanguage;

    public void
    changeEnglishLanguage() {
        WebDriverWait checkСurrentLanguageWait = new WebDriverWait(webDriver, 10, 300);
        WebElement currentLanguageElement = webDriver.findElement(By.xpath(LANGUAGE_LOC));
        checkСurrentLanguageWait.until(ExpectedConditions.visibilityOf(currentLanguageElement));
        currentLanguage = currentLanguageElement.getText();
        if (currentLanguage != "language") {
            currentLanguageElement.click();
            WebDriverWait englishLanguageWait = new WebDriverWait(webDriver, 10, 300);
            WebElement englishLanguageButtonElement = webDriver.findElement(By.xpath(ENGLISH_LANGUAGE_LOC));
            englishLanguageButtonElement.click();
            englishLanguageWait.until(ExpectedConditions.visibilityOf(englishLanguageButtonElement));
        }
    }
}
