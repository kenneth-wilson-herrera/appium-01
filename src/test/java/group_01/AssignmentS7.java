package group_01;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
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
		optionOne();
		
	//OK Cancel dialog with a long message
		optionTwo();
		
	//OK Cancel dialog with ultra long message
		optionThree();
		
	//List dialog
		optionFour();
		
	//Progress dialog
		optionFive();
		
		
	//Single choice list
		optionSix();
		
	//Repeat alarm
		optionSeven();
		
	//Send Call to VoiceMail
		optionEight();
		
	//Text Entry dialog
		optionNine();
		
	//OK Cancel dialog with traditional theme
		optionTen();
		
	//OK Cancel dialog with Holo Light theme
		optionEleven();
		
		Thread.sleep(3000);
//		WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
//		
//		dragDropAction(source, 1050, 900);
//		Thread.sleep(3000);
//		String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
//		Assert.assertEquals(result, "Dropped!");
	}
	
	private void optionOne() {
		//OK Cancel dialog with a message
		driver.findElement(AppiumBy.xpath("//android.widget.Button[1]")).click();
		String message1 = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(message1.contains("Lorem ipsum dolor"), true);
		//Tap OK
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		//Tap Cancel
		driver.findElement(AppiumBy.xpath("//android.widget.Button[1]")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();
	}
	private void optionTwo() {
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
	}
	private void optionThree() {
		//OK Cancel dialog with ultra long message
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText(), "Header title");
		swipeAction(driver.findElement(AppiumBy.id("android:id/message")), "up");
		//Tap Something
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button3']")).click();
				
		//Tap OK
		driver.findElement(AppiumBy.xpath("//android.widget.Button[3]")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/message")).getText().contains("Plasa"), true);
		swipeAction(driver.findElement(AppiumBy.id("android:id/message")), "down");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
				
		//Tap Cancel
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='OK Cancel dialog with ultra long message']")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/message")).getText().contains("mako"), true);
		driver.findElement(AppiumBy.id("android:id/button2")).click();
	}
	private void optionFour() {
		//List dialog
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/select_button")).click();
		//Command one
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/text1")).getText(), "Command one");
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText().contains("0 , Command one"), true);
		action_clickOnPosition(300, 400);
		//Command two
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/select_button")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[2]")).getText(), "Command two");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[2]")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText().contains("1 , Command two"), true);
		action_clickOnPosition(300, 400);
		//Command three
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/select_button")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[3]")).getText(), "Command three");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[3]")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText().contains("2 , Command three"), true);
		action_clickOnPosition(300, 400);
		//Command three
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/select_button")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[4]")).getText(), "Command four");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[4]")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/message']")).getText().contains("3 , Command four"), true);
		action_clickOnPosition(300, 400);
	}
	
	private void optionFive() {
		//Progress dialog
		driver.findElement(AppiumBy.accessibilityId("Progress dialog")).click();
		//Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Header title']")).getText(), "Header title");
		action_clickOnPosition(500, 1000);
	}
	
	private void optionSix() {
		//Single choice list
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText(), "Single choice list");
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Map']")).getAttribute("checked").equals("true"));
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Satellite']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Traffic']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[4]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Map']")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
	}
	
	private void optionSeven() {
		//Repeat alarm
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText(), "Repeat alarm");
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Every Tuesday']")).getAttribute("checked").equals("true"));
		//Not the same		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Every Tuesday']")).isSelected());
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[1]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[2]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[3]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[4]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[5]")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Every Tuesday']")).getAttribute("checked").equals("false"));
		driver.findElement(AppiumBy.id("android:id/button2")).click();
	}
	private void optionEight() {
		//Send Call to VoiceMail
		driver.findElement(AppiumBy.accessibilityId("Send Call to VoiceMail")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText(), "Send Call to VoiceMail");
		action_clickOnPosition(300, 400);
	}
	
	private void optionNine() {
		//Text Entry dialog
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Text Entry dialog']")).click();
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/username_edit']")).isDisplayed());
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/username_edit']")).sendKeys("Zeradias");
		Assert.assertTrue(driver.findElement(AppiumBy.id("io.appium.android.apis:id/password_edit")).getAttribute("password").equals("true"));
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/password_edit")).sendKeys("Zerato");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
	}
	
	private void optionTen() {
		//OK Cancel dialog with traditional theme
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons_old_school")).click();
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id='android:id/parentPanel']")).getAttribute("enabled").equals("true"));
		//Click OK
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		//Click Cancel
		driver.findElement(AppiumBy.xpath("//android.widget.Button[10]")).click();
		Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText().contains("aie"));
		driver.findElement(AppiumBy.id("android:id/button2")).click();
	}
	
	private void optionEleven() {
		//OK Cancel dialog with Holo Light theme
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons_holo_light")).click();
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id='android:id/parentPanel']")).getAttribute("enabled").equals("true"));
		//Click OK
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		//Click Cancel
		driver.findElement(AppiumBy.xpath("//android.widget.Button[11]")).click();
		Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText().contains("aie"));
		driver.findElement(AppiumBy.id("android:id/button2")).click();
	}

}
