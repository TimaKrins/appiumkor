package main

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import java.net.URL
import java.util.concurrent.TimeUnit

open class BaseClass {
    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    fun setupDriver(){

        val url = URL("http://127.0.0.1:4723/wd/hub")
        val caps = DesiredCapabilities()

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android") //Название платформы
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9") //Версия ОС
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Honor_10") //Имя устройства
        caps.setCapability(MobileCapabilityType.NO_RESET,false) // Не сбрасывать приложение в 0 перед новым запуском
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"7200")
        caps.setCapability(MobileCapabilityType.APP,"C:/AppiumApp/AndroidsAPK/sportmaster-4.0.13.5731_dev_beta.apk")
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ru.sportmaster.app.handh.dev")
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,  "ru.sportmaster.app.presentation.start.StartActivity")
        caps.setCapability(MobileCapabilityType.UDID,"CLCDU18621004592")

        driver = AndroidDriver(url,caps) //установка драйвера и приложения на Android устройство
        driver.manage().timeouts().implicitlyWait( 11, TimeUnit.SECONDS) // Время в течении которого будут искаться элементы

    }

    @AfterSuite
    fun end(){
        driver.quit()
    }
}