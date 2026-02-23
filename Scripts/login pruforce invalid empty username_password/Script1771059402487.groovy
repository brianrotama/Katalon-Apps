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

Mobile.startExistingApplication('id.co.prudential.pruforce.uat')

Mobile.verifyElementVisible(findTestObject('Object Repository/click_login'),10)

Mobile.tap(findTestObject('Object Repository/click_login'), 2)

//Mobile.setText(findTestObject('Object Repository/inputUsername'), 'agen00841117', 0)
//
//Mobile.setText(findTestObject('Object Repository/inputPassword'), 'Password10', 0)


Mobile.verifyElementExist(findTestObject('Object Repository/click_login_2'), 0)

Mobile.tap(findTestObject('Object Repository/click_login_2'), 2)

//Mobile.verifyElementVisible(findTestObject('Object Repository/Click_OK_Popup_Error_Invalid_username_password'),10)
//
//Mobile.tap(findTestObject('Object Repository/Click_OK_Popup_Error_Invalid_username_password'), 2)

//Mobile.verifyElementVisible(findTestObject('Object Repository/inputUsername'), 50, FailureHandling.STOP_ON_FAILURE)
//
//Mobile.tap(findTestObject('Object Repository/Application/App/Activity/Custom Dialog/subur  - Login'), 2)

//Mobile.closeApplication()

