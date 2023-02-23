package mob_testing;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class Swiping_Action {
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	  public void beforeTest() throws MalformedURLException 
	{DesiredCapabilities dc= new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vertualMob");    //mobile name
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);  //specifying automator name
	dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.google.android.dialer");
	dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.google.android.apps.dialer.extensions.GoogleDialtactsActivity" );
	driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	}
	
  @Test
  public void f() throws InterruptedException 
  {
	  //WebElement wb1= driver.findElement (MobileBy.id("com.google.android.dialer:id/emptyListViewImage"));
	 // WebElement wb2= driver.findElement (MobileBy.AccessibilityId("Call History tab.")); 
	  //TouchAction act = new TouchAction (driver);
	  //act.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(wb1)).withDuration(Duration.ofSeconds(3))).moveTo(element(wb2)).release().perform();
	  Thread.sleep(3000);
	  driver.pressKey(new KeyEvent(AndroidKey.POWER).withKey(AndroidKey.VOLUME_DOWN));
	  Thread.sleep(3000);
	  driver.pressKey(new KeyEvent(AndroidKey.POWER).withKey(AndroidKey.VOLUME_UP));
	  
  }
  

}
