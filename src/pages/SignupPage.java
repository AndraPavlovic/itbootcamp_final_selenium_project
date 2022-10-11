package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
	private WebDriver driver;

	public SignupPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getNameInputField() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getConfirmPasswordInputField() {
		return driver.findElement(By.id("confirmPassword"));
	}

	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//*[@type = 'submit']"));
	}
}
