package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SteamLanguage {


    private SelenideElement steamLanguage = $x("//*[@id='language_pulldown']");
    private SelenideElement steamEnglishLanguage = $x("//*[@id='language_dropdown']/div/a[@href='?l=english']");

    public static String currentLanguage;

    public void
    changeEnglishLanguage() {
        steamLanguage.shouldBe(Condition.visible);
        currentLanguage = steamLanguage.getText();
        if (currentLanguage != "language") {
            steamLanguage.click();
            steamEnglishLanguage.click();
        }
    }
}
