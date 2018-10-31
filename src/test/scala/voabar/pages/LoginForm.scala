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

import org.openqa.selenium.{By, WebDriver}

object LoginForm extends Page {

  override val url: String = getUrl() + "/login"

  override val expectedPageTitle = Some(s"Please login")

  override val expectedPageHeader = Some(s"Billing Authority Reports\nPlease login")

  def completeUsername(userName: String)(implicit driver: WebDriver): Unit = {
    val userElement = driver.findElement(By.id("username"))
    userElement.clear()
    userElement.sendKeys(userName)
  }

  def completePassword(password: String)(implicit driver: WebDriver): Unit = {
    val userElement = driver.findElement(By.id("password"))
    userElement.clear()
    userElement.sendKeys(password)
  }

  def submitLogin(implicit driver: WebDriver): Unit = {
    driver.findElement(By.id("submit")).click()
  }

}