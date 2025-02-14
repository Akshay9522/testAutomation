package stepDefinations;

import appHooks.Hook;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EmployeePage;
import pages.logInPage;

public class EmployeeStep {
	
	private EmployeePage employeePage = new EmployeePage(Hook.driver);

	@When("User navigates to {string} module")
	public void user_navigates_to_module(String string) {
		employeePage.clickOnPIM();
	}

	@When("Clicks on the {string} button")
	public void clicks_on_the_button(String string) {
		if(string.equalsIgnoreCase("Add Employee")) {
			employeePage.clickOnAddbtn();		
		}else if(string.equalsIgnoreCase("Delete")) {
			employeePage.clickOnDeletebtn();
		}
	}
	
	@When("Enters {string} as First Name, {string} as Last Name")
	public void enters_as_first_name_as_last_name(String firstname, String lastname) {
		employeePage.enterFirstName(firstname);
		employeePage.enterLastName(lastname);
	}
	
	@When("Clicks on Save")
	public void clicks_on_save() {
		employeePage.clickOnSave();
	}
	
	@Then("Employee {string} should be added successfully")
	public void employee_should_be_added_successfully(String string) {
		System.out.println(employeePage.getSuccessmdg());
	}
	
	@When("Searches for Employee with name {string}")
	public void searches_for_employee_with_name(String string) {
		employeePage.searchByEmpName(string);
	}

	@Then("Employee details should be displayed")
	public void employee_details_should_be_displayed() {
		System.out.println(employeePage.empDetailsdisplayed());
	}
	
	@Then("Employee should be removed from the system")
	public void employee_should_be_removed_from_the_system() {
		
	}
}
