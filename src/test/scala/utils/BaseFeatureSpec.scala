package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.lift.Matchers
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.support.FindBy
import org.scalatest.{BeforeAndAfterEach, FeatureSpec, GivenWhenThen, MustMatchers}

trait BaseFeatureSpec extends FeatureSpec with GivenWhenThen with DriverInitialisation with MustMatchers with WebBrowser with BeforeAndAfterEach{

  override def beforeEach: Unit = {
//    implicit val driver = SingletonDriver.driver
    delete all cookies
    deleteAllCookies()
    driver.manage().window().maximize()
//implicit lazy val driver = SingletonDriver.driver
  }

  override def afterEach: Unit = {
  }
}
