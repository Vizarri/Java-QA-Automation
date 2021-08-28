package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SteamActionGamePage {
    private SelenideElement actualGamePrice = $x("//*[@class='game_area_purchase_game_wrapper' or @class='game_area_purchase_game ']//div[@class='game_purchase_price price'or @class='discount_final_price' or @class='game_purchase_price price']");

    public static String actualGamePriceValue = null;


    public void checkPriceOfTheGameInPage() {
        actualGamePrice.shouldBe(Condition.visible);
        actualGamePriceValue = actualGamePrice.getText();
    }
}
