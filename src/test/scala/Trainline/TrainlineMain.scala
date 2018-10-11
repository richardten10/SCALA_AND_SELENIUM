package Trainline

import Pages.{Homepage, TimetablePage}
import org.scalatest.time.{Seconds, Span}
import utils.BaseFeatureSpec

class TrainlineMain extends BaseFeatureSpec {



  feature("To test the trainline website") {
    scenario("Exercise One") {

      implicitlyWait(Span(10, Seconds))



      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"

      When("I enter in the two stations and click submit")
      searchField("from.text").value = "Brighton"
      searchField("to.text").value = "London Bridge "





      And("I click Get times & tickets")
      click on cssSelector(css.closePopUp)
      find(cssSelector(css.submit))
      click on cssSelector(css.submit)


      Then("The timetable page will be visible")




    }

    scenario("Exercise two"){

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



      find(cssSelector(css.timetable)) mustBe (defined)



    }

    scenario("Exercise three"){

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




      And("I click Get times & tickets")
      click on cssSelector(css.closePopUp)
      find(cssSelector(css.submit))
      click on cssSelector(css.submit)

      Then("The timetable page will be visible")


      Thread.sleep(5000)





      find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex("Sep")






    }

    scenario("Exercise four"){

      implicitlyWait(Span(10, Seconds))


      Given("I am on a the trainline website")
      go to "https://www.thetrainline.com"
      pageTitle must include regex("Trainline")

      When("I enter in the two stations and click submit")
      click on "return"
      searchField("from.text").value = "Brighton"
      searchField("to.text").value = "London Bridge"


      Homepage.tomorrow.click()
















      Homepage.nextDay.click()






      And("I click Get times & tickets")

      Homepage.popUp.click()


      Homepage.submit.click()

      Then("The timetable page will be visible")


      Thread.sleep(5000)






      Homepage.outDateAssert.getText must include regex "Sep"





    }

    scenario("Exercise four +++++++++"){

      implicitlyWait(Span(10, Seconds))


      Given("I am on a the trainline website")
      Homepage.goToHomepage

      Homepage.assertPageTitle

      When("I enter in the two stations and click submit")
      click on "return"
      searchField("from.text").value = "Brighton"
      searchField("to.text").value = "London Bridge"



      Homepage.tomorrow.click()















      Homepage.nextDay.click()






      And("I click Get times & tickets")

      Homepage.popUp.click()


      Homepage.submit.click()

      Then("The timetable page will be visible")


      Thread.sleep(5000)






      Homepage.outDateAssert.getText must include regex "Sep"





    }
    scenario("Exercise five"){

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

      And("I click Get times & tickets")


      Homepage.CLOSE_POPUP



      Homepage.CLICK_ON_SUBMIT

      Then("The timetable page will be visible")


      Thread.sleep(5000)







      Homepage.assertNextDayDateCorrect("Sep")





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





      Homepage.selectDate(TimetablePage.daysToAdd)



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



  }


}
