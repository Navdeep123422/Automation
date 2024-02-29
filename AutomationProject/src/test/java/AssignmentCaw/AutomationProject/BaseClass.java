package AssignmentCaw.AutomationProject;

import java.time.Duration;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseClass {

	WebDriver driver;

	@BeforeClass
	void setup() {

		System.setProperty("webdriver.chrome.driver",
				"/Users/navdeepsingh/Downloads/chromedriver-mac-arm64/chromedriver");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	void tearDown() {

		driver.quit();

	}

	@Test(dataProvider = "jsonParsing")
	void insertData(String jsonData) {

		// Go to the given test URL page
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

		// Click on the button with the id using explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tableDataButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//summary[normalize-space()='Table Data']")));
		tableDataButton.click();

		// Selecting input text box and clearing existing data
		WebElement jsonInputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsondata")));
		jsonInputBox.clear();

		// Providing complete JSON data to the input field
		jsonInputBox.sendKeys(jsonData);

		// Clicking on the refresh button after passing data from the JSON file
		WebElement refreshButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='refreshtable']")));
		refreshButton.click();
	}

	@DataProvider(name = "jsonParsing")
	Object[] readJson() {
		try {
			// Read the entire content of the JSON file as a string
			String jsonData = new String(Files.readAllBytes(Paths.get("./Testdata.json")));

			// Return a single-element array containing the complete JSON string
			return new String[]{jsonData};

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	

}
