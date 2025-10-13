package ui_Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static WebDriver driver;
	public static void main (String [] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WindowHandlers(driver);
		driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();
		driver.findElement(By.xpath("//input[2]")).click();
		driver.findElement(By.xpath("//input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[2]")).click();
		driver.findElement(By.xpath("//input[1]")).click();
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		//driver.quit();
		
		WebElement element22 = driver.findElement(By.xpath("//a[text()='Elemental Seleniumaaaa']"));  //Only for Practice
		
		ExplicWait(element22);
		
		//WindowHandlers(driver);
		
		
		
		
		
	}
	
	public static void WindowHandlers (WebDriver driver) {
		
		Set<String> windHandlers = driver.getWindowHandles();
		
		Iterator <String> Newwin = windHandlers.iterator();
		
		while(Newwin.hasNext()) {
			
			driver.switchTo().window(Newwin.next());
		}
		
	}
	
	public static void ExplicWait (WebElement element) {
		
		try {
			WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (NoSuchElementException e) {
			e.getStackTrace();
			System.out.println("Element not found!!");
		}
		
		
		
		
		
	}
	
}
