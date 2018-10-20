/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Iterator;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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
public class MultipleBrowsersTest {

     public MultipleBrowsersTest() {
     }

     WebDriver browser;

     @Before
     public void setUp() {
          this.browser = DriverCreator.createChromeDriver(5);

     }

     @Test
     public void multipleBrowserTest() throws InterruptedException {
          String parentTitle = this.browser.getTitle();
          this.browser.findElement(By.xpath("//button[@id='openwindow']")).click();
          Thread.sleep(2000);
          //Browser Handler
          Set<String> broswersIds = this.browser.getWindowHandles();
          Iterator<String> brwsrIterator = broswersIds.iterator();
          String parentId = brwsrIterator.next();
          String childId = brwsrIterator.next();

          this.browser.switchTo().window(childId);
          String childTitle = this.browser.getTitle();
          System.out.println("PARENT TITLE -> " + parentTitle + "\n" + "CHILD TITLE -> " + childTitle);

          this.browser.findElement(By.xpath("//a[text()='About']")).click();
          Thread.sleep(2000);
          this.browser.findElement(By.xpath("//a[text()='Courses']")).click();
          Thread.sleep(2000);
          this.browser.close();

          this.browser.switchTo().window(parentId);
          assertEquals(parentTitle, this.browser.getTitle());
     }

}
