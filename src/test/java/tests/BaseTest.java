package tests;

import com.codeborne.selenide.Selenide;
import contains.Urls;
import io.cucumber.java.en.Given;

public class BaseTest {

    @Given("Открыл сайт стима")
    public void setUp() {
        Selenide.open(Urls.ACTION_URL);
    }
}
