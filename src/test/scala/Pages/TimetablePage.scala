package Pages

import Pages.Homepage.{cssSelector, find, pageTitle, searchField}
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.{WebDriver, WebElement}
import utils.BaseFeatureSpec
import java.time.format.{DateTimeFormatter, DateTimeParseException}
import java.time.{LocalDate, ZoneId, ZonedDateTime}
import Trainline.TrainlineMain

object TimetablePage extends BaseFeatureSpec {

  val randomAmount = Homepage.storeRandom +2

  def findOutDateAssert(): Option[TimetablePage.Element] = {
    return find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4"))
  }
  def assertNextDayDateCorrect(text: String)(): Unit = {
    //    outDateAssert.getText must include regex text
    findOutDateAssert().get.text must include regex text
    //        find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/header/div/h4")).get.text must include regex text
  }

  def assertAdultAmountCorrect(): Unit = {
    find(xpath("//*[@id=\"app\"]/div/div[1]/header/div[1]/div[3]/div/ul/li[3]/span/span/span")).get.text must include regex randomAmount.toString
  }

  private val getDays = DateTimeFormatter.ofPattern("dd")
  private val getMonth = DateTimeFormatter.ofPattern("MM")
  private val getYear = DateTimeFormatter.ofPattern("yyyy")
//  var daysToAdd: Long = 10
//  var dateNow = LocalDate.now().plusDays(daysToAdd)
  var days = setDate().format(getDays)
  var month = setDate().format(getMonth)
  var year = setDate().format(getYear)
  val daysToAdd = 60

  def setDate(): LocalDate ={
    var date = LocalDate.now()
    date = LocalDate.now().plusDays(daysToAdd)
    return date
  }


  def getDaysFunction: String = {
    var dayToCheck = ""
    setDate().format(getDays) match {
      case "01" => dayToCheck = "1"
      case "02" => dayToCheck = "2"
      case "03" => dayToCheck = "3"
      case "04" => dayToCheck = "4"
      case "05" => dayToCheck = "5"
      case "06" => dayToCheck = "6"
      case "07" => dayToCheck = "7"
      case "08" => dayToCheck = "8"
      case "09" => dayToCheck = "9"
      case _ => dayToCheck = setDate().format(getDays)
    }
    return dayToCheck
  }
  def getMonthFunction: String = {
    var monthToCheck = ""
    setDate().format(getMonth) match {
      case "01" => monthToCheck = "1"
      case "02" => monthToCheck= "2"
      case "03" => monthToCheck= "3"
      case "04" => monthToCheck= "4"
      case "05" => monthToCheck= "5"
      case "06" => monthToCheck= "6"
      case "07" => monthToCheck = "7"
      case "08" => monthToCheck = "8"
      case "09" => monthToCheck = "Sep"
      case "10" => monthToCheck = "Oct"
      case "11" => monthToCheck = "Nov"
      case "12" => monthToCheck = "Dec"

    }
    return monthToCheck
  }

  def getYearFunction:String = {
    return setDate().format(getYear)
  }

  def assertOutDayCorrect(): Unit = {
    find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[2]/div/div/header/div/h4")).get.text must include regex getDaysFunction

  }

  def assertOutMonthCorrect(): Unit = {
    find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[2]/div/div/header/div/h4")).get.text must include regex getMonthFunction

  }

  def assertOutYearCorrect(): Unit = {
    find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[2]/div/div/header/div/h4")).get.text must include regex getYearFunction

  }

  def assertFromDateCorrect: Unit = {
    find(xpath("//*[@id=\"app\"]/div/div[1]/main/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[2]/div/div/header/div/h4")).get.text must include regex s"$getDaysFunction $getMonthFunction $getYearFunction"
  }

}
