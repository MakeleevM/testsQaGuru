package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.TextBoxPage;
import testdata.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    protected static TextBoxPage textBoxPage = new TextBoxPage();
    protected TestData testData;

    @BeforeAll
    static void setupSelenideConfig() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://qa-guru.github.io";
    }

    @BeforeEach
    void initTestData() {
        testData = new TestData();
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}
