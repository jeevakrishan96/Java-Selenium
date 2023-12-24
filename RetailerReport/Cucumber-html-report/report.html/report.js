$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/org/featurefies/RetailerPages/Brands.feature");
formatter.feature({
  "name": "Validating Brands Menu functionality",
  "description": "         As a Retailer, I want to be able to view the list of brands, so that I would know what is available for me",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Brands"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user launch the browser and Maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Brands.user_launch_the_browser_and_Maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "to hit the Shopdot Url",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.to_hit_the_Shopdot_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login to the Shopdot Application",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_login_to_the_Shopdot_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the Brands menu",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_Brands_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Sending request to the Brand",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Brands"
    },
    {
      "name": "@BL001"
    }
  ]
});
formatter.step({
  "name": "the user is on the Brand Listing page",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_is_on_the_Brand_Listing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user select a Brands and click on the connect button",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_select_a_Brands_and_click_on_the_connect_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "displays the sucessful message \"Connect Request Sent Successfully!\"",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.displays_the_sucessful_message(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the close button in the popup",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_close_button_in_the_popup()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status changes to \"Pending\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Brands.status_changes_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user launch the browser and Maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Brands.user_launch_the_browser_and_Maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "to hit the Shopdot Url",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.to_hit_the_Shopdot_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login to the Shopdot Application",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_login_to_the_Shopdot_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the Brands menu",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_Brands_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Searching and Filtering Brands",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Brands"
    },
    {
      "name": "@BL002"
    }
  ]
});
formatter.step({
  "name": "the user is on the Brand Listing page",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_is_on_the_Brand_Listing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters keyword in the search bar",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_enters_keyword_in_the_search_bar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Application displays only those brands in the filter that match keyword",
  "keyword": "Then "
});
formatter.match({
  "location": "Brands.the_Application_displays_only_those_brands_in_the_filter_that_match_keyword()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user launch the browser and Maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Brands.user_launch_the_browser_and_Maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "to hit the Shopdot Url",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.to_hit_the_Shopdot_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login to the Shopdot Application",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_login_to_the_Shopdot_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the Brands menu",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_Brands_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "No Brands Matching Search Criteria",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Brands"
    },
    {
      "name": "@BL003"
    }
  ]
});
formatter.step({
  "name": "the user is on the Brand Listing page",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_is_on_the_Brand_Listing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters nonexistent_keyword in the search bar",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.the_user_enters_nonexistent_keyword_in_the_search_bar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the message \"There are no brands that meet your criteria.\"is displayed in the table",
  "keyword": "Then "
});
formatter.match({
  "location": "Brands.theMessageIsDisplayedInTheTable(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Application displays the result count as 0",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_Application_displays_the_result_count_as(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user launch the browser and Maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Brands.user_launch_the_browser_and_Maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "to hit the Shopdot Url",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.to_hit_the_Shopdot_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login to the Shopdot Application",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_login_to_the_Shopdot_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the Brands menu",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_Brands_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Filtering Brands by Status",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Brands"
    },
    {
      "name": "@BL004"
    }
  ]
});
formatter.step({
  "name": "the user is on the Brand Listing page",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_is_on_the_Brand_Listing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user selects \"Connected\" status in the filter section",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.theUserSelectsStatusInTheFilterSection(String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.InvalidSelectorException: invalid selector: Unable to locate an element with the xpath expression  because of the following error:\nSyntaxError: Failed to execute \u0027evaluate\u0027 on \u0027Document\u0027: The string \u0027\u0027 is not a valid XPath expression.\n  (Session info: chrome\u003d120.0.6099.110)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/invalid_selector_exception.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027JOSHVA_EMMANUEL\u0027, ip: \u0027192.168.1.9\u0027, os.name: \u0027Windows 11\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_372\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 120.0.6099.110, chrome: {chromedriverVersion: 119.0.6045.105 (38c72552c5e..., userDataDir: C:\\Users\\Emman\\AppData\\Loca...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:51542}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: 38b019761fe465780ea12affcc3a9e2b\n*** Element info: {Using\u003dxpath, value\u003d}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.retailerPageStep.Brands.theUserSelectsStatusInTheFilterSection(Brands.java:139)\r\n\tat ✽.the user selects \"Connected\" status in the filter section(file:src/test/java/org/featurefies/RetailerPages/Brands.feature:38)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the Application refreshes the list to display brands with \"Connected\" status",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user selects \"Pending\" status in the filter section",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.theUserSelectsStatusInTheFilterSection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the Application refreshes the list to display brands with \"Pending\" status",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user selects \"Not connected\" status in the filter section",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.theUserSelectsStatusInTheFilterSection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the Application refreshes the list to display brands with \"Not connected\" status",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user selects \"Declined\" status in the filter section",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.theUserSelectsStatusInTheFilterSection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the Application refreshes the list to display brands with \"Declined\" status",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application displays the result count",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user launch the browser and Maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Brands.user_launch_the_browser_and_Maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "to hit the Shopdot Url",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.to_hit_the_Shopdot_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login to the Shopdot Application",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_login_to_the_Shopdot_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the Brands menu",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_Brands_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Filtering Brands by Brand Category",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Brands"
    },
    {
      "name": "@BL005"
    }
  ]
});
formatter.step({
  "name": "the user is on the Brand Listing page",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_is_on_the_Brand_Listing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user selects a brand category on the top navigation bar",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application refreshes the list to display brands matching the selected brand category",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application displays the result count",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user launch the browser and Maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Brands.user_launch_the_browser_and_Maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "to hit the Shopdot Url",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.to_hit_the_Shopdot_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login to the Shopdot Application",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_login_to_the_Shopdot_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the Brands menu",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_Brands_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Filtering Brands by Brand Values",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Brands"
    },
    {
      "name": "@BL006"
    }
  ]
});
formatter.step({
  "name": "the user is on the Brand Listing page",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_is_on_the_Brand_Listing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user selects brand values in the filter section",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application refreshes the list to display brands that match the selected filters",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application displays the result count",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user launch the browser and Maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Brands.user_launch_the_browser_and_Maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "to hit the Shopdot Url",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.to_hit_the_Shopdot_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login to the Shopdot Application",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_login_to_the_Shopdot_Application()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d120.0.6099.110)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027JOSHVA_EMMANUEL\u0027, ip: \u0027192.168.1.9\u0027, os.name: \u0027Windows 11\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_372\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 120.0.6099.110, chrome: {chromedriverVersion: 119.0.6045.105 (38c72552c5e..., userDataDir: C:\\Users\\Emman\\AppData\\Loca...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:51734}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: b5b3c150eae00c27d35b0e210a406fb0\n*** Element info: {Using\u003dxpath, value\u003d//input[@placeholder\u003d\u0027Email address\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.retailerPageStep.Brands.user_login_to_the_Shopdot_Application(Brands.java:46)\r\n\tat ✽.user login to the Shopdot Application(file:src/test/java/org/featurefies/RetailerPages/Brands.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "click on the Brands menu",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_Brands_menu()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Filtering Brands by State",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Brands"
    },
    {
      "name": "@BL007"
    }
  ]
});
formatter.step({
  "name": "the user is on the Brand Listing page",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_is_on_the_Brand_Listing_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the user selects a State in the filter section",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application refreshes the list to display brands that match the selected State",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application displays the result count",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user launch the browser and Maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Brands.user_launch_the_browser_and_Maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "to hit the Shopdot Url",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.to_hit_the_Shopdot_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login to the Shopdot Application",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_login_to_the_Shopdot_Application()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d120.0.6099.110)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027JOSHVA_EMMANUEL\u0027, ip: \u0027192.168.1.9\u0027, os.name: \u0027Windows 11\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_372\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 120.0.6099.110, chrome: {chromedriverVersion: 119.0.6045.105 (38c72552c5e..., userDataDir: C:\\Users\\Emman\\AppData\\Loca...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:51759}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: 3bf5990ce1e8de4a4acd8071f636218a\n*** Element info: {Using\u003dxpath, value\u003d//input[@placeholder\u003d\u0027Email address\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.retailerPageStep.Brands.user_login_to_the_Shopdot_Application(Brands.java:46)\r\n\tat ✽.user login to the Shopdot Application(file:src/test/java/org/featurefies/RetailerPages/Brands.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "click on the Brands menu",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_Brands_menu()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Filtering Brands by Retail Pricing",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Brands"
    },
    {
      "name": "@BL008"
    }
  ]
});
formatter.step({
  "name": "the user is on the Brand Listing page",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_is_on_the_Brand_Listing_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the user selects one or more options from Retail Pricing",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application refreshes the list to display brands that match the selected filter",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application displays the result count",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user launch the browser and Maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Brands.user_launch_the_browser_and_Maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "to hit the Shopdot Url",
  "keyword": "When "
});
formatter.match({
  "location": "Brands.to_hit_the_Shopdot_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login to the Shopdot Application",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.user_login_to_the_Shopdot_Application()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d120.0.6099.110)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027JOSHVA_EMMANUEL\u0027, ip: \u0027192.168.1.9\u0027, os.name: \u0027Windows 11\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_372\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 120.0.6099.110, chrome: {chromedriverVersion: 119.0.6045.105 (38c72552c5e..., userDataDir: C:\\Users\\Emman\\AppData\\Loca...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:51781}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: fcfd4a9e92a11144c62149fcf10e8581\n*** Element info: {Using\u003dxpath, value\u003d//input[@placeholder\u003d\u0027Email address\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.retailerPageStep.Brands.user_login_to_the_Shopdot_Application(Brands.java:46)\r\n\tat ✽.user login to the Shopdot Application(file:src/test/java/org/featurefies/RetailerPages/Brands.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "click on the Brands menu",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.click_on_the_Brands_menu()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "No Matches for Selected Filter",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Brands"
    },
    {
      "name": "@BL009"
    }
  ]
});
formatter.step({
  "name": "the user is on the Brand Listing page",
  "keyword": "And "
});
formatter.match({
  "location": "Brands.the_user_is_on_the_Brand_Listing_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the user selects a filter",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application verifies that there are no matches for the selected filter",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the Application displays the message: \"There are no brands that match your search\" on the table",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});