package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SystemPropertiesTest extends TestBase{

    @Test
    public void testWebDriver() {
        open("https://github.com/");
        step("Check title", () -> {
            $(".font-mktg").shouldHave(text(" Where the world builds software ")) ;
        });
    }
}
