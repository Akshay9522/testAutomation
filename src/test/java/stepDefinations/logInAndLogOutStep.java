package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appHooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pages.logInPage;

public class logInAndLogOutStep {
	
	private logInPage loginpage = new logInPage(Hook.driver);
	
	@Given("user is on the OrangeHRM login page")
	public void the_user_is_on_the_orange_hrm_login_page() {
		Hook.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@When("the user enters valid username {string}")
	public void the_user_enters_valid_username(String username) {
		loginpage.enterUserName(username);
	}

	@When("the user enters valid password {string}")
	public void the_user_enters_valid_password(String password) {
		loginpage.enterPassword(password);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		loginpage.clickLogInBtn();
	}

	@Then("the user should be redirected to the Dashboard page")
	public void the_user_should_be_redirected_to_the_dashboard_page() {
		System.out.println("HomePagetitle"+loginpage.homePageTitle());
		Assert.assertEquals("OrangeHRM",loginpage.homePageTitle());
	}

	@When("the user enters invalid username {string}")
	public void the_user_enters_invalid_username(String username) {
		loginpage.enterUserName(username);

	}

	@When("the user enters invalid password {string}")
	public void the_user_enters_invalid_password(String password) {
		loginpage.enterPassword(password);
	}

	@Then("the user should see an error message {string}")
	public void the_user_should_see_an_error_message(String password) {
		System.out.println("Invalid message"+ loginpage.invalidCredMessage());
		Assert.assertEquals(password, loginpage.invalidCredMessage());
	}

	@When("the user leaves the username and password fields empty")
	public void the_user_leaves_the_username_and_password_fields_empty() {
		
	}

	@Then("the user should see a validation message {string}")
	public void the_user_should_see_a_validation_message(String expMsg) {
		for(String actMsg:loginpage.requiredMessage()) {
			System.out.println("validation message"+ actMsg);
			Assert.assertEquals(expMsg, actMsg);
		}
	}

	@When("the user clicks on the profile icon")
	public void the_user_clicks_on_the_profile_icon() {
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String string) {
		loginpage.userlogOut();
	}

	@Then("the user should be redirected back to the login page")
	public void the_user_should_be_redirected_back_to_the_login_page() {
		System.out.println("againtitle"+ loginpage.homePageTitle());
		Assert.assertEquals("OrangeHRM",loginpage.homePageTitle());
	}

}
