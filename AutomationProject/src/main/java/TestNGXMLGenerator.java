import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestNGXMLGenerator {

    public static void main(String[] args) {
        // Create an instance of XmlSuite
        XmlSuite suite = new XmlSuite();
        suite.setName("MySuite");

        // Create an instance of XmlTest
        XmlTest test = new XmlTest(suite);
        test.setName("MyTest");

        // Add classes to the test
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("com.example.tests.YourTestClass"));
        test.setXmlClasses(classes);

        // Create a list of XmlSuite
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        // Create an instance of TestNG
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);

        // Run the TestNG suite
        testNG.run();
    }
}

