package org.base;


import java.io.IOException;

import org.global.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestScript extends BaseClass {
	public static void main(String[] args) throws IOException    {
		BaseClass base = new BaseClass();
		base.getDriver("Chrome");
		base.launchUrl("https://adactinhotelapp.com/");
		base.winMax();
		base.screenCapture();
		WebElement user = driver.findElement(By.id("username"));
		base.sendKeysByJava(user, "Velayutham");
		WebElement pass = driver.findElement(By.id("password"));
		base.sendKeysByJava(pass, "Velu@1994");
		WebElement loginButton = driver.findElement(By.id("login"));
	base.clickLogin(loginButton);
		
		WebElement searchHotel = driver.findElement(By.xpath("//td[text()='Search Hotel ']"));
		
		boolean displayed = searchHotel.isDisplayed();
		
		if (displayed) {
			System.out.println("User is in " + searchHotel.getText() + " Page");
		} else {
			System.out.println("User is Not in " + searchHotel.getText() + " Page");

		}
		
}
}