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

import groovy.time.BaseDuration.From
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.RedbusURL)
WebUI.maximizeWindow()

WebUI.enhancedClick(findTestObject('Object Repository/common/input_id', [ text : 'srcinput' ]))

WebUI.sendKeys(findTestObject('Object Repository/common/input_id', [ text : 'srcinput' ]), FromDst)
if(WebUI.verifyElementPresent(findTestObject('Object Repository/common/div_aria-label', [ text : FromDst]), 0, FailureHandling.OPTIONAL)) {
	WebUI.enhancedClick(findTestObject('Object Repository/common/div_aria-label', [ text : FromDst]))
}else {
	WebUI.closeBrowser()
	
}
WebUI.delay(1)
WebUI.enhancedClick(findTestObject('Object Repository/common/input_id', [ text : 'destinput' ]))
WebUI.sendKeys(findTestObject('Object Repository/common/input_id', [ text : 'destinput' ]), ToDst)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/common/div_aria-label', [ text : ToDst]), 0, FailureHandling.OPTIONAL)) {
	WebUI.enhancedClick(findTestObject('Object Repository/common/div_aria-label', [ text : ToDst]))
}else {
	WebUI.closeBrowser()
}
WebUI.delay(1)

WebUI.enhancedClick(findTestObject('Object Repository/BusPage/div_calender'))

CustomKeywords.'redBus.utility.ChooseDayFromCalender'(date)

WebUI.enhancedClick(findTestObject('Object Repository/common/button_text', [ text : 'Search buses']))
WebUI.delay(4)

CustomKeywords.'redBus.utility.busFoundResults'()



