package tests;

import com.codeborne.selenide.Selenide;
import contains.Urls;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        Selenide.open(Urls.ACTION_URL);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
