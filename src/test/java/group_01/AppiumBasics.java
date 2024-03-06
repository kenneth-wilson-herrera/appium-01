package group_01;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest{

	@Test
	public void WifiSettingsName() throws MalformedURLException, URISyntaxException {
		
		//ConfigureAppium();
		//Actual automation
		//Xpath, id, accessibilityId, className, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout) [2]")).click();
		String alert = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alert, "WiFi settings");
		
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Wifi");
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//tearDown();		
	}
	
}
