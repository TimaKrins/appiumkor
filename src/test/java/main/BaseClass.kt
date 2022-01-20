package main

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.util.concurrent.TimeUnit
import javax.print.DocFlavor

class BaseClass {
    lateinit var driver: AppiumDriver<MobileElement>
    @BeforeSuite
    fun setupDriver(){
        val url = URL("http://127.0.0.1:4723/wd/hub")
        val caps = DesiredCapabilities()



        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android")
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0")
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus5X")
        caps.setCapability(MobileCapabilityType.NO_RESET,true)
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"7200")
        caps.setCapability(MobileCapabilityType.APP,"C:/AppiumApp/AndroidsAPK/sportmaster-4.0.13.5642_dev_beta.apk")
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ru.sportmaster.app.handh.dev")
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,  "ru.sportmaster.app.presentation.start.StartActivity")
        //caps.setCapability(MobileCapabilityType.UDID,"")

        driver = AndroidDriver(url,caps)
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS)

    }
    @AfterSuite
    fun end(){
        driver.quit()
    }

    @Test
    fun testOne(){
        TimeUnit.SECONDS.sleep(10)

        //Нажатие на кнопку
        lateinit var element: MobileElement // создаем объект MobileElement
        element = driver.findElement(MobileBy.xpath(""))
        element.click()
        TimeUnit.SECONDS.sleep(3)
        //Ввод текста в поле телефона
        lateinit var element2: MobileElement
        element2 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/editTextPhone"))
        element2.sendKeys("9999999944")
        TimeUnit.SECONDS.sleep(3)
        //Клик на кнопку Получить код
        lateinit var element3: MobileElement
        element3 = driver.findElement(MobileBy.id(""))
        element3.click()
        TimeUnit.SECONDS.sleep(3)
    }
}