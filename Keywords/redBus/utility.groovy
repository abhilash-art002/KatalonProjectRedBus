package redBus

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.assertj.core.api.InstanceOfAssertFactories.STRING

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
}
