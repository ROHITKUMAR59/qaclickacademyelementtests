/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import supportClasses.DriverCreator;

/**
 *
 * @author Erick Cabral
 */
public class CheckBoxTest {

	public CheckBoxTest() {
	}

	WebDriver browser;

	@Before
	public void setUp() {
		this.browser = DriverCreator.createChromeDriver(5);

	}

	@Test
	public void checkboxSelection() throws InterruptedException {
		WebElement divBox = this.browser.findElement(By.xpath("//div[@id='checkbox-example']"));
		int elements = divBox.findElements(By.xpath("//input[@type='checkbox']")).size();
		for (int i = 0; i < elements; i++) {
			divBox.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
			Thread.sleep(1000L);
			System.out.println("CHECKBOX VALUE -> " + divBox.findElements(By.xpath("//input[@type='checkbox']")).get(i).getAttribute("value"));
		}

		for (int i = 0; i < elements; i++) {
			if (divBox.findElements(By.xpath("//input[@type='checkbox']")).get(i).isSelected()) {
				divBox.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
			}
			Thread.sleep(1000L);
		}
	}

}
