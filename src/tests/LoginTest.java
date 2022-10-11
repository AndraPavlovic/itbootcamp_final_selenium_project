package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTest {
	@Test(priority = 100)
	public void visitsTheLoginPage() {
		navPage.getChangeLanguageButton().click();
		navPage.getENButton().click();
		navPage.getLogInButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[ERROR] URL does not contain /login");
	}

	@Test(priority = 200)
	public void checkInputTypes() {
		navPage.getLogInButton().click();
		Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("type"), "email",
				"[Error] Input field is not email");
		Assert.assertEquals(driver.findElement(By.id("password")).getAttribute("type"), "password",
				"[Error] Input field is not password");
	}

	@Test(priority = 300)
	public void displaysErrorsWhenUserDoesNotExist() {
		String email = "non-existing-user@gmal.com";
		String password = "password123";
		navPage.getLogInButton().click();
		loginPage.getEmailInputField().sendKeys(email);
		loginPage.getPasswordInputField().sendKeys(password);
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpVisibility();
		Assert.assertEquals(messagePopUpPage.getElementsWithTextMessages(), "User does not exists",
				"[Error] Pop up message not correct");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[ERROR] URL does not contain /login");
	}

	@Test(priority = 400)
	public void displaysErrorsWhenPasswordIsWrong() {
		String email = "admin@admin.com";
		String password = "password123";
		navPage.getLogInButton().click();
		loginPage.getEmailInputField().sendKeys(email);
		loginPage.getPasswordInputField().sendKeys(password);
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpVisibility();
		Assert.assertEquals(messagePopUpPage.getElementsWithTextMessages(), "Wrong password",
				"[Error] Pop up message not correct");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[ERROR] URL does not contain /login");
	}

	@Test(priority = 500)
	public void login() {
		String email = "admin@admin.com";
		String password = "12345";
		navPage.getLogInButton().click();
		loginPage.getEmailInputField().sendKeys(email);
		loginPage.getPasswordInputField().sendKeys(password);
		loginPage.getLoginButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "[ERROR] URL does not contain /home");
	}

	@Test(priority = 600)
	public void logout() {
		Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), "[Error] Logout button is not displayed");
		navPage.getLogoutButton().click();
	}
}
