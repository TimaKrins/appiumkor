package main

import constructor_classes.locatorTypes
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.testng.AssertJUnit
import utils.PlatformTouchAction
import java.time.Duration


open class TestMethods: BaseClass() {

    //Клик по элементу (к примеру кнопку)
    fun clickToElement(locatorType: String, locator: String){

        lateinit var element: MobileElement
        when (locatorType) {
            locatorTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.click() // Происходит тап по указанным в условии выше эелементам
        }

    // Ввод данных в поле
    fun inputTextInField(locatorType: String, locator: String, inputText:String){
        lateinit var element: MobileElement
        when (locatorType) {
            locatorTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.sendKeys(inputText) // Вводим указанный текст в поле по указанным выше в условии элементам
    }
    //Проверка элемента на доступность
    fun checkAvailableElement(locatorType: String, locator: String){
        var checkAvailableElement = false
        when (locatorType){
          locatorTypes.id -> checkAvailableElement = driver.findElement(MobileBy.id(locator)).isEnabled
          locatorTypes.xpath -> checkAvailableElement = driver.findElement(MobileBy.xpath(locator)).isEnabled
        }
        AssertJUnit.assertTrue(checkAvailableElement)
    }


    //Свайп по экрану
    fun swipeOnScreen(
        startCordX: Int,
        startCordY: Int,
        moveCordX: Int,
        moveCordY: Int,
    ) {
        PlatformTouchAction(driver)
            .longPress(PointOption.point(startCordX, startCordY))
            .moveTo(PointOption.point(moveCordX, moveCordY))
            .release()
            .perform()
    }
    // Тап по координатам на экране
    fun tapByCoordinates(
        cordX: Int,
        cordY: Int,
    ) {
        PlatformTouchAction(driver)
            .tap(PointOption.point(cordX, cordY))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
            .perform()
    }
}
