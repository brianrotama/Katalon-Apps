package mobile

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.AppiumBy
import org.openqa.selenium.NoSuchElementException

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class DatePickerHelper {

    @Keyword
    def selectDatePlusMonths(int plusMonths) {

        LocalDate today = LocalDate.now()
        LocalDate targetDate = today.plusMonths(plusMonths)

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("id", "ID"))

        String targetMonthYear = targetDate.format(formatter)
        String targetDay = targetDate.getDayOfMonth().toString()

        println("===== SMART UIScroll Engine FINAL =====")
        println("Target: ${targetDay} ${targetMonthYear}")

        AppiumDriver driver = MobileDriverFactory.getDriver()

        // STEP 1: Scroll ke header bulan
        String scrollToMonth =
                "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().textContains(\"${targetMonthYear}\"))"

        driver.findElement(AppiumBy.androidUIAutomator(scrollToMonth))

        Mobile.delay(1)

        // STEP 2: Micro scroll supaya grid kebuka penuh
        String microScroll =
                "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollForward()"

        driver.findElement(AppiumBy.androidUIAutomator(microScroll))
        Mobile.delay(1)

        // STEP 3: Prepare locator tanggal
        String tapDay =
                "new UiSelector().text(\"${targetDay}\")"

        // STEP 4: Safety check visibility
        try {
            def dayElement = driver.findElement(AppiumBy.androidUIAutomator(tapDay))

            if (!dayElement.isDisplayed()) {
                println("Tanggal belum fully visible, micro scroll lagi...")
                driver.findElement(AppiumBy.androidUIAutomator(microScroll))
                Mobile.delay(1)
                dayElement = driver.findElement(AppiumBy.androidUIAutomator(tapDay))
            }

            dayElement.click()
            println("Tanggal berhasil dipilih.")

        } catch (NoSuchElementException e) {
            throw new Exception("Tanggal ${targetDay} di ${targetMonthYear} tidak ditemukan.")
        }

        println("===== END ENGINE =====")
    }
}