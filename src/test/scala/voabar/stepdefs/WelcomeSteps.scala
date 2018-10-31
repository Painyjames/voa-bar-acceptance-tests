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

import voabar.pages.Welcome

class WelcomeSteps extends Steps {

  Then("""^Welcome page is displayed$"""){ () =>
    Welcome.pageTitleShouldBe
  }

  Then("""^Council Tax link should be shown$"""){ () =>
    Welcome.isLinkTextPresent("Council Tax")
  }

  When("""^I click on Council Tax link$"""){ () =>
    Welcome.linkClicked("Council Tax")
  }
}
