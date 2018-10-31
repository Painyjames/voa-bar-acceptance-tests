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

import voabar.pages.ReportStatus
import voabar.utils.ErrorMessages

class ReportStatusSteps extends Steps {

  Then("""^Report status page is displayed$"""){ () =>
    ReportStatus.pageTitleShouldBe
  }

  Then("""^Failed submissions link is displayed$"""){ () =>
    ReportStatus.isLinkTextPresent("Failed Submissions")
  }

  Then("""^Completed submissions link is displayed$"""){ () =>
    ReportStatus.isLinkTextPresent("Completed Submissions")
  }

  When("""^The first submission report status is "([^"]*)"$"""){ (status:String) =>
    Thread.sleep(1000L)
    ReportStatus.errorStatusText contains status
  }

  When("""^The first submission report error heading is displayed "([^"]*)"$"""){ (errorCode:String) =>
    ReportStatus.reportErrorText contains ErrorMessages.errors(errorCode)
  }

  When("""^The first submission report error message is displayed "([^"]*)"$"""){ (errorMsg:String) =>
    ReportStatus.reportErrorText contains errorMsg
  }

  Then("""^The first submission report download receipt button is displayed$"""){ () =>
    ReportStatus.reportDownloadReceiptPresent
  }
}
