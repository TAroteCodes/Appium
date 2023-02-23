package mob_testing;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Khan_Acadamy {
	AndroidDriver<AndroidElement> driver;
  @BeforeTest
  public void beforeTest() throws MalformedURLException 
  {
	  DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vertualMob");    //mobile name
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);  //specifying automator name
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacademy.android");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity" );
		driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
  }
  @Test
  public void testcase1() 
  {
	  
	  WebDriverWait wait= new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.TextView")));
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Sign in\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Continue with Google\")")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.LinearLayout")));
	  driver.findElements(MobileBy.className("android.widget.LinearLayout")).get(1).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.Button")));
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Join class\")")).click();
	  driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("Sample@gmail.com");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.Button")));
      driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD\")")).click();
      driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD\")")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/button1")));
      driver.findElement(MobileBy.id("android:id/button1")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.ImageView")));
	  driver.findElement(MobileBy.className("android.widget.ImageView")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.TextView")));
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Manage teachers\")")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //implicit wait
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Get started\"))").click();
	  //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Get started\").instance(0))").click();
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Edit\"))").click();
	  //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Graduate studies\"))").click();
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Computer science\"))").click();
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Computer programming\"))").click();
	  //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Computer programming\"))");
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Done\")")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.ImageView")));
	  driver.findElement(MobileBy.className("android.widget.ImageView")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.TextView")));
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Sign out\"))").click();
	  driver.findElement(MobileBy.id("android:id/button1")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   //implicit wait
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  driver.pressKey(new KeyEvent(AndroidKey.HOME));
	  
	  
  }   
}
