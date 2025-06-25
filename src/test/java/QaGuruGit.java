import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QaGuruGit {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
    }

    @AfterEach
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    void gitTest(){
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprises")).click();

        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }

    @Test
    void dragDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));

        Selenide.actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();

        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }

    @Test
    void dragDropTestWithCommand(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));

        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }
}
