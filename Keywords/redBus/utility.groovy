package redBus

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
<<<<<<< HEAD
import static org.assertj.core.api.InstanceOfAssertFactories.INTEGER
=======
import static org.assertj.core.api.Assertions.assertThatException
import static org.assertj.core.api.InstanceOfAssertFactories.BYTE
import static org.assertj.core.api.InstanceOfAssertFactories.DOUBLE
>>>>>>> branch 'master' of https://github.com/abhilash-art002/KatalonProjectRedBus.git
import static org.assertj.core.api.InstanceOfAssertFactories.STRING

<<<<<<< HEAD
=======
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
>>>>>>> branch 'master' of https://github.com/abhilash-art002/KatalonProjectRedBus.git
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement

import internal.GlobalVariable

public class utility {

	//	@Keyword
	//	def ChooseDayFromCalender(String Date) {
	//		String[] dateParts = Date.split("-")
	//
	//		String day = dateParts[0]
	//		String month = dateParts[1]
	//		String year = dateParts[2]
	//
	//		String uiText = WebUI.getText(findTestObject('Object Repository/BusPage/p_monthYear'))
	//		String expectedText = month + " " + year
	//
	//		while (!uiText.equals(expectedText)) {
	//			WebUI.enhancedClick('Object Repository/BusPage/i_nextMonthArrow')
	//			WebUI.delay(1)
	//			WebUI.enhancedClick(findTestObject('Object Repository/BusPage/span_date',[text : day]))
	//		}
	//	}

	@Keyword
	def ChooseDayFromCalender(String Date) {
		String[] dateParts = Date.split("-")
		String day = dateParts[0]
		String month = dateParts[1]
		String year = dateParts[2]

		String expectedText = month + " " + year
		println("Looking for: " + expectedText)

		while (true) {
			String uiText = WebUI.getText(findTestObject('Object Repository/BusPage/p_monthYear'))
			println("Currently showing: " + uiText)

			if (uiText.equals(expectedText)) {
				println("Found the right month!")
				break
			}

			WebUI.enhancedClick(findTestObject('Object Repository/BusPage/i_nextMonthArrow'))

			WebUI.delay(1)
		}

		println("Now clicking the day: " + day)
		WebUI.enhancedClick(findTestObject('Object Repository/BusPage/span_date', [('text') : day]))
	}

<<<<<<< HEAD
	@Keyword
	def busFoundResults() {
		String noOfBus = WebUI.getText(findTestObject('Object Repository/searchResult/div_busesFoundText'))

		println(noOfBus)

		List<WebElement> busCount = WebUI.findWebElements(findTestObject('Object Repository/searchResult/li_tabs'), 5)
		int countToPrint = Math.min(busCount.size(), 10)
		println("Total buses found: " + busCount.size() + ". Printing details for the first " + countToPrint)

		for (int i = 1; i < countToPrint; i++) {
			WebUI.scrollToElement(findTestObject('Object Repository/searchResult/li_busnames',[i : i]), 5)

			Map param = [('i') : i.toString()]

			String busName = WebUI.getText(findTestObject('Object Repository/searchResult/li_busnames',[i : Integer.toString(i)]))
			String busType = WebUI.getText(findTestObject('Object Repository/searchResult/p_busType',[i : Integer.toString(i)]))
			String busRatings = WebUI.getText(findTestObject('Object Repository/searchResult/div_rating',[i : Integer.toString(i)]))
			String busBoardingTime = WebUI.getText(findTestObject('Object Repository/searchResult/p_busboardingTime',[i : Integer.toString(i)]))
			String busDroppingTime = WebUI.getText(findTestObject('Object Repository/searchResult/p_busdroppingTime',[i : Integer.toString(i)]))
			String busDuration = WebUI.getText(findTestObject('Object Repository/searchResult/p_busDuration',[i : Integer.toString(i)]))
			String busTotalSeat = WebUI.getText(findTestObject('Object Repository/searchResult/p_busTotalSeat',[i : Integer.toString(i)]))





			println("Bus #${i}")
			println("Name:      " + busName)
			println("BusType: " + busType)
			println("BusRatings:   " + busRatings)
			println("BusBoardingTime: " + busBoardingTime)

			println("BusDroppingTime: " + busDroppingTime)
			println("BusDuration:   " + busDuration)
			println("BusTotalSeat: " + busTotalSeat)

			if(WebUI.waitForElementVisible(findTestObject('Object Repository/searchResult/p_busfinalPrice',[i : Integer.toString(i)]), 5)) {
				String busFinalPrice = WebUI.getText(findTestObject('Object Repository/searchResult/p_busfinalPrice',[i : Integer.toString(i)]))
				println("BusPrice     " + busFinalPrice)
			}else if(WebUI.waitForElementVisible(findTestObject('Object Repository/searchResult/p_buscurrentPrice',[i : Integer.toString(i)]), 5)) {
				String busCurrentPrice = WebUI.getText(findTestObject('Object Repository/searchResult/p_buscurrentPrice',[i : Integer.toString(i)]))
				String busEndPrice = WebUI.getText(findTestObject('Object Repository/searchResult/p_busEndPrice',[i : Integer.toString(i)]))
				println("BusPrice_Range:      " + busCurrentPrice + " - " + busEndPrice)
			}else {
				println("no price tag")
			}

			TestObject btnViewSeats = findTestObject('Object Repository/searchResult/button_busSeats', [i : Integer.toString(i)])

			WebUI.scrollToElement(btnViewSeats, 5)
			WebUI.executeJavaScript("window.scrollBy(0,-150)", null)
			WebUI.delay(1)

			int retryCount = 0
			boolean opened = false

			while (retryCount < 3 && !opened) {
				println("Attempting to open seats for Bus #${i} (Attempt ${retryCount + 1})")

				WebElement element = WebUiCommonHelper.findWebElement(btnViewSeats, 5)
				WebUI.executeJavaScript("arguments[0].focus();", Arrays.asList(element))

				WebUI.sendKeys(btnViewSeats, Keys.chord(Keys.ENTER))

				opened = WebUI.waitForElementPresent(findTestObject('Object Repository/searchResult/div_SeatContainer'), 3, FailureHandling.OPTIONAL)

				if (!opened) {
					WebUI.click(btnViewSeats, FailureHandling.OPTIONAL)
					opened = WebUI.waitForElementPresent(findTestObject('Object Repository/searchResult/div_SeatContainer'), 3, FailureHandling.OPTIONAL)
				}

				retryCount++
			}

			if (opened) {
				println("SUCCESS: Seat map opened for Bus #${i}")
				WebUI.delay(2)
				WebUI.takeScreenshot()

				TestObject closeBtn = findTestObject('Object Repository/searchResult/button_close')
				WebUI.waitForElementClickable(closeBtn, 5)
				WebUI.click(closeBtn)
				WebUI.delay(1)
			} else {
				println("FAILED: Could not open seats for Bus #${i} after 3 attempts.")
=======

	@Keyword
	def applyFilters() {
		def filterData = findTestData("Data Files/BusFilters")
		int i ;
		List FilterName = []

		int rowSize = filterData.getRowNumbers()

		for (i=1; i<=rowSize; i ++) {
			FilterName.add(filterData.getValue(1, i))
		}

		WebUI.takeScreenshot()

		for(String name : FilterName) {
			println("Filters are "+ name)

			WebUI.click(findTestObject("Object Repository/BusPage/div_filterName",['filterName' : name]))
			WebUI.takeScreenshot()
		}
		WebUI.takeScreenshot()
	}


	@Keyword
	def captureResults() {
		WebUI.takeScreenshot()
		boolean found = false
		int maxScrollCount = 1
//		int maxAttempts = 20
		while(!found ) {

			if(WebUI.verifyElementVisible(findTestObject("Object Repository/BusPage/text_endResults"), FailureHandling.OPTIONAL)) {
				found = true
				println("End of results found!")
				break
			}

			WebUI.scrollToPosition(0, (500 * maxScrollCount))
			WebUI.delay(2)
			WebUI.takeScreenshot()

			maxScrollCount++
		}

		List<WebElement> results = WebUI.findWebElements(findTestObject('Object Repository/BusPage/busResults'), 10)
		println("Total elements found: " + results.size())
		
		
		for (WebElement ele: results) {
			try {
				WebElement rat = ele.findElement(By.xpath(".//div[contains(@class,'chip--') and contains(@aria-label,'star rating')]/div[contains(@class, 'rating')]"))
				WebElement price = ele.findElement(By.xpath(".//p[contains(@class,'finalFare')] | .//div[contains(@class,'startPrice')]//p[contains(@class,'currentPrice')]"))
				WebElement btn = ele.findElement(By.xpath(".//button[contains(@aria-label,'View seats')]"))
				
				String ratingText = rat.getText()
				String priceText = price.getText()
				priceText = priceText.replaceAll("[^0-9]", "")
				WebUI.takeScreenshot()
				
				double ratingNum = Double.parseDouble(ratingText)
				double priceNum = Double.parseDouble(priceText)
				
				
				if(ratingNum >= 4 && priceNum <= 1000) {
					btn.click()
					WebUI.takeScreenshot()
				}
				
				println("Ratings are: "+ ratingText + " " + priceNum)
				
			}catch(Exception e) {
				println(e.getMessage())
>>>>>>> branch 'master' of https://github.com/abhilash-art002/KatalonProjectRedBus.git
			}
		}
	}
}
