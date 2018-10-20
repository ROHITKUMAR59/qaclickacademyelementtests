/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Erick Cabral
 */
public class ActionPerformers {
     
     public static void mouseDoubleClickAt(WebDriver browser, WebElement element){
          Actions dbClick = new Actions(browser);
          dbClick.doubleClick(element).build().perform();
     }
     
     public static void mouseMoveTo(WebDriver browser, WebElement moveTo){
          Actions move = new Actions(browser);
          move.moveToElement(moveTo).build().perform();
     }
     public static void mouseMoveToAndClick(WebDriver browser, WebElement moveTo){
          Actions move = new Actions(browser);
          move.moveToElement(moveTo).click().build().perform();
     }
     
     public static void sendActionKey(WebDriver browser, Keys actionKey){
          Actions key = new Actions(browser);
          key.sendKeys(actionKey).build().perform();
     }
}
