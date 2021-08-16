package actions;

import page.objects.SteamActionGamePage;
import page.objects.SteamCategories;
import page.objects.SteamCategoryPage;
import page.objects.SteamLanguage;

public class ActionsCompare {
    public static String priceInPreviev;
    public static String priceInGamePage;

    public static void englishChecker() {
        SteamLanguage steamLanguage = new SteamLanguage();
        steamLanguage.changeEnglishLanguage();
    }

    public static void priceСomparison() {
        SteamCategories steamCategories = new SteamCategories();
        SteamCategoryPage steamCategoryPage = new SteamCategoryPage();
        SteamActionGamePage steamActionGamePage = new SteamActionGamePage();

        steamCategories.clickGenreTab();
        steamCategories.clickSpecificGenre();

        steamCategoryPage.checkThatHeaderVisible();
        steamCategoryPage.CheckPriceFirstGame();
        priceInPreviev = SteamCategoryPage.gamePriceInPrevievText;
        steamActionGamePage.checkPriceOfTheGameInPage();
        priceInGamePage = steamActionGamePage.actualGamePrice;

    }
}
