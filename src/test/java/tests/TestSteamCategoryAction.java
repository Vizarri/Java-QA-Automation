package tests;

import actions.ActionsCompare;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSteamCategoryAction extends BaseTest {

    @Test
    public void testSteamCategoryAction() {
        ActionsCompare.englishChecker();
        ActionsCompare.priceСomparison();

        Assertions.assertEquals(ActionsCompare.priceInPreviev, ActionsCompare.priceInGamePage);

    }
}
