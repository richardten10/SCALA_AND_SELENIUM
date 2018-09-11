package Pages

import org.openqa.selenium.{Keys, WebDriver, WebElement}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.lift.Matchers
import org.openqa.selenium.support.PageFactory
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Seconds, Span}
import org.scalatest.words.ShouldVerb
import org.scalatest.{FeatureSpec, GivenWhenThen, MustMatchers, time}
import utils.BaseFeatureSpec
import scala.util.Random

object Homepage extends BaseFeatureSpec {

  @FindBy (xpath = "//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")
  var outDateAssert: WebElement = _

  def findOutDateAssert(): Option[Homepage.Element] = {
      return find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4"))
  }

  def findOutDateAssert1(): Unit = {
    find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4"))
  }

  def findOutDate(webDriver: WebDriver): Unit = {
      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text
    }

      @FindBy(css = "._rk5m7u ._6d98wc:nth-of-type(1) [aria-haspopup='false']:nth-of-type(2) span")
      var tomorrow: WebElement = _

      def findtomorrow(): Option[Homepage.Element] = {
        return find(cssSelector("._rk5m7u ._6d98wc:nth-of-type(1) [aria-haspopup='false']:nth-of-type(2) span"))
      }

      @FindBy(css = "._rk5m7u ._6d98wc:nth-of-type(2) [aria-haspopup='false']:nth-of-type(2) span")
      var nextDay: WebElement = _

      def findNextDay(): Option[Homepage.Element] = {
        return find(cssSelector("._rk5m7u ._6d98wc:nth-of-type(2) [aria-haspopup='false']:nth-of-type(2) span"))
      }

      @FindBy(css = "._ycrncc")
      var popUp: WebElement = _

      def findPopUp(): Option[Homepage.Element] = {
        return find(cssSelector("._ycrncc"))
      }

      @FindBy(css = "._11rhhtw span")
      var submit: WebElement = _

      def findSubmit(): Option[Homepage.Element] = {
        return find(cssSelector("._11rhhtw span"))
      }

      def goToHomepage(): Unit = {
        go to "https://www.thetrainline.com"
      }

      def assertPageTitle(): Unit = {
        pageTitle must include regex ("Trainline")

      }

      def setFromText(text: String)(): Unit = {
        searchField("from.text").value = text

      }

      def setToText(text: String)(): Unit = {
        searchField("to.text").value = text

      }

      def assertNextDayDateCorrect(text: String)(): Unit = {
        //    outDateAssert.getText must include regex text
        findOutDateAssert().get.text must include regex text
//        find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex text
      }

      def CLICK_ON_RETURN(): Unit = {
        click on "return"
      }

      def CLICK_ON_TOMORROW(): Unit = {
        //    tomorrow.click()
        findtomorrow().get.underlying.click()
      }

      def CLICK_ON_NEXTDAY(): Unit = {
        //    nextDay.click()
        findNextDay().get.underlying.click()
      }

      def CLOSE_POPUP(): Unit = {
        //    popUp.click()
        findPopUp().get.underlying.click()
      }

      def CLICK_ON_SUBMIT(): Unit = {
        //    submit.click()
        findSubmit().get.underlying.click()
      }


      def getRandom: Int = {
        val randomAmount: Int = Random.nextInt(8)
        return randomAmount
      }

     var storeRandom = getRandom

  def scrollDownForever: Unit = {
    val currentElement = driver.switchTo.activeElement
    var i = 0
    while (i<100) {
      currentElement.sendKeys(Keys.PAGE_DOWN)
      Thread.sleep(5000)
      i = i+1
    }
  }


  def selectAmountofAdults(): Unit = {
//        val randomAmount: Int = Random.nextInt(8)
//        storeRandom = randomAmount
        find(cssSelector("._1jawgtw")).get.underlying.click() // clicks on first drop down
        find(cssSelector("[aria-label='select adults']")).get.underlying.click() // clicks on next drop down
        val currentElement = driver.switchTo.activeElement
        var i = storeRandom
        while (i>=0) {
          currentElement.sendKeys(Keys.DOWN)
          i=i-1
        }
        currentElement.sendKeys(Keys.RETURN)
      }

  def selectDate(daysInFuture: Long): Unit = {
    find(cssSelector("._rk5m7u ._6d98wc:nth-of-type(1) input")).get.underlying.click()  // click drop down
    find(cssSelector("._1eu0ye0d")).get.underlying.click()   // click last month - does nothing
    // put in x amount of right keys
    val currentElement = driver.switchTo.activeElement
    for (i<- 0 until daysInFuture.toInt) {
      currentElement.sendKeys(Keys.RIGHT)
    }

    // click enter
    currentElement.sendKeys(Keys.RETURN)
  }

  def getFullMonthName: String = {
    var monthToReturn: String = ""
    TimetablePage.getMonthFunction match {
      case "Sep" => monthToReturn = "September"
      case "Oct" => monthToReturn = "October"
      case "Nov" => monthToReturn = "November"
      case "Dec" => monthToReturn = "December"
      case _ => monthToReturn = TimetablePage.getMonthFunction
    }
    return monthToReturn
  }

  def selectFromDate7: Unit = {
    find(cssSelector("._rk5m7u ._6d98wc:nth-of-type(1) input")).get.underlying.click()  // click drop down
    // search for month required (getFullMonthName), use xpath contains
    var i = 0
    while (i<1) {
      Thread.sleep(3500)
      if (!(find(cssSelector("#app > div > div._19gn58z > main > div._5a1kud > div > div > div._mc6f42 > section > form > div._rk5m7u > fieldset:nth-child(1) > div._e296pg > div._120r9raNaN > div > div:nth-child(2) > h3")).get.text.contains(getFullMonthName))) {//regex (s"$getFullMonthName"))) {
        println(find(cssSelector("#app > div > div._19gn58z > main > div._5a1kud > div > div > div._mc6f42 > section > form > div._rk5m7u > fieldset:nth-child(1) > div._e296pg > div._120r9raNaN > div > div:nth-child(2) > h3")).get.text)
      println(s"$getFullMonthName")
      find(cssSelector("._117qauee")).get.underlying.click()
    }
      else {
        i = i + 1
      }
      Thread.sleep(3500)
      // click on day
      // NEED TO CLICK ON RIGHT MONTH
    }
      // if getFullMonthName is on left, click left day, if not click right day
      find(linkText(TimetablePage.getDaysFunction.toString)).get.underlying.click()
//    find(linkText(TimetablePage.getDaysFunction.toString)).get.

  }




    }


