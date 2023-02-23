package mob_testing;

import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Hybrid_app extends Capability{

	AndroidDriver<AndroidElement> driver;
	@Test
	public void testcase1() throws MalformedURLException 
	{
		driver = Cap();           //extending cap from capability
		WebDriverWait wait= new WebDriverWait(driver, 30);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Adam");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD TO CART\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD TO CART\")")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.androidsample.generalstore:id/productPrice")));
		String p1 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		System.out.println("\nprice-1:   "+p1);
		String p2 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		System.out.println("\nprice-2:   "+p2);
		String p3 = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println("\nTotal Price App:   "+p3);
		p1 = p1.substring(1);
		Double dp1 = Double.parseDouble(p1);
		p2 = p2.substring(1);
		Double dp2 = Double.parseDouble(p2);
		p3 = p3.substring(2);
		Double dp3 = Double.parseDouble(p3);
		Double total=dp1+dp2;
		System.out.println("\nTotal Price Manual:   " +total);
		if(total.equals(dp3))
		{
			System.out.println("\nAssertion Passed\n");
		}
		else {
			System.out.println("\nAssertion Failed\n");
		}
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
}
}