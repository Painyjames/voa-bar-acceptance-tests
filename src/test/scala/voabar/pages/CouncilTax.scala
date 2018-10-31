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

import org.openqa.selenium.WebDriver

object CouncilTax extends Page {

  override val expectedPageTitle = Some(s"Council Tax")

  override val expectedPageHeader = Some(s"Council Tax")

  def pageTitleShouldBe(implicit driver: WebDriver): Unit = {
    pageTitleShouldBeCorrect
  }

}