import org.junit.jupiter.api.*;

public class JUnit5ExamplesTest {

    @BeforeAll
    static void startup () {
        System.out.println("tests startup");
    }

    @AfterAll
    static void teardown () {
        System.out.println("tests ended");
    }

    @BeforeEach
    void startBrowser () {
        System.out.println("browser has started");
    }
    @AfterEach
    void stopBrowser () {
        System.out.println("browser has stopped");
    }

    @Test
    void firstTest () {
        System.out.println("firstTest");
    }

    @Test
    void secondTest () {
        System.out.println("secondTest");
        System.out.println("HELLO MY FRIENDS");
        System.out.println("Create new branch");
        System.out.println("!!!!!!!!!!!!!!!");
    }
}
