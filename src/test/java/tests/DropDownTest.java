/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import supportClasses.ActionPerformers;
import supportClasses.DriverCreator;

/**
 *
 * @author Erick Cabral
 */
public class DropDownTest {

	public DropDownTest() {
	}

	WebDriver browser;
	WebDriverWait explicityWait;

	@Before
	public void setUp() {
		browser = DriverCreator.createChromeDriver(5);
		explicityWait = new WebDriverWait(browser, 1000L);
	}

	@Test
	public void usingKeyActionSelection() throws InterruptedException {
		WebElement dropdownElement = this.browser.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropSelect = new Select(dropdownElement);
		int elements = dropSelect.getOptions().size();

		for (int i = 0; i < elements; i++) {
			dropdownElement.click();
			if (i > 0) {
				Thread.sleep(1000L);
				ActionPerformers.sendActionKey(browser, Keys.DOWN);
				Thread.sleep(1000L);
				ActionPerformers.sendActionKey(browser, Keys.ENTER);
			} else {
				Thread.sleep(1000L);
				ActionPerformers.sendActionKey(browser, Keys.ENTER);
			}
			System.out.println("ELEMENT " + i + " -> " + dropSelect.getFirstSelectedOption().getText());
		}
	}

	//@Test
	public void usingDirectSelection() throws InterruptedException {
		WebElement dropdownElement = this.browser.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropOptions = new Select(dropdownElement);
		int elements = dropOptions.getOptions().size();

		for (int i = 0; i < elements; i++) {
			dropdownElement.click();
			if (i > 0) {
				Thread.sleep(1000L);
				ActionPerformers.sendActionKey(browser, Keys.DOWN);
				Thread.sleep(1000L);
				ActionPerformers.sendActionKey(browser, Keys.ENTER);
			} else {
				Thread.sleep(1000L);
				ActionPerformers.sendActionKey(browser, Keys.ENTER);
			}
			System.out.println("ELEMENT " + i + " -> " + dropOptions.getFirstSelectedOption().getText());
		}
	}

}
