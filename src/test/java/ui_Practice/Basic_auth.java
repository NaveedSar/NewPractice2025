package ui_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_auth {

	public static void main (String []args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		//By passin username and password within the first part of the URL. you can auth on a broken web
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String authentcation = driver.findElement(By.xpath("//p")).getText();
		String expectedauthText = "Congratulations! You must have the proper credentials.";
		System.out.println(authentcation.equals(expectedauthText));
		driver.quit();
		
	}
}
