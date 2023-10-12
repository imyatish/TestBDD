package AutomationStepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CommonStepsDefinitions.CommonAction;
import CommonStepsDefinitions.DriverFactory;
import io.cucumber.java.en.Given; 

public class Login {
	
	@Given("User lauches Ebay application")
	public void userLauchesApplication() throws Exception{
		System.out.println("lauch url>>>>>>");
		WebDriver driver=DriverFactory.initDriver();
	    driver.get("https://www.ebay.com/");
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

}
