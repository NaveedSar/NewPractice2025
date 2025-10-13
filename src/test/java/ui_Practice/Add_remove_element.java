package ui_Practice;

import java.time.Duration;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_remove_element {

	public static void main (String []args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
		windowHandlers(driver);
		
		WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
		addElement.click();
		WebElement removeElement = driver.findElement(By.xpath("//button[text()='Delete']"));
		removeElement.click();
		
		Thread.sleep(2000);
		
		String actualTitle = driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']")).getText();
		String expectedTitle = "Add/Remove Elements";
		
		try {
			Assert.assertEquals(actualTitle, expectedTitle);
			
		} catch (AssertionError asserts) {
			System.out.println("Title is not matching! Test failed");
		}
		
		System.out.println("Title text result is : " + actualTitle.equals(expectedTitle));
		driver.quit();
	}
	
	public static void windowHandlers(WebDriver driver) {
		
		Set<String> windowHandl = driver.getWindowHandles();
		Iterator <String> it = windowHandl.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
		}
	}
}
