package mob_testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstMobTest {
AndroidDriver<AndroidElement> driver;

@BeforeTest
public void bt() throws MalformedURLException
{
	DesiredCapabilities dc = new DesiredCapabilities();
	//dc.setCapability(MobileCapabilityType.NO_RESET, true);
    
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vertualMob");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	dc.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
	//dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\swapn\\eclipse-workspace\\mobile_testing\\chromedriver.exe");
	driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
}

@Test
public void testcase1() throws InterruptedException 
{
	driver.get("https://www.google.com/");
	WebDriverWait wait= new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"gLFyf\"]")));
	driver.findElement(By.xpath("//*[@class=\"gLFyf\"]")).sendKeys("orangehrm demo");
	Actions act= new Actions(driver);
	act.sendKeys(Keys.ENTER).build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("OrangeHRM Demo.")));
	driver.findElement(By.partialLinkText("OrangeHRM Demo.")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"username\"]")));
	driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys("Admin");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-input oxd-input--active']")));
	driver.findElement(By.xpath("//*[@class='oxd-input oxd-input--active']")).sendKeys("admin123");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")));
	driver.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
}
}
