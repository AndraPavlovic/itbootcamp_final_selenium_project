package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
	 private WebDriver driver;
	    private WebDriverWait wait;
	    public CitiesPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    public WebElement getNewItemButton(){
	        return driver.findElement(By.className("btnNewItem"));
	    }
	    public WebElement getSearchInputField(){
	        return driver.findElement(By.id("search"));
	    }
	    public void waitForEditPopUp(){
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
	    }
	    public void waitForEditPopUpToDisappear(){
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("dlgNewEditItem")));
	    }
	    public WebElement getNewItemInputField(){
	        return driver.findElement(By.id("name"));
	    }
	    public void waitForDeletePopUp(){
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("body-1")));
	    }
	    public WebElement getSaveButtonInEditPopUp(){
	        return driver.findElement(By.className("btnSave"));
	    }
	    public WebElement getDeleteButtonInDeletePopUp(){
	        return driver.findElement(By.xpath("//button[contains(@class, 'red--text')]"));
	    }
	    public void waitForNumOfRowsToBe(int rows) {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rows + 1));
	    }
	    public WebElement getCellFromRow (int row, int cell){
	        return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + (cell + 1) + "]"));
	    }
	    public WebElement getEditButtonFromRow (int row){
	        return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td/div/button[@id = 'edit']"));
	    }
	    public WebElement getDeleteButtonFromRow (int row){
	        return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td/div/button[@id = 'delete']"));
	    }
}
