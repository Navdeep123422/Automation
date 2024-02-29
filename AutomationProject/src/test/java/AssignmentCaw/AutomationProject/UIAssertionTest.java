package AssignmentCaw.AutomationProject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

@Listeners(AssertionListener.class)
public class UIAssertionTest {

    private WebDriver driver;

    @SuppressWarnings("deprecation")
	@BeforeClass
    void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/navdeepsingh/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "jsonParsing", dataProviderClass = BaseClass.class)
	void insertData(String jsonData) {
		
	    // Go to the given test URL page
	    driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
	    
	    // Click on the button with the id
	    driver.findElement(By.xpath("//summary[normalize-space()='Table Data']")).click();
	    
	    // Selecting input text box and clearing existing data
	    driver.findElement(By.id("jsondata")).clear();
	    
	    // Providing complete JSON data to the input field
	    driver.findElement(By.id("jsondata")).sendKeys(jsonData);

	    // Clicking on the refresh button after passing data from the JSON file
	    driver.findElement(By.xpath("//button[@id='refreshtable']")).click();
	}
    void assertUIValuesWithJSON(String inputData) {
        // Parsing JSON data
        String[] data = inputData.split(",");
        String expectedName = data[0];
        String expectedAge = data[1];
        String expectedGender = data[2];

        // Navigate to the test page
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        // Perform actions to populate UI values (Assuming the UI is dynamic and changes)
        WebElement nameElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/table[1]/tr[1]/th[1]")); 
        WebElement ageElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/table[1]/tr[1]/th[2]"));
        WebElement genderElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/table[1]/tr[1]/th[3]"));

        // Assuming the UI values are dynamically populated, retrieve them
        String actualName = nameElement.getText();
        String actualAge = ageElement.getText();
        String actualGender = genderElement.getText();

        // Assert UI values with JSON data
        Assert.assertEquals(actualName, expectedName, "Name does not match");
        Assert.assertEquals(actualAge, expectedAge, "Age does not match");
        Assert.assertEquals(actualGender, expectedGender, "Gender does not match");
    }
}
