/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import supportClasses.DriverCreator;

/**
 *
 * @author Erick Cabral
 */
public class AlertJavaScriptTest {

	public AlertJavaScriptTest() {
	}
	WebDriver browser;
	WebDriverWait explWait;

	@Before
	public void setUp() {
		this.browser = DriverCreator.createChromeDriver(5);
		this.explWait = new WebDriverWait(browser, 50);
	}

	@Test
	public void alertOkTest() throws InterruptedException {
		WebElement alertContainder = this.browser.findElement(By.xpath("//fieldset[@class='alert_example']"));
		String inputName = "Fulano";

		alertContainder.findElement(By.id("name")).sendKeys(inputName);

		Thread.sleep(1000);
		alertContainder.findElement(By.id("alertbtn")).click();

		this.explWait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(1000);
		String alertMessage = String.format("Hello %s, share this practice page and share your knowledge", inputName);

		String alertMessageGotten = this.browser.switchTo().alert().getText();
		System.out.println("Alert Message -> " + alertMessage);

		assertEquals(alertMessage, alertMessageGotten);

		this.browser.switchTo().alert().accept();
	}

	@Test
	public void alertOptionTest() throws InterruptedException {
		WebElement alertContainder = this.browser.findElement(By.xpath("//fieldset[@class='alert_example']"));
		String inputName = "Beltrano";

		for (int i = 1; i < 3; i++) {
			alertContainder.findElement(By.id("name")).sendKeys(inputName);
			Thread.sleep(1000);

			alertContainder.findElement(By.id("confirmbtn")).click();
			this.explWait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(1000);

			String alertMessage = String.format("Hello %s, Are you sure you want to confirm?", inputName);
			String alertMessageGotten = this.browser.switchTo().alert().getText();
			System.out.println("Alert Message -> " + alertMessage);

			assertEquals(alertMessage, alertMessageGotten);

			if (i == 1) {
				this.browser.switchTo().alert().accept();
			} else {
				this.browser.switchTo().alert().dismiss();
			}
			this.browser.switchTo().defaultContent();
		}

	}
}
