package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class BasePage  {
	protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.actions = new Actions(driver);
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public WebElement waitForElementPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> waitForElementsVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    // Helper method to wait for an element to be clickable
    public WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(WebElement element) {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	    js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickByJavascript(WebElement element) {
  	  JavascriptExecutor js = (JavascriptExecutor) driver;
  	    js.executeScript("arguments[0].click();", element);
  }
    public void keyboardEnter() {
    	Actions act = new Actions(driver);
    	act.sendKeys(Keys.ENTER);
    }	
 // Method to wait for an element to be visible
    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to click an element
    public void clickElement(By locator) {
        WebElement element = waitForElement(locator);
        element.click();
    }

    // Method to scroll an element into view
    public void scrollIntoView(By locator) {
        WebElement element = waitForElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    // Method to enter text in an input field
    public void enterText(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    // Method to get text from an element
    public String getText(By locator) {
        return waitForElement(locator).getText();
    }
    
    // Method to check if an element is displayed
    public boolean isElementDisplayed(By locator) {
        try {
            return waitForElement(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    
    // Method to wait for an element to be clickable and click it
    public void waitForElementAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    
    // Method to handle exception safely
    public boolean safeClick(By locator) {
        try {
            clickElement(locator);
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking element: " + e.getMessage());
            return false;
        }
    }
    
    // Method to perform mouse hover action
    public void hoverOverElement(By locator) {
        WebElement element = waitForElement(locator);
        actions.moveToElement(element).perform();
    }
    
    // Method to simulate keyboard actions
    public void pressKey(Keys key) {
        actions.sendKeys(key).perform();
    }
    
    // Method to select from dropdown by visible text
    public void selectByVisibleText(By locator, String text) {
        Select dropdown = new Select(waitForElement(locator));
        dropdown.selectByVisibleText(text);
    }
    
    // Method to select from dropdown by index
    public void selectByIndex(By locator, int index) {
        Select dropdown = new Select(waitForElement(locator));
        dropdown.selectByIndex(index);
    }
    
    // Method to get all options from a dropdown
    public List<WebElement> getDropdownOptions(By locator) {
        Select dropdown = new Select(waitForElement(locator));
        return dropdown.getOptions();
    }
    
    // Method to double-click an element
    public void doubleClickElement(By locator) {
        WebElement element = waitForElement(locator);
        actions.doubleClick(element).perform();
    }
    
    // Method to right-click an element
    public void rightClickElement(By locator) {
        WebElement element = waitForElement(locator);
        actions.contextClick(element).perform();
    }
    
    // Method to drag and drop an element
    public void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = waitForElement(sourceLocator);
        WebElement target = waitForElement(targetLocator);
        actions.dragAndDrop(source, target).perform();
    }
    
    // Method to switch to a frame by index
    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }
    
    // Method to switch to a frame by locator
    public void switchToFrame(By locator) {
        WebElement frame = waitForElement(locator);
        driver.switchTo().frame(frame);
    }
    
    // Method to switch back to the default content
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
    
    // Method to accept an alert
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
    
    // Method to dismiss an alert
    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }
    
    // Method to upload a file
    public void uploadFile(By locator, String filePath) {
        WebElement element = waitForElement(locator);
        element.sendKeys(filePath);
    }
    
    // Method to get a list of elements
    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }
    
    // Method to wait for an element to disappear
    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    // Method to check if an element is enabled
    public boolean isElementEnabled(By locator) {
        return waitForElement(locator).isEnabled();
    }
    
    // Method to handle StaleElementReferenceException and retry finding the element
    public WebElement handleStaleElement(By locator) {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            try {
                return waitForElement(locator);
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying to find element due to StaleElementReferenceException: Attempt " + (i + 1));
            }
        }
        throw new StaleElementReferenceException("Element not found after multiple retries: " + locator);
    }


}