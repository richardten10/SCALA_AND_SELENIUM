package Trainline

import java.lang.Exception
import java.time.LocalDate

import Pages.TimetablePage.daysToAdd
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.PageFactory
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.support.FindBy
import org.scalatest.time.{Seconds, Span}
import org.scalatest.words.ShouldVerb
import org.scalatest.{FeatureSpec, GivenWhenThen, MustMatchers, time}
import Pages.{Homepage, TimetablePage}
import utils.{BaseFeatureSpec, SingletonDriver}

import scala.util.control.Exception

class TrainlineMain extends BaseFeatureSpec {

//  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Richard Rawson\\Downloads\\chromedriver.exe")
//  implicit val driver: WebDriver = new ChromeDriver()
//  implicitlyWait(Span(10, Seconds))

  feature("To test the trainline website") {
    scenario("Exercise One") {
//      implicit val driver: WebDriver = new ChromeDriver()
      implicitlyWait(Span(10, Seconds))


      //      driver.manage.timeouts.pageLoadTimeout(3 ) =
      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"

      When("I enter in the two stations and click submit")
      searchField("from.text").value = "Brighton"
      searchField("to.text").value = "London Bridge "
//      val action =  searchField("to.text").value = "London Bridge
//      Await.result(action, 5 seconds)



      And("I click Get times & tickets")
      click on cssSelector(css.closePopUp)
      find(cssSelector(css.submit))
      click on cssSelector(css.submit)


      Then("The timetable page will be visible")


//      Thread.sleep(5000)
//      close()
    }

    scenario("Exercise two"){
//      implicit val driver: WebDriver = new ChromeDriver()
      implicitlyWait(Span(10, Seconds))

      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"
      pageTitle must include regex("Trainline")

      When("I enter in the two stations and click submit")
      searchField("from.text").value = "Brighton"
      searchField("to.text").value = "London Bridge "



      And("I click Get times & tickets")
      click on cssSelector(css.closePopUp)
      find(cssSelector(css.submit))
      click on cssSelector(css.submit)

      Then("The timetable page will be visible")
//      find(xpath("//div[@class='_11jkqip']")) mustBe (defined)
//      click on cssSelector(css.timetable)
//      Thread.sleep(5000)
      find(cssSelector(css.timetable)) mustBe (defined)

//      Thread.sleep(5000)
//      close()
    }

    scenario("Exercise three"){
//      implicit val driver: WebDriver = new ChromeDriver()
      implicitlyWait(Span(10, Seconds))

      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"
      pageTitle must include regex("Trainline")

      When("I enter in the two stations and click submit")
      click on "return"
      searchField("from.text").value = "Brighton"
      searchField("to.text").value = "London Bridge"
      click on cssSelector("._rk5m7u ._6d98wc:nth-of-type(1) [aria-haspopup='false']:nth-of-type(2) span") // clicks on Tomorrow

      click on cssSelector("._rk5m7u ._6d98wc:nth-of-type(2) [aria-haspopup='false']:nth-of-type(2) span") // next day

      //      textField("page.journeySearchForm.inbound.title").value = "Cheese!"
      //      find("page.journeySearchForm.inbound.title.text").get.text must include regex("Sep")

      And("I click Get times & tickets")
      click on cssSelector(css.closePopUp)
      find(cssSelector(css.submit))
      click on cssSelector(css.submit)

      Then("The timetable page will be visible")
      //      find(xpath("//div[@class='_11jkqip']")) mustBe (defined)
      //      click on cssSelector(css.timetable)
      Thread.sleep(5000)
      //      find(cssSelector(css.timetable)) mustBe (defined)

//      click on xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")
//      val b = find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4"))
//      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex("Sep")
      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex("Sep")
//      Homepage.outDateAssert.getText must include regex "Sep"


      // Homepage.outDateAssert.getText must include regex("Sep")
      //      Thread.sleep(7000)
//      close()
    }

    scenario("Exercise four"){
//      implicit val driver: WebDriver = new ChromeDriver()
      implicitlyWait(Span(10, Seconds))
//      val Homepage = PageFactory.initElements(driver, classOf[Homepage])

      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"
      pageTitle must include regex("Trainline")

      When("I enter in the two stations and click submit")
      click on "return"
      searchField("from.text").value = "Brighton"
      searchField("to.text").value = "London Bridge"

//      click on cssSelector("._rk5m7u ._6d98wc:nth-of-type(1) [aria-haspopup='false']:nth-of-type(2) span") // clicks on Tomorrow
      Homepage.tomorrow.click()
//      Homepage.tomorrow.click()

      //      click on Homepage.tomorrow // clicks on Tomorrow


      //      find(xpath(".//*[contains(text(),'morrow')]")).get.underlying.click()
      //      if (checkbox(css.oneWayBox).isSelected ==(true)) {
      //        checkbox(css.oneWayBox).clear()
      //      }
      //    if (checkbox("isOneWay").isSelected) {
      //      checkbox("isOneWay").clear()
      //    }
      //      if (checkbox("single").isSelected) {checkbox("return").click()}

//      click on Homepage.nextDay // next day
//      click on cssSelector("._rk5m7u ._6d98wc:nth-of-type(2) [aria-haspopup='false']:nth-of-type(2) span") // next day
      Homepage.nextDay.click()



      //      textField("page.journeySearchForm.inbound.title").value = "Cheese!"
      //      find("page.journeySearchForm.inbound.title.text").get.text must include regex("Sep")

      And("I click Get times & tickets")
//      click on cssSelector(css.closePopUp)
      Homepage.popUp.click()
//      find(cssSelector(css.submit))
//      click on cssSelector(css.submit)
      Homepage.submit.click()

      Then("The timetable page will be visible")
      //      find(xpath("//div[@class='_11jkqip']")) mustBe (defined)
      //      click on cssSelector(css.timetable)
      Thread.sleep(5000)
      //      find(cssSelector(css.timetable)) mustBe (defined)

      //      click on (xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4"))
      //      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex("Sep")
//      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex("Sep")//      Homepage.outDateAssert.getText must include regex("Sep")

      Homepage.outDateAssert.getText must include regex "Sep"

      //      find(xpath("sdsa")).get.text must include regex "dsfds"

      // Thread.sleep(7000)
//      close()
    }

    scenario("Exercise four +++++++++"){
//      implicit val driver: WebDriver = new ChromeDriver()
      implicitlyWait(Span(10, Seconds))
//      val Homepage = PageFactory.initElements(driver, classOf[Homepage])

      Given("I am on a the trainline website")
      Homepage.goToHomepage
//      pageTitle must include regex("Trainline")
      Homepage.assertPageTitle

      When("I enter in the two stations and click submit")
      click on "return"
      searchField("from.text").value = "Brighton"
      searchField("to.text").value = "London Bridge"

      //      click on cssSelector("._rk5m7u ._6d98wc:nth-of-type(1) [aria-haspopup='false']:nth-of-type(2) span") // clicks on Tomorrow
//      Homepage.tomorrow.click()
      Homepage.tomorrow.click()

      //      click on Homepage.tomorrow // clicks on Tomorrow


      //      find(xpath(".//*[contains(text(),'morrow')]")).get.underlying.click()
      //      if (checkbox(css.oneWayBox).isSelected ==(true)) {
      //        checkbox(css.oneWayBox).clear()
      //      }
      //    if (checkbox("isOneWay").isSelected) {
      //      checkbox("isOneWay").clear()
      //    }
      //      if (checkbox("single").isSelected) {checkbox("return").click()}

      //      click on Homepage.nextDay // next day
      //      click on cssSelector("._rk5m7u ._6d98wc:nth-of-type(2) [aria-haspopup='false']:nth-of-type(2) span") // next day
      Homepage.nextDay.click()



      //      textField("page.journeySearchForm.inbound.title").value = "Cheese!"
      //      find("page.journeySearchForm.inbound.title.text").get.text must include regex("Sep")

      And("I click Get times & tickets")
      //      click on cssSelector(css.closePopUp)
      Homepage.popUp.click()
      //      find(cssSelector(css.submit))
      //      click on cssSelector(css.submit)
      Homepage.submit.click()

      Then("The timetable page will be visible")
      //      find(xpath("//div[@class='_11jkqip']")) mustBe (defined)
      //      click on cssSelector(css.timetable)
      Thread.sleep(5000)
      //      find(cssSelector(css.timetable)) mustBe (defined)

      //      click on (xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4"))
      //      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex("Sep")
      //      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex("Sep")//      Homepage.outDateAssert.getText must include regex("Sep")

      Homepage.outDateAssert.getText must include regex "Sep"

      //      find(xpath("sdsa")).get.text must include regex "dsfds"

      // Thread.sleep(7000)
//      close()
    }
    scenario("Exercise five"){
//      implicit val driver: WebDriver = new ChromeDriver()
      implicitlyWait(Span(10, Seconds))
//      val Homepage = PageFactory.initElements(driver, classOf[Homepage])

      Given("I am on a the trainline website")
      Homepage.goToHomepage
      //      pageTitle must include regex("Trainline")
      Homepage.assertPageTitle

      When("I enter in the two stations and click submit")
//      click on "return"
      Homepage.CLICK_ON_RETURN
//      searchField("from.text").value = "Brighton"
      Homepage.setFromText("Brighton")
//      searchField("to.text").value = "London Bridge"
      Homepage.setToText("London Bridge")

      //      click on cssSelector("._rk5m7u ._6d98wc:nth-of-type(1) [aria-haspopup='false']:nth-of-type(2) span") // clicks on Tomorrow
//      Homepage.tomorrow.click()
      Homepage.CLICK_ON_TOMORROW

      //      click on Homepage.tomorrow // clicks on Tomorrow


      //      find(xpath(".//*[contains(text(),'morrow')]")).get.underlying.click()
      //      if (checkbox(css.oneWayBox).isSelected ==(true)) {
      //        checkbox(css.oneWayBox).clear()
      //      }
      //    if (checkbox("isOneWay").isSelected) {
      //      checkbox("isOneWay").clear()
      //    }
      //      if (checkbox("single").isSelected) {checkbox("return").click()}

      //      click on Homepage.nextDay // next day
      //      click on cssSelector("._rk5m7u ._6d98wc:nth-of-type(2) [aria-haspopup='false']:nth-of-type(2) span") // next day
//      Homepage.nextDay.click()
      Homepage.CLICK_ON_NEXTDAY

      And("I click Get times & tickets")
      //      click on cssSelector(css.closePopUp)
//      Homepage.popUp.click()
      Homepage.CLOSE_POPUP
      //      find(cssSelector(css.submit))
      //      click on cssSelector(css.submit)
//      Homepage.submit.click()
      Homepage.CLICK_ON_SUBMIT

      Then("The timetable page will be visible")
      //      find(xpath("//div[@class='_11jkqip']")) mustBe (defined)
      //      click on cssSelector(css.timetable)
      Thread.sleep(5000)
      //      find(cssSelector(css.timetable)) mustBe (defined)

      //      click on (xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4"))
      //      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex("Sep")
      //      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex("Sep")//      Homepage.outDateAssert.getText must include regex("Sep")

//      Homepage.outDateAssert.getText must include regex "Sep"
      Homepage.assertNextDayDateCorrect("Sep")

      //      find(xpath("sdsa")).get.text must include regex "dsfds"

      // Thread.sleep(7000)
//      close()
    }
    scenario("Exercise six"){
      implicitlyWait(Span(10, Seconds))

      Given("I am on a the trainline website")
      Homepage.goToHomepage

      Homepage.assertPageTitle

      When("I enter in the two stations and click submit")

      Homepage.CLICK_ON_RETURN

      Homepage.setFromText("Brighton")

      Homepage.setToText("London Bridge")

      Homepage.CLICK_ON_TOMORROW

      Homepage.CLICK_ON_NEXTDAY

      And("I enter adult amounts")
      Homepage.selectAmountofAdults()

      And("I click Get times & tickets")

      Homepage.CLOSE_POPUP

      Homepage.CLICK_ON_SUBMIT

      Then("The timetable page will be visible")

      Thread.sleep(5000)

//      println(TimetablePage.randomAmount)

      TimetablePage.assertAdultAmountCorrect()

      TimetablePage.assertNextDayDateCorrect("Sep")

    }

    scenario("Exercise seven"){
      implicitlyWait(Span(10, Seconds))

      Given("I am on a the trainline website")
      Homepage.goToHomepage

      Homepage.assertPageTitle

      When("I enter in the two stations and click submit")

      Homepage.CLICK_ON_RETURN

      Homepage.setFromText("Brighton")

      Homepage.setToText("London Bridge")

      // put date thing here
//      TimetablePage.daysToAdd = 60


      Homepage.selectDate(TimetablePage.daysToAdd)

//      Homepage.CLICK_ON_TOMORROW

      Homepage.CLICK_ON_NEXTDAY

      And("I enter adult amounts")
      Homepage.selectAmountofAdults()

      And("I click Get times & tickets")

      Homepage.CLOSE_POPUP

      Homepage.CLICK_ON_SUBMIT

      Then("The timetable page will be visible")

      Thread.sleep(5000)

      //      println(TimetablePage.randomAmount)
//      println(TimetablePage.getDaysFunction)
//      println(TimetablePage.getMonthFunction)
//      println(TimetablePage.getYearFunction)
//      println(TimetablePage.setDate)
//      TimetablePage.assertOutDayCorrect()
//      TimetablePage.assertOutMonthCorrect()
//      TimetablePage.assertOutYearCorrect()

      TimetablePage.assertFromDateCorrect

      TimetablePage.assertAdultAmountCorrect()

//      TimetablePage.assertNextDayDateCorrect("Sep")

    }
    scenario("Exercise seven (different strat for last one)"){
      implicitlyWait(Span(10, Seconds))

      Given("I am on a the trainline website")
      Homepage.goToHomepage

      Homepage.assertPageTitle

      When("I enter in the two stations and click submit")

      Homepage.CLICK_ON_RETURN

      Homepage.setFromText("Brighton")

      Homepage.setToText("London Bridge")

      Homepage.selectFromDate7

      Homepage.CLICK_ON_NEXTDAY

      And("I enter adult amounts")
      Homepage.selectAmountofAdults()

      And("I click Get times & tickets")

      Homepage.CLOSE_POPUP

      Homepage.CLICK_ON_SUBMIT

      Then("The timetable page will be visible")

      Thread.sleep(5000)

      TimetablePage.assertFromDateCorrect

      TimetablePage.assertAdultAmountCorrect()


    }

//      Thread.sleep(5000)
//      quit()
  }


}
