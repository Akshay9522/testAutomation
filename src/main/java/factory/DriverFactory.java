package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static WebDriver driver;

	public WebDriver init_driver(String browser) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\testAutomation\\testAutomation\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\testAutomation\\testAutomation\\Driver\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			//System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\testAutomation\\testAutomation\\Driver\\msedgedriver.exe");
	        WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getDriver();

	}

	
	public static synchronized WebDriver getDriver() {
		return driver;
	}
/*	class Animal {
	    void sound() {
	        System.out.println("Animal makes a sound");
	    }
	}
	 
	class Dog extends Animal {
	    void sound() {
	        System.out.println("Dog barks");
	    }
	    void test(){
	        System.out.println("Test method");
	    }
	 
	}
	 
	public class Main {
	    public static void main(String[] args) {
	        Animal animal = new Dog();
	        animal.test();
	    }
	}
*/
}

