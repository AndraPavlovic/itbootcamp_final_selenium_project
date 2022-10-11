package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BasicTest{
	@Test (priority = 100)
    public void visitsTheSignupPage() {
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "[ERROR] URL does not contain /signup");
    }
	 @Test (priority = 200)
	    public void checkInputTypes(){
	        navPage.getSignupButton().click();
	        Assert.assertEquals(signupPage.getEmailInputField().getAttribute("type"), "email",
	                "[Error] Input field is not email");
	        Assert.assertEquals(signupPage.getPasswordInputField().getAttribute("type"), "password",
	                "[Error] Input field is not password");
	        Assert.assertEquals(signupPage.getConfirmPasswordInputField().getAttribute("type"), "password",
	                "[Error] Input field is not password");
	    }
	 @Test (priority = 300)
	    public void displaysErrorsWhenUserAlreadyExists() {
	        String name = "Another User";
	        String email = "admin@admin.com";
	        String password = "12345";
	        String confirmPassword = "12345";
	        navPage.getSignupButton().click();
	        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "[ERROR] URL does not contain /signup");
	        signupPage.getNameInputField().sendKeys(name);
	        signupPage.getEmailInputField().sendKeys(email);
	        signupPage.getPasswordInputField().sendKeys(password);
	        signupPage.getConfirmPasswordInputField().sendKeys(confirmPassword);
	        signupPage.getSignUpButton().click();
	        messagePopUpPage.waitForPopUpVisibility();
	        Assert.assertEquals(messagePopUpPage.getElementsWithTextMessages(), "E-mail already exists",
	                "[Error] Pop up message not correct");
	        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "[ERROR] URL does not contain /signup");
	    }
	 @Test (priority = 400)
	    public void signUp(){
	        String name = "Andrija Pavlovic";
	        String email = "pavlovicandrija@gmail.rs";
	        String password = "12345";
	        String confirmPassword = "12345";
	        navPage.getSignupButton().click();
	        signupPage.getNameInputField().sendKeys(name);
	        signupPage.getEmailInputField().sendKeys(email);
	        signupPage.getPasswordInputField().sendKeys(password);
	        signupPage.getConfirmPasswordInputField().sendKeys(confirmPassword);
	        signupPage.getSignUpButton().click();
	        messagePopUpPage. waitForPopUpVisibility();
	        Assert.assertEquals(messagePopUpPage.getVerifyYourAccountMessages(), "IMPORTANT: Verify your account",
	                "[Error] Pop up message not correct");
	        messagePopUpPage.getCloseMessagesButton().click();
	        navPage.getLogoutButton().click();
	    }

}
