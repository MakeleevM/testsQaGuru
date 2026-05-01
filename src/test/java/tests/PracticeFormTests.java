package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.TestData;

import static testdata.TestData.messageAfterSubmitting;
import static testdata.TestData.messagePracticeForm;

public class PracticeFormTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void registrationFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .practiceForm(messagePracticeForm)
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserEmail(testData.userEmail)
                .setGender(testData.genderWrapper)
                .typeUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubjects(testData.subjects)
                .setHobbiesWrapper(testData.hobbies)
                .setUploadPicture(testData.uploadfile)
                .setCurrentAddress(testData.currentAddress)
                .setStateAndCity(testData.state, testData.city)
                .submitButton()
                .setModalWindow(messageAfterSubmitting)
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.genderWrapper)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.year + "-" + testData.monthNumber + "-" + testData.day)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.uploadfile)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    void requiredTestFields() {
        registrationPage.openPage()
                .removeBanners()
                .practiceForm(messagePracticeForm)
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.genderWrapper)
                .typeUserNumber(testData.userNumber)
                .submitButton()
                .setModalWindow(messageAfterSubmitting)
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.genderWrapper)
                .checkResult("Mobile", testData.userNumber);
    }

    @Test
    void negativeWrongEmailTest() {
        registrationPage.openPage()
                .removeBanners()
                .practiceForm(messagePracticeForm)
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserNumber(testData.userNumber)
                .typeUserEmail(testData.wrongEmail)
                .setGender(testData.genderWrapper)
                .submitButton()
                .checkFieldResultError();
    }

    @Test
    void negativeWrongNumberTest() {
        registrationPage.openPage()
                .removeBanners()
                .practiceForm(messagePracticeForm)
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserNumber(testData.wrongNumber)
                .typeUserEmail(testData.userEmail)
                .setGender(testData.genderWrapper)
                .submitButton()
                .checkFieldResultError();
    }

}
