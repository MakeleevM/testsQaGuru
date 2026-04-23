package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;
import static testdata.TestData.userNumber;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber");

    public void openPage() {
        open("/automation-practice-form");
    }

    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public RegistrationPage setEmail(String userEmail) {
        emailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage setGender(String genterWrapper) {
        genderInput.$(byText(genterWrapper)).click();

        return this;
    }

    public RegistrationPage setUserNumber (String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

}
