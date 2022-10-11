package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.CitiesPage;
import pages.LoginPage;
import pages.MessagePopUpPage;
import pages.NavPage;
import pages.SignupPage;

public class BasicTest {
	protected WebDriver driver;
	protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
	protected LoginPage loginPage;
	protected NavPage navPage;
	protected SignupPage signupPage;
	protected CitiesPage citiesPage;
	protected MessagePopUpPage messagePopUpPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		navPage = new NavPage(driver);
		signupPage = new SignupPage(driver);
		citiesPage = new CitiesPage(driver);
		messagePopUpPage = new MessagePopUpPage(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot screen = (TakesScreenshot) driver;
			File screenshot = screen.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(screenshot, new File("src/main/resources/Screenshot.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
