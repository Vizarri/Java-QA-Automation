package page.objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SteamCategories {

    private SelenideElement genreTab = $("#genre_tab");
    private SelenideElement action = $x("//a[@class='popup_menu_item' and contains(@href, 'action')]");


    public void clickGenreTab() {
        //отлавливаю ошибку так как при переходе с одного на другой язык тест валится
        try {
            genreTab.click();

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            genreTab.click();
        }
    }

    public void clickSpecificGenre() {
        action.click();
    }
}
