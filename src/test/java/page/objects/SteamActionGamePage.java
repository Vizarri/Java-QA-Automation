package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SteamActionGamePage extends WebDriverSelect {

    private static final String ACTUAL_GAME_PRICE = "//*[@class='game_area_purchase_game_wrapper' or @class='game_area_purchase_game ']//div[@class='game_purchase_price price'or @class='discount_final_price' or @class='game_purchase_price price']";
    public static String actualGamePrice = null;


    public void checkPriceOfTheGameInPage() {
        WebDriverWait pageHeaderWait = new WebDriverWait(webDriver, 10, 300);
        WebElement gamePrice = webDriver.findElement(By.xpath(ACTUAL_GAME_PRICE));
        pageHeaderWait.until(ExpectedConditions.visibilityOf(gamePrice));
        this.actualGamePrice = gamePrice.getText();
    }
}
