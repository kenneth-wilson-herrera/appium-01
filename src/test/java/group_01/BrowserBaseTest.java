package group_01;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("\\Users\\kenny\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("TestDevice1");
		options.setChromedriverExecutable("C:\\Users\\kenny\\OneDrive\\Documents\\chromedriver-113\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		options.setCapability("autoGrantPermissions", true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
