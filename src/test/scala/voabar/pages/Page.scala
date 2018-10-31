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

package voabar.pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatest.concurrent.{Eventually, PatienceConfiguration}
import org.scalatest.selenium.WebBrowser
import org.scalatest.{Assertions, Matchers}
import voabar.stepdefs.Steps
import voabar.utils.Configuration


trait Page extends org.scalatest.selenium.Page with PatienceConfiguration with WebBrowser with Eventually with Assertions with Matchers with Steps {

  override val url = ""
  val port = 8889
  val baseUrl = "/voa-bar-xml-frontend"

  lazy val envUrl : String = Configuration.settings.url

  def getUrl() = if (envUrl.startsWith("http://local")) s"$envUrl:$port$baseUrl" else envUrl + baseUrl

  def goToPage: Unit = go to url

  def isLinkTextPresent(linkText: String)(implicit driver: WebDriver): Unit = {
    driver.findElement(By.linkText(linkText)) shouldBe a[WebElement]
  }

  def baLinkPresent(area: String)(implicit driver: WebDriver): Unit = {
    driver.findElement(By.id("username-element")).getText shouldBe area
  }

  def linkClicked(linkText: String)(implicit driver: WebDriver): Unit = {
    driver.findElement(By.linkText(linkText)).click()
  }

  def idClicked(idText: String)(implicit driver: WebDriver): Unit = {
    driver.findElement(By.id(idText)).click()
  }

  def idPresent(idText: String)(implicit driver: WebDriver): Unit = {
    driver.findElement(By.id(idText))
  }

  def idText(idText: String)(implicit driver: WebDriver): String = {
    driver.findElement(By.id(idText)).getText
  }

  def expectedPageTitle: Option[String]
  def expectedPageHeader: Option[String]

  protected def pageHeader: Query = cssSelector("h1")

  def pageHeaderText() = {
    pageHeader.element.text
  }

  protected def pageHeaderShouldBeCorrect: Unit = {
    expectedPageHeader.foreach(pageHeaderText shouldBe _)
  }

  protected def pageTitleShouldBeCorrect: Unit = {
    Thread.sleep(1000L)
    expectedPageTitle.foreach(pageTitle shouldBe _)
  }

  def shouldBeLoaded: Unit = {
    pageTitleShouldBeCorrect
    pageHeaderShouldBeCorrect
  }
}