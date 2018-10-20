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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import supportClasses.DriverCreator;

/**
 *
 * @author Erick Cabral
 */
public class RadioButtonTest {

     WebDriver browser;
     WebDriverWait explicityWait;

     public RadioButtonTest() {
     }

     @Before
     public void setUp() {
          this.browser = DriverCreator.createChromeDriver(5);
          explicityWait = new WebDriverWait(browser, 1000L);
     }

     @Test
     public void radioClickTest() throws InterruptedException {
          WebElement radioDiv = this.browser.findElement(By.xpath("//div[@id='radio-btn-example']"));
          int elements = radioDiv.findElements(By.className("radioButton")).size();
          for (int i = 0; i < elements; i++) {
               Thread.sleep(1000L);
               radioDiv.findElements(By.className("radioButton")).get(i).click();
          }
     }

}
