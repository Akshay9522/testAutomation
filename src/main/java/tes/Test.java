package tes;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.*;

public class Test {

	public static void main(String[] args) {
		
		//1. Open Browser
		//2. Navigate to  https://www.icc-cricket.com/
			//3. Navigate to Ranking -> Men's Team Ranking
			//4. click Full Ranking link for ODIs
			  //           5. find ranking & rating of India
			
			
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\testAutomation\\testAutomation\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/");
		
		
		//WebDriverwait wait  = new WebDriveWait(driver, 10);
		try {
			WebElement accptCoockies = driver.findElement(By.id("onetrust-reject-all-handler"));
			accptCoockies.click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
			
		}
		
		 WebElement rankingLink = driver.findElement(By.xpath("(//a[text()='Rankings'])[2]"));
		 WebElement mainTeamRank = driver.findElement(By.linkText("Men's team rankings"));

		
		 //WebElement rankingLink = driver.findElement(By.linkText("Rankings"));
		 rankingLink.click();
		 
		// WebElement mainTeamRank = driver.findElement(By.linkText("Men's team rankings"));
		 mainTeamRank.click();
		 
		 WebElement fullODIRank = driver.findElement(By.xpath("(//div[@id='rankings-mens-team-rankings']//descendant::a)[1]"));

		 fullODIRank.click();
		 
		 driver.quit();
		
		
	}
}
