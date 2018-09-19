package helper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Helper {

	public static AndroidDriver driver;
	
	// install and run application function
	public static void app_luncher() throws MalformedURLException, InterruptedException {
	
		//create a file to get the apk
			File appdir=new File("src");
	
		//getting apk from src
			File app =new File(appdir,"14318.apk");
	
		//creating desired capabilities
			DesiredCapabilities cap=new DesiredCapabilities();
		
		//setting all the desired capabilities
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "45000");
			//cap.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, "com.awok.store.*");
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); //getting app path 
			cap.setCapability("autoDismissAlerts", true); // dismiss system alert
		
		//defining android driver
			driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			Reporter.log("App installed successfully",true);
	
	}
	
	// tutorial page function: next and done
	public static void tutorial_page_done()
{
		
		button_click_id(Locators.id_tutorial_next_button);
		button_click_id(Locators.id_tutorial_next_button);
		button_click_id(Locators.id_tutorial_next_button);
		button_click_id(Locators.id_tutorial_done_button); 		//click on done button
		
	}
	
	// tutorial page function: skip
	public static void tutorial_page_skip()
{
	
		//button_click_id(Locators.id_tutorial_skip_button);
		
	}
	
	// select country and language in fresh install
	public static void country_language_page()
	{
		// keep all as default English/ UAE
		button_click_id(Locators.done_language_country_selection);
	}
	
	//set desired language
	public static void language_setter(String value)
	{
	
		
	}
	
	//set desired country
	public static void country_setter(String value)
	{
	
		
	}
	
	// logout function from hamburger menu 
	public static void logout()
{
		
		scroll_to_text("Logout");
		console_print("Scrolled");
		button_click_ui_id(Locators.ui_logout);
		button_click_id(Locators.logout_button);
		console_print("I am Logged out");
		
	}
	
	//click with id
	public static void button_click_id(String value)
	{
		
		driver.findElementById(value).click();
	}
	
	//click with ui id
	public static void button_click_ui_id(String value)
	{
		
		driver.findElementByAndroidUIAutomator(value).click();
	}
	
	//click with xpath
	public static void button_click_xpath(String value)
	{
		
		driver.findElementByXPath(value).click();
	}
	
	//click with class name
	public static void button_click_class(String value)
	{
	
		driver.findElementByClassName(value).click();
	
	}
	
	//scroll to function
	public static void scroll_to_text(String value){
		
		((AppiumDriver)driver).scrollTo(value);
	}
	
	//click on Hamburger menu
	public static void open_Hamburger_menu()
	{
		button_click_class(Locators.class_menu);
	}
	
	//sleep, timer
	public static void sleep() throws InterruptedException
	{
	
		Thread.sleep(4000);
	
	}
	
	//send keys Buttons with id
	public static void sendkeys_id(String value,String keys)
	{
	
		driver.findElementById(value).clear();
		driver.findElementById(value).sendKeys(keys);
	
	}
	
	//send keys Buttons with ui id
	public static void sendkeys_ui(String value,String keys)
	{
	
		driver.findElementByAndroidUIAutomator(value).sendKeys(keys);
		
	}
	
	//sendkeys when blank
	public static void sendkeys_id_blank(String value,String keys)
	{
		
		driver.findElementById(value).clear();
		driver.findElementById(value).sendKeys(keys);
	
	}
	
	//text with id
	public static String text_print_id(String value)
	{
	
		return driver.findElementById(value).getText();
	
	}
	
	//print to console
	public static void console_print(String value)
	{
		
		System.out.println(value);
	
	}
	
	//validation for text
	public static void text_validation(String expected,String actual)
	{
	
		if(expected.contains(actual))
		{
			System.out.println("expected contains actual : " +actual);
		}
		else
		{
		System.out.println("expected do not contains actual : "+expected);	
		}
		
	}
	
	//register button is enabled or not
	public static void reg_button_enabled_id(String value)
	{
		
		boolean fname = driver.findElementById(value).isEnabled();
		  if (fname==true) 
		  {
			  System.out.println("register button is enabled");
			
		}
		  else
		  {
			  System.out.println("register button is disabled");
		  }
	
	}
	
	//clear input fields by id
	public static void clear_id(String value)
	{
	
		driver.findElementById(value).clear();
		
	}
	
	//clear input fields by ui id
	public static void clear_ui(String value)
	{
		
		driver.findElementByAndroidUIAutomator(value).clear();
		
	}
	
	//take and save screenshot
	public static void screenshot(String ssname) throws IOException
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("F:\\Screenshots\\"+ssname+".png"));
	
	}

	
	//hide keyboard function
	public static void hide_keyboard()
	{
		driver.hideKeyboard();
	}
	
	//navigate back function
	public static void navigate_back()
	{
		driver.navigate().back();
	}
	
	//Accept system alert dialog
	public static void accept_alert()
	{
		button_click_id(Locators.alert_yes);
	}
	
	//dismiss system alert dialog
	public static void dismiss_alert() 
	{
		button_click_id(Locators.alert_no);
	}
	
}
Nagham I am in
