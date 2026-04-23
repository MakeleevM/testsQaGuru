package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class TextBoxTests extends BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfullFillFormTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitButton()
                .checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);

    }

    @Test
    void successfullFillFormWithoutAddressTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .submitButton()
                .checkField("name", userName)
                .checkField("email", userEmail);
    }

    @Test
    void successfullFillFormWithoutAddressTest_chaining() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .submitButton()
                .checkField("name", userName)
                .checkField("email", userEmail);
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
