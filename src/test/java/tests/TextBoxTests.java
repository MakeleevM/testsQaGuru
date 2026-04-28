package tests;

import org.junit.jupiter.api.Test;

import static testdata.TestData.*;

public class TextBoxTests extends BaseTest {

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
        textBoxPage.openPage()
                .typeUserEmail(userEmailBad)
                .submitButton()
                .checkFieldError();
    }

    @Test
    void miniFieldTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .submitButton()
                .checkField("name", userName);
    }
}
