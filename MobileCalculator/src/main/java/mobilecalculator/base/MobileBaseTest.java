package mobilecalculator.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class MobileBaseTest {

	public static AppiumDriver driver;
	URL appiumURL=null;
	public static Properties prop;
	
	public MobileBaseTest() {
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\config.properties");
			prop.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public AppiumDriver intializeDriver() {
		try {
			appiumURL=new URL(MobileConstants.APPIUM_URL);
			driver=new AppiumDriver(appiumURL,setAppCapabilities());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public DesiredCapabilities setAppCapabilities() {
		 DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", prop.getProperty("deviceName"));
	        caps.setCapability("uuid", prop.getProperty("uuid"));
	        caps.setCapability("platformName", prop.getProperty("platformName"));
	        caps.setCapability("platformVersion", prop.getProperty("platformVersion"));
	        caps.setCapability("appPackage", prop.getProperty("appPackage"));
	        caps.setCapability("appActivity", prop.getProperty("appActivity"));
	        caps.setCapability("app", prop.getProperty("app"));
	      return caps;
	}
	public String takeScreenShotPath(String testCaseName,AppiumDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String screenShotDest=System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		try {
			FileUtils.copyFile(src,new File(screenShotDest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenShotDest;
	}
}





























