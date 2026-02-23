import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling as FailureHandling

Mobile.startExistingApplication('com.tiket.gits')

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/Home/Button Home'),10)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/Home/Button Lihat semua'),2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/Home/Title Label Semua Produk'),10)

//CustomKeywords.'mobile.SmartScroll.scrollAndTapByText'("To Do") // -> default scroll

CustomKeywords.'mobile.SmartScroll.scrollAndTapByText'("Proteksi Visa") // -> default scroll

//CustomKeywords.'mobile.SmartScroll.scrollAndTapByText'("Gift Card") // -> default scroll

// CustomKeywords.'mobile.SmartScroll.scrollAndTapByText'("Promo", "left") -> scroll left

// CustomKeywords.'mobile.SmartScroll.scrollAndTapByText'("Promo", "down") -> scroll down

//Mobile.swipe(500, 1500, 500, 300)

//Mobile.scrollToElement(findTestObject('Object Repository/Application/tiket.com/Home/Button Proteksi Visa'), 10)

//Mobile.tap(findTestObject('Object Repository/Application/tiket.com/Home/Button Proteksi Visa'), 2)