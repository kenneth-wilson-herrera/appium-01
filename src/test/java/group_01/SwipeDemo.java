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

public class SwipeDemo extends BaseTest{

	@Test
	public void SwipeDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException 
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[1])"));
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[1])")).getAttribute("focusable"), "true");
		//Swipe
		swipeAction(firstImage, "left");
		
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[1])")).getAttribute("focusable"), "false");

		
	}
	
}
