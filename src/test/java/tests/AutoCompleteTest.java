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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import supportClasses.ActionPerformers;
import supportClasses.DriverCreator;

/**
 *
 * @author Erick Cabral
 */
public class AutoCompleteTest {

	public AutoCompleteTest() {
	}
	WebDriver browser;

	@Before
	public void setUp() {
		this.browser = DriverCreator.createChromeDriver(5);
	}

	@Test
	public void autocompleteTest() throws InterruptedException {
		WebElement textBox = this.browser.findElement(By.xpath("//input[@id='autocomplete']"));

		String inputCountry = "Tanzania"; //"Brazil";

		for (int i = 0; i < 3; i++) {
			textBox.sendKeys(String.valueOf(inputCountry.charAt(i)));
			Thread.sleep(500);
		}
		WebElement autoCompleteBox = this.browser.findElement(By.xpath("//ul[@id='ui-id-1']"));
		int autoElements = autoCompleteBox.findElements(By.tagName("li")).size();
		System.out.println("List Size -> " + autoElements);

		for (int i = 0; i < autoElements; i++) {
			ActionPerformers.sendActionKey(browser, Keys.DOWN);
			if (autoCompleteBox.findElements(By.tagName("li")).get(i).getText().contains(inputCountry)) {
				System.out.println("CHOOSEN---> " + autoCompleteBox.findElements(By.tagName("li")).get(i).getText());
				ActionPerformers.sendActionKey(browser, Keys.ENTER);
				break;
			}
		}
		//Porque que dá pau se usar Thread.sleep?
		assertEquals(inputCountry, textBox.getText().contains(inputCountry));
	}

}
