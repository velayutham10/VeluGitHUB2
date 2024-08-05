package org.global;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.graphbuilder.struc.LinkedList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static JavascriptExecutor javascriptExecutor;
	public static Select select;

	public static void getDriver(String browserType) {
		
		switch(browserType) {
		case "Chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
			default:
				System.out.println("Ivalid browser type");
				break;
				
		}
		
	}

	public void winMax() {
		driver.manage().window().maximize();
	}

	public void launchUrl(String browserUrl) {
		driver.get(browserUrl);
	}

	public void sendKeysByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);

	}

	public void sendKeysByJS(WebElement element, String keysToSend) {
		
		javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);

	}

	public void clickLogin(WebElement element) {
		element.click();
		
			}

	public void scrollByJS(WebElement element, String scrollType) {

		switch (scrollType) {
		case "Up":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", element);
			break;

		case "Down":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
			break;

		default:
			System.out.println("InValid_ScrollType");
			break;
		}

	}

	

	public void screenCapture() throws IOException   {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("C:\\Users\\HP\\eclipse-workspace\\BaseClassPractice\\EroorScreenshot" + System.currentTimeMillis() + ".jpeg");
		FileUtils.copyFile(screenshotAs, targetFile);

	}

	public void navigation(String commands) {

		switch (commands) {
		case "refresh":
			driver.navigate().refresh();
			break;

		case "forward":
			driver.navigate().forward();
			break;

		case "back":
			driver.navigate().back();
			;
			break;

		default:
			System.out.println("InValid_Commands");
			break;
		}

	}

	public void selectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void sleep(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}

}
