package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SteamCategories extends WebDriverSelect {
    private static final String GENRE_TAB_SELECTOR = "#genre_tab";
    private static final String ACTION_LOC = "//a[@class='popup_menu_item' and contains(@href, 'action')]";


    public void clickGenreTab() {
        //отлавливаю ошибку так как при переходе с одного на другой язык тест валится
        try {
            WebDriverWait genreTabWait = new WebDriverWait(webDriver, 10, 300);
            WebElement genreTab = webDriver.findElement(By.cssSelector(GENRE_TAB_SELECTOR));
            genreTabWait.until(ExpectedConditions.visibilityOf(genreTab));
            genreTab.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebDriverWait genreTabWait = new WebDriverWait(webDriver, 10, 300);
            WebElement genreTab = webDriver.findElement(By.cssSelector(GENRE_TAB_SELECTOR));
            genreTabWait.until(ExpectedConditions.visibilityOf(genreTab));
            genreTab.click();
        }
    }

    public void clickSpecificGenre() {
        WebDriverWait actionWait = new WebDriverWait(webDriver, 10, 300);
        WebElement actionElement = webDriver.findElement(By.xpath(ACTION_LOC));
        actionWait.until(ExpectedConditions.visibilityOf(actionElement));
        actionElement.click();
    }
}
