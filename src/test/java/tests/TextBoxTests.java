package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends BaseTest {

    String userName = "Alex Black";
    String userEmail = "alex@black.com";
    String currentAddress = "first address 1";
    String permanentAddress = "second address 2";

    @Test
    void successfullFillFormTest() {
        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }

    @Test
    void successfullFillFormWithoutAddressTest() {
        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#submit").click();

        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
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
        $("#userName").setValue(userName);
        $("#submit").click();

        $("#output #name").shouldHave(text(userName));
    }
}
