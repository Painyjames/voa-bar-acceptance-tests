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

import voabar.pages.Upload

class UploadSteps extends Steps {

  Then("""^Upload your council tax reports page is displayed$"""){ () =>
    Upload.shouldBeLoaded
  }

  Then("""^choose a file button is displayed$"""){ () =>
    Upload.idPresent("submit")
  }

  When("""^"([^"]*)" is uploaded$"""){ (filepath:String) =>
    Upload.setupChooseFile(filepath)
  }

  When("""^Submit is clicked$"""){ () =>
    Upload.idClicked("submit")
  }

}
