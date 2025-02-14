package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage extends BasePage{

	
		WebDriver driver;

		@FindBy(name="firstName")
		private WebElement firstNameTxtBx;
		
		@FindBy(name="lastName")
		private WebElement lastNameTxtBx;
		
		@FindBy(xpath="//span[text()='PIM']")
		private WebElement PIM;
		
		@FindBy(xpath="//button[contains( .,'Add ')]")
		private WebElement addBtn;
				
		@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
		private WebElement menu;
		
		@FindBy(xpath="//button[text()=' Save ']")
		private WebElement save;
		
		@FindBy(xpath="//button[text()=' Search ']")
		private WebElement search;
		
		@FindBy(xpath="//label[text()='Employee Name']/parent::div/following-sibling::div/descendant::input")
		private WebElement emplName;
		
		@FindBy(xpath="//span[contains(.,'Records Found')]")
		private WebElement recdFounf;
		
		@FindBy(xpath="//button[text()=' Add ']/parent::div/following-sibling::div[2]/descendant::i[2]")
		private WebElement deleteIcn;
		
		@FindBy(xpath="//p[text()='Successfully Deleted']")
		private WebElement successdelete;
		
		@FindBy(xpath="//button[contains(.,' Yes, Delete ')]")
		private WebElement yesDelete;

		By sucessMsg = By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']/p[2]");
		
		public EmployeePage(WebDriver driver){
			super(driver);
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		
		public void clickOnPIM() {
			PIM.click();
		} 
		
		public void clickOnAddbtn() {
			addBtn.click();
		}
		
		public void clickOnDeletebtn() {
			deleteIcn.click();
			yesDelete.click();			
		}
		
		public void enterFirstName(String firstname) {
			firstNameTxtBx.sendKeys(firstname);
		}
		
		public void enterLastName(String lastname) {
			lastNameTxtBx.sendKeys(lastname);
		}
		
		public void clickOnSave() {
			save.click();
		}
		
		public String getSuccessmdg() {
			return driver.findElement(sucessMsg).getText();
		}
		
		public String empDetailsdisplayed() {
			return recdFounf.getText();
		}
		
		public void searchByEmpName(String empname) {
			emplName.clear();
			emplName.sendKeys(empname);
			keyboardEnter();
		}
		
		public String emplRemovedFromSystem() {
			return successdelete.getText();
		}
}
