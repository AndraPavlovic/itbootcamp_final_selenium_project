package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BasicTest {

	@Test(priority = 100)
	public void setLocaleToES() {
		navPage.getChangeLanguageButton().click();
		navPage.getESButton().click();
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Página de aterrizaje"),
				"[Error] Header does not contain Página de aterrizaje");
	}

	@Test(priority = 200)
	public void setLocaleToEN() {
		navPage.getChangeLanguageButton().click();
		navPage.getENButton().click();
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Landing"),
				"[Error] Header does not contain Landing");
	}

	@Test(priority = 300)
	public void setLocaleToCN() {
		navPage.getChangeLanguageButton().click();
		navPage.getCNButton().click();
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("首页"),
				"[Error] Header does not contain 首页");
	}

	@Test(priority = 400)
	public void setLocaleToFR() {
		navPage.getChangeLanguageButton().click();
		navPage.getFRButton().click();
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Page d'atterrissage"),
				"[Error] Header does not contain Page d'atterrissage");
	}
}
