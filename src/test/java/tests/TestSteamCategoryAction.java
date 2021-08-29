package tests;

import actions.ActionsCompare;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class TestSteamCategoryAction {

    @When("проверил язык сайта, если не английский - сменил на английский")
    public void testSteamCategoryActionEnglishChecker() {
        ActionsCompare.englishChecker();
    }

    @And("открыл пункт с категориями, выбрал категорию Action и выбрал самую первую игру в карусели")
    public void testSteamCategoryActionPriceСomparison() {
        ActionsCompare.priceСomparison();
    }

    @Then("проверил совпадение цен на странице с игрой и цены из карусели")
    public void testSteamCategoryActionAssertEquals() {
        Assertions.assertEquals(ActionsCompare.priceInPreviev, ActionsCompare.priceInGamePage);
    }
}
