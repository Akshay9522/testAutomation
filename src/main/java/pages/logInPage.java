package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class logInPage extends BasePage {
	WebDriver driver;

	@FindBy(name="username")
	private WebElement userNameTxtBx;
	
	@FindBy(name="password")
	private WebElement passwordTxtBx;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement logInBtn;
	
	By inValidCredMsg = By.xpath("//p[text()='Invalid credentials']");
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	private WebElement menu;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logOut;
	
	By Required = By.xpath("//span[text()='Required']");
	By ForgotLink = By.xpath("//p[text()='Forgot your password? ']");

	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	private WebElement forgotLink;
	
	@FindBy(xpath="//button[text()=' Reset Password ']")
	private WebElement resetPassword;
	
	@FindBy(xpath="//div[@class='orangehrm-card-container']/h6")
	private WebElement resetPasswordLinkTxt;
	
	public logInPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void enterUserName(String username) {
		userNameTxtBx.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTxtBx.sendKeys(password);
	}
	
	public void clickLogInBtn() {
		logInBtn.click();
	}
	
	public String homePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleIs("OrangeHRM"));

		String title = driver.getTitle();
		System.out.println(title);
		return driver.getTitle();
	}
	
	public String invalidCredMessage() {
		return waitForElementPresent(inValidCredMsg).getText();
	}
	
	public void userlogOut() {
		menu.click();
		logOut.click();
	}
	public void clickOnForgotLink() {
		forgotLink.click();
		}
	
	public void clickOnResetPswd() {
		resetPassword.click();
		}
	
	public ArrayList<String> requiredMessage() {
		ArrayList<String> arr = new ArrayList<>();
		
		for(WebElement element:waitForElementsVisible(Required)) {
			arr.add(element.getText());
		}
		return arr;
	}
	
	public String resetLinkPswdSentMsg() {
		return resetPasswordLinkTxt.getText();
	}
	
}
