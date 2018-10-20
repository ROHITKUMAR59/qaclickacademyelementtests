/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportClasses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Erick Cabral
 */
public class DriverCreator {

	public static WebDriver createChromeDriver(int implicityWaitSeconds) {
		System.setProperty("webdriver.chrome.driver", "F:\\Cursos\\JAVA SE\\WebDrivers\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(implicityWaitSeconds, TimeUnit.SECONDS);
		browser.get("http://www.qaclickacademy.com/practice.php");
		browser.manage().window().maximize();
		return browser;
	}

}
