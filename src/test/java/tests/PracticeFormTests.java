package tests;

import org.junit.jupiter.api.Test;
import static testdata.TestData.*;
public class PracticeFormTests extends BaseTest {

    @Test
    void registrationFormTest() {
        registrationPage.openPage()
                .practiceForm(messagePracticeForm)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(genterWrapper)
                .typeUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjectArts)
                .setSubjects(subjectMath)
                .setSubjects(subjectBiology)
                .setHobbiesWrapper(hobbieMusic)
                .setHobbiesWrapper(hobbieSports)
                .setHobbiesWrapper(hobbieReading)
                .setUploadPicture()
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitButton()
                .setModalWindow(messageAfterSubmitting)
                .checkFieldResult("Student Name", firstName + " " + lastName)
                .checkFieldResult("Student Email", userEmail)
                .checkFieldResult("Gender", genterWrapper)
                .checkFieldResult("Mobile", userNumber)
                .checkFieldResult("Date of Birth", dateOfBirth)
                .checkFieldResult("Subjects", subjectArts + ", " + subjectMath + ", " + subjectBiology)
                .checkFieldResult("Hobbies", hobbieSports + ", " + hobbieReading + ", " + hobbieMusic)
                .checkFieldResult("Picture", nameOfFile)
                .checkFieldResult("Address", currentAddress)
                .checkFieldResult("State and City", state + " " + city);
    }

    @Test
    void requiredTestFields() {
        registrationPage.openPage()
                .practiceForm(messagePracticeForm)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genterWrapper)
                .typeUserNumber(userNumber)
                .submitButton()
                .setModalWindow(messageAfterSubmitting)
                .checkFieldResult("Student Name", firstName + " " + lastName)
                .checkFieldResult("Gender", genterWrapper)
                .checkFieldResult("Mobile", userNumber);
    }

    @Test
    void negativeNameTest() {
        registrationPage.openPage()
                .practiceForm(messagePracticeForm)
                .typeLastName(lastName)
                .typeUserNumber(userNumber)
                .typeUserEmail(userEmail)
                .setGender(genterWrapper)
                .submitButton()
                .checkFieldResultError();
    }

    @Test
    void negativeLastNameTest() {
        registrationPage.openPage()
                .practiceForm(messagePracticeForm)
                .typeFirstName(firstName)
                .typeUserNumber(userNumber)
                .typeUserEmail(userEmail)
                .setGender(genterWrapper)
                .submitButton()
                .checkFieldResultError();
    }

    @Test
    void negativeGenderTest() {
        registrationPage.openPage()
                .practiceForm(messagePracticeForm)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserNumber(userNumber)
                .submitButton()
                .checkFieldResultError();
    }

    @Test
    void negativeTestOfAllFields() {
        registrationPage.openPage()
                .practiceForm(messagePracticeForm)
                .submitButton()
                .checkFieldResultError();
    }

}
