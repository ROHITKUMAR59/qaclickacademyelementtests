/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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
public class FrameTest {

     public FrameTest() {
     }
     WebDriver browser;

     @Before
     public void setUp() {
          this.browser = DriverCreator.createChromeDriver(5);
     }

     @Test
     public void frameLinkClickTest() throws InterruptedException {
          WebElement framePage = this.browser.findElement(By.xpath("//iframe[@name='iframe-name']"));
          
          List<WebElement> frameMainLinks = this.browser.switchTo().frame(framePage).findElements(By.xpath("//ul[contains(@class,'navbar')]/li/a"));

          String linkToClick = "toxo";
          String titleTobeTested = null;

          for (WebElement finder : frameMainLinks) {
               System.out.println("SEARCHING LINKS -> " + finder.getAttribute("href"));
               if (finder.getText().equalsIgnoreCase(linkToClick)) {
                    System.out.println("LINK FOUND -> " + finder.getAttribute("href"));
                    
                    finder.click();                    
                    //Thread.sleep(3000);                    
                    titleTobeTested = this.browser.findElement(By.tagName("title")).getAttribute("innerHTML");
                    System.out.println("TITLE FOUND -> " + titleTobeTested);
                    
                    assertTrue(titleTobeTested.contains(linkToClick));
                    break;
               }
          }
          this.browser.switchTo().defaultContent();
     }
}
