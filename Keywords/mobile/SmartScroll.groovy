package mobile

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling
import org.openqa.selenium.Dimension
import io.appium.java_client.AppiumDriver

class SmartScroll {

	/*
	 * Scroll & Tap by Text (Generic)
	 */
	@Keyword
	def scrollAndTapByText(String text, String direction = "up", int maxSwipe = 7, int timeout = 5) {

		TestObject dynamicObject = buildDynamicObjectByText(text)

		boolean found = scrollUntilElementVisible(dynamicObject, maxSwipe, direction)

		if (found) {
			Mobile.waitForElementPresent(dynamicObject, timeout)
			Mobile.tap(dynamicObject, timeout)
			return true
		}

		Mobile.takeScreenshot()
		throw new Exception("FAIL: Element '${text}' tidak ditemukan.")
	}

	/*
	 * Scroll & Tap Button Under Section
	 */
	@Keyword
	def scrollAndTapButtonUnderSection(String sectionText,
									   String buttonText,
									   String direction = "up",
									   int maxSwipe = 7,
									   int timeout = 5) {

		TestObject dynamicObject = new TestObject()
		dynamicObject.addProperty("xpath", ConditionType.EQUALS,
			"//*[contains(@text,'${sectionText}')]" +
			"/ancestor::*[@clickable='true' or @enabled='true'][1]" +
			"//*[contains(@text,'${buttonText}')]")

		boolean found = scrollUntilElementVisible(dynamicObject, maxSwipe, direction)

		if (found) {
			Mobile.waitForElementPresent(dynamicObject, timeout)
			Mobile.tap(dynamicObject, timeout)
			return true
		}

		Mobile.takeScreenshot()
		throw new Exception("Button '${buttonText}' di section '${sectionText}' tidak ditemukan.")
	}

	/*
	 * 🆕 Scroll & Select Maskapai
	 */
	@Keyword
	def scrollAndSelectMaskapai(String airlineName,
								String direction = "up",
								int maxSwipe = 7,
								int timeout = 5) {

		TestObject dynamicObject = new TestObject()
		dynamicObject.addProperty("xpath", ConditionType.EQUALS,
			"//*[contains(@text,'${airlineName}')]" +
			"/ancestor::*[@resource-id='com.tiket.gits:id/tds_list_parent']")

		boolean found = scrollUntilElementVisible(dynamicObject, maxSwipe, direction)

		if (found) {
			Mobile.waitForElementPresent(dynamicObject, timeout)
			Mobile.tap(dynamicObject, timeout)
			return true
		}

		Mobile.takeScreenshot()
		throw new Exception("Maskapai '${airlineName}' tidak ditemukan.")
	}

	/*
	 * Core Swipe Engine
	 */
	private boolean scrollUntilElementVisible(TestObject to, int maxSwipe, String direction) {

		AppiumDriver driver = MobileDriverFactory.getDriver()
		Dimension size = driver.manage().window().getSize()

		int startX, startY, endX, endY

		switch(direction.toLowerCase()) {

			case "up":
				startX = size.width / 2
				startY = (int)(size.height * 0.8)
				endX   = startX
				endY   = (int)(size.height * 0.3)
				break

			case "down":
				startX = size.width / 2
				startY = (int)(size.height * 0.3)
				endX   = startX
				endY   = (int)(size.height * 0.8)
				break

			case "left":
				startX = (int)(size.width * 0.8)
				startY = size.height / 2
				endX   = (int)(size.width * 0.2)
				endY   = startY
				break

			case "right":
				startX = (int)(size.width * 0.2)
				startY = size.height / 2
				endX   = (int)(size.width * 0.8)
				endY   = startY
				break

			default:
				throw new Exception("Direction tidak valid: " + direction)
		}

		String previousPageSource = ""

		for (int i = 0; i < maxSwipe; i++) {

			if (Mobile.verifyElementExist(to, 2, FailureHandling.OPTIONAL)) {
				return true
			}

			String currentPageSource = driver.getPageSource()

			if (currentPageSource.equals(previousPageSource)) {
				break
			}

			previousPageSource = currentPageSource

			Mobile.swipe(startX, startY, endX, endY)
			Mobile.delay(1)
		}

		return false
	}

	/*
	 * Dynamic Object Builder (Generic Tap)
	 */
	private TestObject buildDynamicObjectByText(String text) {

		TestObject to = new TestObject()
		to.addProperty("xpath", ConditionType.EQUALS,
			"//*[contains(@text,'${text}')]/ancestor::*[@clickable='true']")

		return to
	}
}