package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class PracticeFormTests extends BaseTest {
    @Test
    void registrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);

        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjectArts).pressEnter();
        $("#subjectsInput").setValue(subjectMath).pressEnter();
        $("#subjectsInput").setValue(subjectBiology).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbieMusic)).click();
        $("#hobbiesWrapper").$(byText(hobbieSports)).click();
        $("#hobbiesWrapper").$(byText(hobbieReading)).click();
        $("#uploadPicture").uploadFromClasspath(nameOfFile);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(country).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text(firstName));
        $(".modal-content").shouldHave(text(lastName));
        $(".modal-content").shouldHave(text(userEmail));
        $(".modal-content").shouldHave(text(genterWrapper));
        $(".modal-content").shouldHave(text(userNumber));
        $(".modal-content").shouldHave(text(subjectArts));
        $(".modal-content").shouldHave(text(subjectMath));
        $(".modal-content").shouldHave(text(subjectBiology));
        $(".modal-content").shouldHave(text(dayOfBirth));
        $(".modal-content").shouldHave(text(monthOfBirth));
        $(".modal-content").shouldHave(text(yearOfBirth));
        $(".modal-content").shouldHave(text(hobbieMusic));
        $(".modal-content").shouldHave(text(hobbieReading));
        $(".modal-content").shouldHave(text(hobbieSports));
        $(".modal-content").shouldHave(text(nameOfFile));
        $(".modal-content").shouldHave(text(currentAddress));
        $(".modal-content").shouldHave(text(country));
        $(".modal-content").shouldHave(text(city));
    }

    @Test
    void requiredTestFields() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text(firstName));
        $(".modal-content").shouldHave(text(lastName));
        $(".modal-content").shouldHave(text(genterWrapper));
        $(".modal-content").shouldHave(text(userNumber));
    }

    @Test
    void negativeNameTest() {
        open("/automation-practice-form");
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeLastNameTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#userNumber").setValue(userNumber);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#submit").click();

        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeEmailTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
        $("#userEmail").setValue("123");
        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#submit").click();

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void negativeGenderTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#gender-radio-1").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-2").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-3").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void negativeTestOfAllFields() {
        open("/automation-practice-form");
        $("#userEmail").setValue("123");
        $("#submit").click();
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-1").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-2").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-3").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

}
