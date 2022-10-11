package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {
	@Test(priority = 100)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.navigate().to(baseUrl + "home");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[Error] URL does not contain /login");
	}

	@Test(priority = 200)
	public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.navigate().to(baseUrl + "profile");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[Error] URL does not contain /login");
	}

	@Test(priority = 300)
	public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
		driver.navigate().to(baseUrl + "admin/cities");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[Error] URL does not contain /login");
	}

	@Test(priority = 400)
	public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
		driver.navigate().to(baseUrl + "admin/users");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[Error] URL does not contain /login");
	}
}
