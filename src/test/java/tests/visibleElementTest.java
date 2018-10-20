/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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
public class visibleElementTest {

     public visibleElementTest() {
     }
     WebDriver browser;

     @Before
     public void setUp() {
          this.browser = DriverCreator.createChromeDriver(5);
     }

     @Test
     public void visibleElementTest() throws InterruptedException {
          WebElement btnHide = this.browser.findElement(By.xpath("//input[@id='hide-textbox']"));
          WebElement btnShow = this.browser.findElement(By.xpath("//input[@id='show-textbox']"));
          WebElement textField = this.browser.findElement(By.xpath("//input[@id='displayed-text']"));

          String inputText = "TextField is Visible";

          for (int i = 0; i < inputText.length(); i++) {
               textField.sendKeys(String.valueOf(inputText.charAt(i)));
               if (i == (inputText.length() - 1)) {
                    inputText = "[Clicking Hide]";
                    
                    textField.clear();
                    textField.sendKeys(inputText);

                    Thread.sleep(500L);
                    textField.clear();
                    btnHide.click();
               }
               Thread.sleep(500L);
          }

          btnShow.click();
          inputText = "Buton Show Clicked";

          for (int i = 0; i < inputText.length(); i++) {
               textField.sendKeys(String.valueOf(inputText.charAt(i)));
               Thread.sleep(500L);
               if (i == (inputText.length() -1)) {
                    textField.clear();
                    textField.sendKeys("Test Done!");
                    Thread.sleep(1000L);
                    btnHide.click();
               }
          }
          assertTrue(!textField.isDisplayed());
     }
}
