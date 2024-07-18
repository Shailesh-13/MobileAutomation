package mobilecalculator.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobilecalculator.base.MobileBaseTest;

public class CalculatorObjects extends MobileBaseTest{
	
	public AppiumDriver driver;
	
	public CalculatorObjects(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.google.android.calculator:id/digit_9")
	WebElement number_9;
	@FindBy(id = "com.google.android.calculator:id/digit_8")
	WebElement number_8;
	@FindBy(id = "com.google.android.calculator:id/digit_7")
	WebElement number_7;
	@FindBy(id = "com.google.android.calculator:id/digit_6")
	WebElement number_6;
	@FindBy(id = "com.google.android.calculator:id/digit_5")
	WebElement number_5;
	@FindBy(id = "com.google.android.calculator:id/digit_4")
	WebElement number_4;
	@FindBy(id = "com.google.android.calculator:id/digit_3")
	WebElement number_3;
	@FindBy(id = "com.google.android.calculator:id/digit_2")
	WebElement number_2;
	@FindBy(id = "com.google.android.calculator:id/digit_1")
	WebElement number_1;
	@FindBy(id = "com.google.android.calculator:id/digit_0")
	WebElement number_0;
	@FindBy(id = "com.google.android.calculator:id/op_add")
	WebElement plusSymbol;
	@FindBy(id = "com.google.android.calculator:id/op_sub")
	WebElement minusSymbol;
	@FindBy(id = "com.google.android.calculator:id/op_mul")
	WebElement multipicationSymbol;
	@FindBy(id = "com.google.android.calculator:id/op_div")
	WebElement divisionSymbol;
	@FindBy(id = "com.google.android.calculator:id/eq")
	WebElement equalSymbol;
	@FindBy(id = "com.google.android.calculator:id/result_final")
	WebElement resultFinal;
	@FindBy(id = "com.google.android.calculator:id/clr")
	WebElement clearButton;

	

	public void clearData() {
		clearButton.click();
	}

	public String performAddition(int num1, int num2) {
		useNumbers(extractDigits(num1));
		plusSymbol.click();
		useNumbers(extractDigits(num2));
		return resultFinal.getText();
	}

	public String performSubstraction(int num1, int num2) {
		useNumbers(extractDigits(num1));
		minusSymbol.click();
		useNumbers(extractDigits(num2));
		return resultFinal.getText();
	}

	public String performMultipication(int num1, int num2) {
		useNumbers(extractDigits(num1));
		multipicationSymbol.click();
		useNumbers(extractDigits(num2));
		return resultFinal.getText();
	}

	public String performDivision(int num1, int num2) {
		useNumbers(extractDigits(num1));
		divisionSymbol.click();
		useNumbers(extractDigits(num2));
		return resultFinal.getText();
	}

	public void useNumbers(List<Integer> digits) {

		for (Integer num : digits) {
			switch (num) {
			case 0:
				number_0.click();
				break;
			case 1:
				number_1.click();
				break;
			case 2:
				number_2.click();
				break;
			case 3:
				number_3.click();
				break;
			case 4:
				number_4.click();
				break;
			case 5:
				number_5.click();
				break;
			case 6:
				number_6.click();
				break;
			case 7:
				number_7.click();
				break;
			case 8:
				number_8.click();
				break;
			case 9:
				number_9.click();
				break;
			default:
				break;
			}
		}
	}

	public static List<Integer> extractDigits(int number) {
		List<Integer> digits = new ArrayList<Integer>();
		if (number < 0) {
			number = -number;
		}
		while (number > 0) {
			int digit = number % 10;
			digits.add(0, digit);
			number /= 10;
		}
		if (digits.isEmpty()) {
			digits.add(0);
		}
		return digits;
	}
}
