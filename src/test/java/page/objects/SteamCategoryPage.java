package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SteamCategoryPage extends WebDriverSelect {

    private static final String PAGE_HEADER_LOC = "//*[@class='pageheader']";
    private static final String FIRST_GAME_IN_CAROUSEL_LOC = "//*[@id='genre_large_cluster']/div[@class='carousel_thumbs']//div[1]";
    private static final String FIRST_GAME_IN_CAROUSEL_PRICE_LOC = "//*[@id='genre_large_cluster']//a[1]//div[@class='discount_final_price']";
    // private static final String GO_TO_GAME_PAGE_SELECTOR = "div.bg";
    public static String gamePriceInPrevievText = null;

    public void checkThatHeaderVisible() {
        WebDriverWait pageHeaderWait = new WebDriverWait(webDriver, 10, 300);
        WebElement pageHeader = webDriver.findElement(By.xpath(PAGE_HEADER_LOC));
        pageHeaderWait.until(ExpectedConditions.visibilityOf(pageHeader));
    }

    public void CheckPriceFirstGame() {
        WebDriverWait genreTabWait = new WebDriverWait(webDriver, 10, 300);
        WebElement gameInPreviev = webDriver.findElement(By.xpath(FIRST_GAME_IN_CAROUSEL_LOC));
        genreTabWait.until(ExpectedConditions.visibilityOf(gameInPreviev));
        gameInPreviev.click();
        WebElement gamePriceInPreviev = webDriver.findElement(By.xpath(FIRST_GAME_IN_CAROUSEL_PRICE_LOC));
        this.gamePriceInPrevievText = gamePriceInPreviev.getText();
        WebElement gameBottonInPreviev = webDriver.findElement(By.xpath(FIRST_GAME_IN_CAROUSEL_PRICE_LOC));
        gameBottonInPreviev.click();
    }
}

