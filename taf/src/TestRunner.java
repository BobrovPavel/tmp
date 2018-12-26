import org.testng.TestNG;

import java.util.Arrays;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testNg = new TestNG();
        List<String> suites = Arrays.asList("testng.xml");
        testNg.setTestSuites(suites);
        testNg.run();
    }
}
