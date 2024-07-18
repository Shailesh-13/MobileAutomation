package mobilecalculator.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import mobilecalculator.base.MobileBaseTest;
import mobilecalculator.pages.CalculatorObjects;

public class TestCalculator extends MobileBaseTest{

	
	CalculatorObjects cal;
	AppiumDriver driver;
	@BeforeTest
	public void startUp() {
		intializeDriver();
	}
    @Test (priority = 1,description = "User can Summation if provides two numbers")
    public void doSum() throws InterruptedException {
//        cal = new CalculatorObjects(driver);
//        String sum = cal.doSum();
//        System.out.println(sum);
//        Assert.assertEquals(sum, "14");
//        cal.btnClr.clear();
        Thread.sleep(8000);
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        System.out.println(driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());

    }
}
