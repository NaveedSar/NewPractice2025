package ui_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebsiteautomatinPractice {

	public static void main (String [] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		WebElement title =  driver.findElement(By.xpath("//img[contains(@alt,'Website')]"));
		
		String titleContent = driver.getTitle().toString();
		Assert.assertTrue(title.isDisplayed());
		System.out.println(titleContent);
		System.out.println("Title is available");
		
		driver.quit();
		
	}
}
