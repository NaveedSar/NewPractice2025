package testNG_framework_practice;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Annotation {
	
	WebDriver driver;
	@BeforeClass (description = "lunching browser")
	public void beforeClass () {
		System.out.println("Lunching browser");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/?zx=1760373023390&no_sw_cr=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		
	}
	
	@AfterClass (description = "Closing browser")
	public void TearDown () {
		if(driver != null) {
		driver.quit();
		}
		System.out.println("Closing Browser and ending the process");
		
	}
	
	@Test (description = "Title testing")
	public void title () {
		System.out.println("Tetsing the title");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Tetsing is successfull");
	}
	
	@Test (description = "log out validation")
	public void logout () {
		
		System.out.println("Log out successfull");
		
	}

}
