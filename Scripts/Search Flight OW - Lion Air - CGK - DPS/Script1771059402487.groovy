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

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/Home/Button Flight Menu'),2)

Mobile.verifyElementVisible(
	findTestObject('Object Repository/Application/tiket.com/Landing Page/Title label Pesawat'),
	5
)

TestObject hapusBtn = findTestObject(
	'Object Repository/Application/tiket.com/Landing Page/Button Hapus'
)

boolean isHapusExist = Mobile.verifyElementExist(
	hapusBtn,
	2,
	FailureHandling.OPTIONAL
)

if (isHapusExist) {

	println("Button Hapus ditemukan.")

	// 1️⃣ Tap Hapus
	Mobile.tap(hapusBtn, 2)

	// 2️⃣ Kembali ke Home
	Mobile.pressBack()
	Mobile.delay(1)

	// 3️⃣ Masuk lagi ke Flight Menu
	Mobile.tap(
		findTestObject('Object Repository/Application/tiket.com/Home/Button Flight Menu'),
		2
	)

	// 4️⃣ Verify halaman Pesawat muncul
	Mobile.verifyElementVisible(
		findTestObject('Object Repository/Application/tiket.com/Landing Page/Title label Pesawat'),
		5
	)

	// 5️⃣ Baru tap Search Departure
	Mobile.tap(
		findTestObject('Object Repository/Application/tiket.com/Landing Page/Button Search Departure'),
		2
	)

} else {

	println("Button Hapus tidak ada. Langsung ke Search Departure.")

	// Langsung tap Search Departure
	Mobile.tap(
		findTestObject('Object Repository/Application/tiket.com/Landing Page/Button Search Departure'),
		2
	)
}

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/Landing Page/Title Label Pilih Kota atau Bandara'),5)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/Landing Page/Departure by Popular Destination - Jakarta'),2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/Landing Page/Title label Pesawat'),5)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/Landing Page/Button Search Return'),2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/Landing Page/Title Label Mau ke Mana'),5)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/Landing Page/Return by Popular Destination - Bali'),2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/Landing Page/Title label Pesawat'),5)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/Landing Page/Button Search Departure Date'),2)

CustomKeywords.'mobile.DatePickerHelper.selectDatePlusMonths'(3)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/Landing Page/Button Simpan'),2)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/Landing Page/Button Search'),2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/SRP/Title Label Jakarta ke Denpasar-Bali'),5)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/SRP/Button Filter'),2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/SRP/Title Label Filter dan Urutkan'),5)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/SRP/Filter By Maskapai'),2)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/SRP/Button Tampilkan xx lainnya'),2)

CustomKeywords.'mobile.SmartScroll.scrollAndSelectMaskapai'("Lion Air")

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/SRP/Button Simpan'),2)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/SRP/Button Apply Filter'),2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/SRP/Title Label Jakarta ke Denpasar-Bali'),5)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/SRP/Select Top Airline'),2)

CustomKeywords.'mobile.SmartScroll.scrollAndTapButtonUnderSection'(
	"Tanpa upgrade",
	"Pilih"
)

Mobile.verifyElementVisible(findTestObject('Object Repository/Application/tiket.com/SRP/Title Label Jika penerbanganmu'),20)

Mobile.tap(findTestObject('Object Repository/Application/tiket.com/SRP/Button Nggak dulu deh'),2)

Mobile.closeApplication()

Mobile.closeApplication()