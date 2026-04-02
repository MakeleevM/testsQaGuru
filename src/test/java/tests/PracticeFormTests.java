package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests extends BaseTest {
    @Test
    void registrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Antonio");
        $("#lastName").setValue("Montana");
        $("#userEmail").setValue("monta@na.na");

        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("4545667786");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("picture.png");
        $("#currentAddress").setValue("Russia/Moscow");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("Antonio Montana"));
        $(".modal-content").shouldHave(text("monta@na.na"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("4545667786"));
        $(".modal-content").shouldHave(text("Arts, Maths, Biology"));
        $(".modal-content").shouldHave(text("01 December,1998"));
        $(".modal-content").shouldHave(text("Music, Sports, Reading"));
        $(".modal-content").shouldHave(text("picture.png"));
        $(".modal-content").shouldHave(text("Russia/Moscow"));
        $(".modal-content").shouldHave(text("Haryana Karnal"));
    }

    @Test
    void requiredTestFields() {
        open("/automation-practice-form");
        $("#firstName").setValue("Max");
        $("#lastName").setValue("Verstappen");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("Max Verstappen"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("1234567890"));
    }

    @Test
    void negativeNameTest() {
        open("/automation-practice-form");
        $("#lastName").setValue("Verstappen");
        $("#userNumber").setValue("1234567890");
        $("#userEmail").setValue("monta@na.na");
        $("#genterWrapper").$(byText("Male")).click();
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeLastNameTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Max");
        $("#userNumber").setValue("1234567890");
        $("#userEmail").setValue("monta@na.na");
        $("#genterWrapper").$(byText("Male")).click();
        $("#submit").click();

        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeEmailTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Max");
        $("#lastName").setValue("Verstappen");
        $("#userNumber").setValue("1234567890");
        $("#userEmail").setValue("123");
        $("#genterWrapper").$(byText("Male")).click();
        $("#submit").click();

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void negativeGenderTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Max");
        $("#lastName").setValue("Verstappen");
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $("[id=gender-radio-1]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-2]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-3]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

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
        $("[id=gender-radio-1]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-2]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-3]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

}
