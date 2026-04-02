package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends BaseTest {

    @Test
    void successfullFillFormTest() {
        open("/text-box");
        $("#userName").setValue("Alex Black");
        $("#userEmail").setValue("alex@black.com");
        $("#currentAddress").setValue("first address 1");
        $("#permanentAddress").setValue("second address 2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex Black"));
        $("#output #email").shouldHave(text("alex@black.com"));
        $("#output #currentAddress").shouldHave(text("first address 1"));
        $("#output #permanentAddress").shouldHave(text("second address 2"));
    }

    @Test
    void negativeFillFormTest() {
        open("/text-box");
        $("#userEmail").setValue("123");
        $("#submit").click();
        $(".field-error").shouldHave(visible);
    }

    @Test
    void miniFieldTest() {
        open("/text-box");
        $("#userName").setValue("Aaron");
        $("#submit").click();

        $("#output #name").shouldHave(text("Aaron"));
    }
}
