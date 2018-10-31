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

import voabar.pages.Base

class BaseSteps extends Steps {

  Then("""^Message displayed is : "([^"]*)"$"""){ (area:String) =>
    Base.pageHeaderText() should include (area)
  }

  Then("""^"([^"]*)" should be displayed beside logout button$"""){ (area:String) =>
    Base.baLinkPresent(area)
  }

  Then("""^logout button should be displayed$"""){ () =>
    Base.isLinkTextPresent("Logout")
  }

  When("""^logout button is clicked$"""){ () =>
    Base.linkClicked("Logout")
  }

  Then("""^the error message should be "([^"]*)"$"""){ (msg:String) =>
    Base.pageSource should include (msg)
  }

  Then("""^the error message should "([^"]*)" appear next to "([^"]*)"$"""){ (msg:String, elementId:String) =>
    Base.idText(elementId) shouldBe msg
  }

  Then("""^"([^"]*)" message should be shown$"""){ (msg:String) =>
    Base.pageSource should include (msg)
  }

  Then("""^view previous submissions link is displayed$"""){ () =>
    Base.isLinkTextPresent("View your previous Council Tax submissions")
  }

  Then("""^I click on the previous submissions link$"""){ () =>
    Base.linkClicked("View your previous Council Tax submissions")
  }

  Then("""^Download receipt button is displayed$"""){ () =>
    System.out.println(Base.pageSource)
    Base.isLinkTextPresent("Download receipt")
  }
}
