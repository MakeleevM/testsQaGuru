package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests extends BaseTest {
    @Test
    void registrationFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Antonio");
        $("[id=lastName]").setValue("Montana");
        $("[id=userEmail]").setValue("monta@na.na");

        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("4545667786");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__day--001").click();
        $("[id=subjectsInput]").setValue("Arts").pressEnter();
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
        $("[id=subjectsInput]").setValue("Biology").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=hobbies-checkbox-2]").click();
        $("[id=hobbies-checkbox-3]").click();
        $("[id=uploadPicture]").uploadFromClasspath("picture.png");
        $("[id=currentAddress]").setValue("Russia/Moscow");
        $("[id=react-select-3-input]").setValue("Haryana").pressEnter();
        $("[id=react-select-4-input]").setValue("Karnal").pressEnter();
        $("[id=submit]").click();


        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("Antonio Montana"));
        $(".modal-content").shouldHave(text("monta@na.na"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("4545667786"));
        $(".modal-content").shouldHave(text("Arts, Maths, Biology"));
        $(".modal-content").shouldHave(text("01 December,1998"));
        $(".modal-content").shouldHave(text("Sports, Reading, Music"));
        $(".modal-content").shouldHave(text("picture.png"));
        $(".modal-content").shouldHave(text("Russia/Moscow"));
        $(".modal-content").shouldHave(text("Haryana Karnal"));
    }

    @Test
    void requiredTestFields() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Max");
        $("[id=lastName]").setValue("Verstappen");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("1234567890");
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("Max Verstappen"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("1234567890"));
    }

    @Test
    void negativeNameTest() {
        open("/automation-practice-form");
        $("[id=lastName]").setValue("Verstappen");
        $("[id=userNumber]").setValue("1234567890");
        $("[id=userEmail]").setValue("monta@na.na");
        $("[id=gender-radio-1]").click();
        $("[id=submit]").click();

        $("[id=firstName]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeLastNameTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Max");
        $("[id=userNumber]").setValue("1234567890");
        $("[id=userEmail]").setValue("monta@na.na");
        $("[id=gender-radio-1]").click();
        $("[id=submit]").click();

        $("[id=lastName]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void negativeEmailTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Max");
        $("[id=lastName]").setValue("Verstappen");
        $("[id=userNumber]").setValue("1234567890");
        $("[id=userEmail]").setValue("123");
        $("[id=gender-radio-1]").click();
        $("[id=submit]").click();

        $("[id=userEmail]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void negativeGenderTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Max");
        $("[id=lastName]").setValue("Verstappen");
        $("[id=userNumber]").setValue("1234567890");
        $("[id=submit]").click();

        $("[id=gender-radio-1]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-2]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-3]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void negativeTestOfAllFields() {
        open("/automation-practice-form");
        $("[id=userEmail]").setValue("123");
        $("[id=submit]").click();
        $("[id=firstName]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=lastName]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=userEmail]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=userNumber]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-1]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-2]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-3]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

}
