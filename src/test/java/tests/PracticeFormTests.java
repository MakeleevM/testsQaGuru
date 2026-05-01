package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static testdata.TestData.*;

public class PracticeFormTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationFormTest() {
        registrationPage.openPage()
                .removeBanners()
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
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genterWrapper)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dateOfBirth)
                .checkResult("Subjects", subjectArts + ", " + subjectMath + ", " + subjectBiology)
                .checkResult("Hobbies", hobbieSports + ", " + hobbieReading + ", " + hobbieMusic)
                .checkResult("Picture", nameOfFile)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void requiredTestFields() {
        registrationPage.openPage()
                .removeBanners()
                .practiceForm(messagePracticeForm)
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genterWrapper)
                .typeUserNumber(userNumber)
                .submitButton()
                .setModalWindow(messageAfterSubmitting)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", genterWrapper)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeNameTest() {
        registrationPage.openPage()
                .removeBanners()
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
                .removeBanners()
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
                .removeBanners()
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
                .removeBanners()
                .practiceForm(messagePracticeForm)
                .submitButton()
                .checkFieldResultError();
    }

}
