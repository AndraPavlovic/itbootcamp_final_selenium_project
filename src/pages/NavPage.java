package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
	private WebDriver driver;

	public NavPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getHomeButton() {
		return driver.findElement(By.className("mdi-home"));
	}

	public WebElement getAboutButton() {
		return driver.findElement(By.className("mdi-help"));
	}

	public WebElement getMyProfileButton() {
		return driver.findElement(By.className("mdi-face"));
	}

	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}

	public WebElement getCitiesLinkFromDropdown() {
		return driver.findElement(By.className("btnAdminCities"));
	}

	public WebElement getUsersLinkFromDropdown() {
		return driver.findElement(By.className("btnAdminUsers"));
	}

	public WebElement getSignupButton() {
		return driver.findElement(By.xpath("//*/div[3]/a[4]"));
	}

	public WebElement getLogInButton() {
		return driver.findElement(By.xpath("//*/div[3]/a[3]"));
	}

	public WebElement getLogoutButton() {
		return driver.findElement(By.className("btnLogout"));
	}

	public WebElement getChangeLanguageButton() {
		return driver.findElement(By.className("btnLocaleActivation"));
	}

	public WebElement getENButton() {
		return driver.findElement(By.className("btnEN"));
	}

	public WebElement getESButton() {
		return driver.findElement(By.className("btnES"));
	}

	public WebElement getFRButton() {
		return driver.findElement(By.className("btnFR"));
	}

	public WebElement getCNButton() {
		return driver.findElement(By.className("btnCN"));
	}
}
