/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package voabar.stepdefs

import java.util.concurrent.TimeUnit

import com.gargoylesoftware.htmlunit.BrowserVersion
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.Matchers

trait Steps extends ScalaDsl with EN with Matchers {

  import Steps._

  implicit def getDriverUnsafe: WebDriver = _driver.getOrElse(sys.error("Driver does not exist"))

  // create a new driver for each scenario
  Before { _ ⇒
    val browser = System.getProperty("browser")

    if (_driver.isEmpty) {
      _driver = browser match {
        case "chrome" =>
          val driver = new ChromeDriver
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
          Some(driver)
        case "firefox" =>
          val driver = new FirefoxDriver
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
          Some(driver)
        case "headless" =>
          val driver = new HtmlUnitDriver(BrowserVersion.CHROME)
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
          Some(driver)
        case _ => None
      }
    }
  }

  After { _ ⇒
    _driver.foreach(_.quit())
    _driver = None
  }
}

object Steps {

  /**
    * Each step definition file extends the `Steps` trait , but they will all reference this single driver
    * in the companion object. Having this variable in the trait would cause multiple drivers to be
    * created
    */
  private var _driver: Option[WebDriver] = None

}