package assignment;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Banjara_ride {
	AndroidDriver<AndroidElement> driver;
	ExtentReports extent;
	ExtentTest logger;
  @BeforeTest
  public void beforeTest() throws MalformedURLException 
  {
	  extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/Test_Report.html",true);
	  extent.loadConfig(new File(System.getProperty("user.dir")+"src/test/java/extent-config.xml"));
	  
	    DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vertualMob");    //mobile name
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);  //specifying automator name
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.forbinary.banjararide");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.forbinary.banjararide.activity.SplashActivity" );
		driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
  }

	
  @Test
  public void testcase1() throws InterruptedException, AWTException
  {
	  logger=extent.startTest("BanjaraRide");

	  WebDriverWait wait= new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.forbinary.banjararide:id/home_language_button")));
	  driver.findElements(MobileBy.id("com.forbinary.banjararide:id/home_language_button")).get(0).click();  //click on english
	  logger.log(LogStatus.PASS,"selected English Language");
	  
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/textView_selectedCountry")).click();  //select country
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.forbinary.banjararide:id/editText_search")));
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/editText_search")).sendKeys("India");
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"India (IN)\")")).click();  //select india
	  logger.log(LogStatus.PASS, "Country code selected to india (+91)");
	  
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/edtMobileNumber")).sendKeys("9762941757");   //mobile no. insert
	  logger.log(LogStatus.PASS, "mobile number entered successfully");
	  
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/imgNext")).click();   //click on next button
	  logger.log(LogStatus.PASS, "Requested for otp successfully");
	  Thread.sleep(15000);
	  
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/imgNext")).click();
	  logger.log(LogStatus.PASS, "Login Successfully");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.forbinary.banjararide:id/card_text")));
	  driver.findElements(MobileBy.id("com.forbinary.banjararide:id/card_text")).get(1).click(); //click on book now
	  logger.log(LogStatus.PASS, "clicking on book now");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.forbinary.banjararide:id/infocenterlib_page_name")));
	  driver.findElements(MobileBy.id("com.forbinary.banjararide:id/infocenterlib_page_name")).get(0).click(); //hire bike
	  logger.log(LogStatus.PASS, "clicking on 'Hire Bike'");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.LinearLayout")));
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"CB Hornet 160R\")")).click();  //select cb hornet 160r bike
	  logger.log(LogStatus.PASS, "selected CB Hornet 160R from list");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.forbinary.banjararide:id/btnBookNow")));
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/btnBookNow")).click();
	  logger.log(LogStatus.PASS, "clicking on 'book now' button");
	  
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/tvDate")).click();
	  Thread.sleep(2000);
	  driver.findElement(MobileBy.id("android:id/next")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"28\")")).click();
	  driver.findElement(MobileBy.id("android:id/button1")).click();
	  logger.log(LogStatus.PASS, "selecting` date(28th Feb)");
	  
	  Thread.sleep(3000);
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  Thread.sleep(2000);
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  Thread.sleep(2000);
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  logger.log(LogStatus.PASS,"Navigate back to Homepage");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.ImageButton")));
	  driver.findElement(MobileBy.className("android.widget.ImageButton")).click();
	  logger.log(LogStatus.PASS, "clicking on menu bar");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.ImageView")));
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Bookings\")")).click();
	  logger.log(LogStatus.PASS, "clicking on 'Bookings' ");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.forbinary.banjararide:id/search_button")));
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/search_button")).click();
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/search_src_text")).sendKeys("activa");
	  logger.log(LogStatus.PASS, "searching for activa");
	  Thread.sleep(4000);
	  
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/search_close_btn")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.forbinary.banjararide:id/search_close_btn")));
	  driver.findElement(MobileBy.id("com.forbinary.banjararide:id/search_close_btn")).click();
	  Thread.sleep(1000);
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  logger.log(LogStatus.PASS, "coming back on homepage");
	  
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Call Us\"))").click();
	  Thread.sleep(3000);
	  logger.log(LogStatus.PASS, "clicking on 'Call US' Button");
	  
	  driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	  Thread.sleep(500);
	  driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	  Thread.sleep(3000);
	  logger.log(LogStatus.PASS, "Switching Back from Phone to Homepage");
	  
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  logger.log(LogStatus.PASS, "Closing Application");
	  }
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
      extent.endTest(logger);  
	  extent.flush();  
	  extent.close(); 
  }

}
