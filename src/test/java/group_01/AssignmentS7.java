package group_01;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AssignmentS7 extends BaseTest{

	@Test
	public void AlertDialogsTest() throws MalformedURLException, URISyntaxException, InterruptedException 
	{
		//App -> Alert Dialogs
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
	//OK Cancel dialog with a message
		driver.findElement(AppiumBy.xpath("//android.widget.Button[1]")).click();
		String message1 = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(message1.contains("Lorem ipsum dolor"), true);
		//Tap OK
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		//Tap Cancel
		driver.findElement(AppiumBy.xpath("//android.widget.Button[1]")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		
	//OK Cancel dialog with a long message
		driver.findElement(AppiumBy.xpath("//android.widget.Button[2]")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText(), "Header title");
		//Tap Something
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button3']")).click();
		
		//Tap OK
		driver.findElement(AppiumBy.xpath("//android.widget.Button[2]")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/message")).getText().contains("mada"), true);
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		
		//Tap Cancel
		driver.findElement(AppiumBy.xpath("//android.widget.Button[2]")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		
		Thread.sleep(3000);
//		WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
//		
//		dragDropAction(source, 1050, 900);
//		Thread.sleep(3000);
//		String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
//		Assert.assertEquals(result, "Dropped!");
	}
	
	
	
}
