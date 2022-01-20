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

class BaseClass {
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
        caps.setCapability(MobileCapabilityType.APP,"C:/AppiumApp/AndroidsAPK/sportmaster-4.0.13.5682_dev_beta.apk")
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

    @Test
    fun testOne(){
        TimeUnit.SECONDS.sleep(13)

        //Нажатие на кнопку закрытия у онбординга
        lateinit var element: MobileElement // создаем объект MobileElement
        element = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton\n")) // поиск элемента по xpath
        element.click() // клик по элементу
        TimeUnit.SECONDS.sleep(5)

        //Ввод текста в поле телефона
        lateinit var element2: MobileElement
        element2 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/editTextPhone"))
        element2.sendKeys("9999999944")
        TimeUnit.SECONDS.sleep(5)

        //Клик на кнопку Получить код
        lateinit var element3: MobileElement
        element3 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonGetCode"))
        element3.click()
        TimeUnit.SECONDS.sleep(5)

        //Вводим код из смс
        lateinit var element4: MobileElement
        element4 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/pinCodeEditText"))
        element4.sendKeys("1111")
        TimeUnit.SECONDS.sleep(5)


        //Согласие на доступ к данным устройства
        lateinit var element5: MobileElement
        element5 = driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button"))
        element5.click()
        TimeUnit.SECONDS.sleep(5)

        //Соглашаемся с городом
        lateinit var element6: MobileElement
        element6 = driver.findElement(MobileBy.id("android:id/button1"))
        element6.click()
        TimeUnit.SECONDS.sleep(5)


    }
}