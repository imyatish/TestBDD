package CommonStepsDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	static WebDriver driver=null;
	 public static WebDriver initDriver() {
	 if (driver == null) {
	 String projectPath=System.getProperty("user.dir");
	 System.setProperty("webdriver.chromedriver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
     WebDriverManager.chromedriver().setup();
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--start-maximized");
     options.addArguments("no-sandbox");
     driver = new ChromeDriver(options);
	 }
     return driver;
	}

}
