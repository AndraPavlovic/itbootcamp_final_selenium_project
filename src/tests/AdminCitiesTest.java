package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BasicTest {

	@Test(priority = 100)
	public void visitsTheAdminCitiesPageAndListCities() {
		String email = "admin@admin.com";
		String password = "12345";
		navPage.getLogInButton().click();
		loginPage.getEmailInputField().sendKeys(email);
		loginPage.getPasswordInputField().sendKeys(password);
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromDropdown().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
				"[Error] URL does not contain /admin/cities");
	}

	@Test(priority = 200)
	public void checksInputTypesForCreate_EditNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromDropdown().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForEditPopUp();
		Assert.assertEquals(citiesPage.getNewItemInputField().getAttribute("type"), "text",
				"[Error] Type attribute is not text");
	}

	@Test(priority = 300)
	public void createNewCity() {
		String city = "Andrija Pavlovic's city";
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromDropdown().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForEditPopUp();
		citiesPage.getNewItemInputField().sendKeys(city);
		citiesPage.getSaveButtonInEditPopUp().click();
		citiesPage.waitForEditPopUpToDisappear();
		messagePopUpPage.waitForSavedSuccessfulyMessage();
		Assert.assertTrue(messagePopUpPage.getSavedSuccessfulMessages().getText().contains("Saved successfully"),
				"[Error] Pop up message is not Saved successfully");
	}

	@Test(priority = 400)
	public void editCity() {
		String oldCityName = "Andrija Pavlovic's city";
		String newCityName = "Andrija Pavlovic's city Edited";
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromDropdown().click();
		citiesPage.getSearchInputField().sendKeys(oldCityName);
		citiesPage.waitForNumOfRowsToBe(1);
		citiesPage.getEditButtonFromRow(1).click();
		citiesPage.getNewItemInputField().click();
		citiesPage.getNewItemInputField().sendKeys(Keys.CONTROL + "a");
		citiesPage.getNewItemInputField().sendKeys(newCityName);
		citiesPage.getSaveButtonInEditPopUp().click();
		messagePopUpPage.waitForPopUpVisibility();
		Assert.assertTrue(messagePopUpPage.getSavedSuccessfulMessages().getText().contains("Saved successfully"),
				"[Error] Pop up message is not Saved successfully");
	}

	@Test(priority = 500)
	public void searchCity() {
		String city = "Andrija Pavlovic's city Edited";
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromDropdown().click();
		citiesPage.getSearchInputField().sendKeys(city);
		citiesPage.waitForNumOfRowsToBe(1);
		Assert.assertEquals(citiesPage.getCellFromRow(1, 1).getText(), city, "[Error] City name not correct");
	}

	@Test(priority = 600)
	public void deleteCity() {
		String city = "Andrija Pavlovic's city Edited";
		navPage.getAdminButton().click();
		navPage.getCitiesLinkFromDropdown().click();
		citiesPage.getSearchInputField().sendKeys(city);
		citiesPage.waitForNumOfRowsToBe(1);
		Assert.assertEquals(citiesPage.getCellFromRow(1, 1).getText(), city, "[Error] City name not correct");
		citiesPage.getDeleteButtonFromRow(1).click();
		citiesPage.waitForDeletePopUp();
		citiesPage.getDeleteButtonInDeletePopUp().click();
		messagePopUpPage.waitForSavedSuccessfulyMessage();
		Assert.assertTrue(messagePopUpPage.getSavedSuccessfulMessages().getText().contains("Deleted successfully"),
				"[Error] Pop up message is not Deleted successfully");
	}
}
