package AutomationStepDefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import CommonStepsDefinitions.CommonAction;
import CommonStepsDefinitions.DriverFactory;

public class EbayProduct {
	static WebDriver driver=DriverFactory.initDriver();
	
	static String buttonXpath="//button[contains(text(), '%btnName')]";
	static String selectOptionXpath="//table[@id='gh-sbc']/tbody/tr/td/h3/a[contains(text(),'%section')]//parent::h3/following-sibling::ul/li/a[contains(text(),'%option')]";
	static String selectLeftPanelOptionXpath="//a[contains(text(),'%option')]";
	static LinkedHashMap<String,String> actMaps=new LinkedHashMap<String,String>();
	
//	@And("User clicks on {string}")
//	@When("User Clicks on {string} dropdown")
//	public void clicksOnButton(String btnName) throws Exception {
//		CommonAction.javaScriptClick(CommonAction.getWebElement("xpath",buttonXpath.replace("%btnName",btnName)));
//	}
	
	@And("Select {string} under {string} category")
	public void selectOptionsUnderSection(String option, String category) throws Exception {
		CommonAction.javaScriptClick(CommonAction.getWebElement("xpath",selectOptionXpath.replace("%section",category).replace("%option",option)));
	}
	
	@And("User clicks on {string} in the left-hand navigation section")
	public void userclicksOnLeftNavOption(String option) throws Exception {  
		CommonAction.javaScriptClick(CommonAction.getWebElement("xpath",selectLeftPanelOptionXpath.replace("%option",option)));
	}
	
	@When("User applies the Filter Type with Filter Value")
	public void accessProductbyAddingTags(DataTable fields) throws Exception {
		String filterTag="",tagValue="";
		
		List<Map<String,String>> keyValueMap=fields.asMaps(String.class,String.class);
		System.out.println("keyValueMap"+keyValueMap);
		for(Map<String,String> eachSet:keyValueMap) {
			
			filterTag=eachSet.get("Filter Type");
			tagValue=eachSet.get("Filter Value");
			actMaps.put(filterTag, tagValue);
			//applyFilter(filterTag,tagValue);
			
		}
		System.out.println("actMaps"+actMaps);
	}
		public static void applyFilter(String filterTag, String value) throws Exception{
			System.out.println("applying filter>>>>>>>>>>>>>");
			switch(filterTag.toLowerCase()) {
			case "condition":
				//addCondition(filterTag,value);
				
				break;
				
			case "price":
			   driver.switchTo().frame("master-a-1");
				addPrice(filterTag,value);
				  break;
				  
			case "item location":
				break;
				
			}
			
			
		}
		
		public static void addCondition(String tag,String value) throws Exception{
			CommonAction.javaScriptClick(CommonAction.getWebElement("xpath","(//div[@class='x-overlay-main-panel__aspects'])[1]//div[@role='tab' and  @data-aspecttitle='LH_ItemCondition']"));
			
		}
		public static void addPrice(String tag,String value) throws Exception{
			
			CommonAction.javaScriptClick(CommonAction.getWebElement("xpath","(//*[@id=\"x-overlay__form\"]/div[1]/div[1]//div[@data-aspecttitle='price'])[2]"));
			
		}
		
		@Then("Verify that user should see Condition:New;Price:${int}-${int};Item Location:US Only are applied")
		public void verify_that_user_should_see_condition_new_price_$_$_item_location_us_only_are_applied(Integer int1, Integer int2) {
		      
		}
		
		
		//scenario2
		@When("User enter {string} in the search bar")
		public void enterDatainSearchBar(String input)throws Exception {
			System.out.println("inside enter data");
			String textAreaXpath="//input[@id='gh-ac']";
			CommonAction.javaScriptEnterValue(CommonAction.getWebElement("xpath",textAreaXpath), input);
		    
		}
		@And("User change Search category to {string} and click {string}")
		public void selectCategoryfromDropDown(String category, String searchBtn) throws Exception { 
			System.out.println("inside changing category");
			CommonAction.javaScriptClick(CommonAction.getWebElement("xpath","//select[@id='gh-cat']"));
			CommonAction.selectValueByVisibleText(CommonAction.getWebElement("xpath","//select[@id='gh-cat']"), category);
			CommonAction.javaScriptClick(CommonAction.getWebElement("xpath","//input[@type='submit']"));
		}
		@Then("verify that the page loads completely")
		public void verifyPageLoaded() throws Exception{
			
		    
		}
	}
	
	


