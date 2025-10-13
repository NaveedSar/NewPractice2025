package ui_Practice;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_new_window {
	
	public static void main(String []args) throws InterruptedException {
	
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://the-internet.herokuapp.com/windows");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	windowHandlers(driver);
	driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	//Thread.sleep(3000);
	windowHandlers(driver);
	String actualTitle = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
	
	String expectedTitle = "New Window"; 

	try {
	Assert.assertEquals(actualTitle, expectedTitle);   //Used try catch block to continue the exection
	} catch (AssertionError asserts) {               // and give the error msg
		System.out.println("Assertion failed");
	}
	
	System.out.println("The result is: "+actualTitle.equals(expectedTitle)); //Second way to assert
	
	driver.quit();
	

	
			
	
	
	
	}
	
	public static void windowHandlers (WebDriver driver) {
		
		Set<String> windoHandle = driver.getWindowHandles();

		Iterator <String> it = windoHandle.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
		}
		
	}
	
}
