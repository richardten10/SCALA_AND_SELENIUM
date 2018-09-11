package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

trait DriverInitialisation {
//  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Richard Rawson\\Downloads\\chromedriver.exe")
//  implicit lazy val driver: WebDriver = new ChromeDriver()
  implicit lazy val driver = SingletonDriver.driver
}

object SingletonDriver {
  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Richard Rawson\\Downloads\\chromedriver.exe")
  implicit lazy val driver: WebDriver = new ChromeDriver()
}
