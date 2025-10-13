package ui_Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImage {
	
	public static void main (String [] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		List <WebElement> brkImg = driver.findElements(By.xpath("//h3/following-sibling::img"));
		
		for(WebElement image : brkImg) {
			if(image.getAttribute("naturalWidth").equals("0")) {
				System.out.println("Image is broken" + image.getAttribute("src"));
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
