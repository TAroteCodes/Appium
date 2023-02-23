package mob_testing;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
public class NativeApp {
	AndroidDriver<AndroidElement> driver;
@BeforeTest
public void beforeTest() throws MalformedURLException {
	DesiredCapabilities dc= new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vertualMob");    //mobile name
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);  //specifying automator name
	dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.example.android.apis");
	dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.example.android.apis.ApiDemos" );
	driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
}
	
  @Test
  public void animation() throws InterruptedException {
	  System.out.println("NATIVE APP AUTOMATION BEGINS.");
	  driver.findElements(MobileBy.id("android:id/text1")).get(1).click();
	  driver.findElements(MobileBy.id("android:id/text1")).get(0).click();
	  driver.findElement(MobileBy.id("com.example.android.apis:id/ball")).click();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  Thread.sleep(1000);
	  driver.navigate().back();
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Reversing\")")).click();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  Thread.sleep(1000);
	  driver.navigate().back();
	  driver.findElements(MobileBy.id("android:id/text1")).get(9).click();
	  driver.findElements(MobileBy.id("android:id/text1")).get(2).click();
	  driver.findElement(MobileBy.id("android:id/checkbox")).click();
	  driver.findElements(MobileBy.className("android.widget.RelativeLayout")).get(1).click();
	  driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Tushar");
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"CANCEL\")")).click();
	  
	  
	  
  }
  

}
