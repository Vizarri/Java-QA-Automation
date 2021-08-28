package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SteamCategoryPage {

    private SelenideElement pageHeader = $x("//*[@class='pageheader']");
    private SelenideElement firstGameInCarousel = $x("//*[@id='genre_large_cluster']/div[@class='carousel_thumbs']//div[1]");
    private SelenideElement firstGameInCarouselPrice = $x("//*[@id='genre_large_cluster']//a[1]//div[@class='discount_final_price']");


    public static String gamePriceInPrevievText = null;

    public void checkThatHeaderVisible() {
        pageHeader.shouldBe(Condition.visible);
    }

    public void CheckPriceFirstGame() {
        firstGameInCarousel.click();

        this.gamePriceInPrevievText = firstGameInCarouselPrice.getText();
        firstGameInCarouselPrice.click();
    }
}

