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

import voabar.pages.Confirmation

class ConfirmationSteps extends Steps {

  Then("""^Confirmation page should be shown with "([^"]*)"$"""){ (submissionMsg:String) =>
    timeDelay(submissionMsg) contains submissionMsg
  }

  Then("""^Upload more Council Tax reports link is displayed$""") { () =>
    Confirmation.isLinkTextPresent("Upload more Council Tax reports")
  }

  private def timeDelay(headerMsg: String): String = {
    System.out.println("Pausing to allow file to be processed: 10 secs")
//    while(25.seconds.fromNow.hasTimeLeft) {
      Thread.sleep(10000L)
//
//      if (Confirmation.pageHeaderText() contains headerMsg) {
//        return Confirmation.pageHeaderText()
//      }
//    }
    Confirmation.pageHeaderText()
  }
}
