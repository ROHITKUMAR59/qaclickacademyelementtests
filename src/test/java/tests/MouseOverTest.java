/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import supportClasses.ActionPerformers;
import supportClasses.DriverCreator;

/**
 *
 * @author Erick Cabral
 */
public class MouseOverTest {

	public MouseOverTest() {
	}

	WebDriver browser;

	@Before
	public void setUp() {
		this.browser = DriverCreator.createChromeDriver(5);
	}

	@Test
	public void mouseOverSelectionTest() {
		WebElement mouseOverButton = this.browser.findElement(By.xpath("//button[@id='mousehover']"));
		WebDriverWait waitTill = new WebDriverWait(browser, 5);

		ActionPerformers.mouseMoveTo(browser, mouseOverButton);
		WebElement mouseOverMenu = this.browser.findElement(By.xpath("//div[@class='mouse-hover-content']"));

		waitTill.until(ExpectedConditions.visibilityOf(mouseOverMenu));
		List<WebElement> buttonLinks = this.browser.findElements(By.xpath("//div[@class='mouse-hover-content']/a"));

		String linkToClick = "Reload";

		for (WebElement finder : buttonLinks) {
			if (finder.getText().equalsIgnoreCase(linkToClick)) {
				finder.click();
			}
		}
	}

}
