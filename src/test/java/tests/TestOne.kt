package tests

import constructor_classes.locatorTypes
import locators.*
import main.TestMethods
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestOne: TestMethods() {

    @Test
    fun testOne() {
        //Нажатие на кнопку закрытия у онбординга
        try {
            clickToElement(
                locatorType = locatorTypes.xpath,
                locator = SplashScreenLocators().exitButtonOnSplashScreen.androidXpath
            )
            // клик по элементу
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, продолжаем тест")
        }
        TimeUnit.SECONDS.sleep(3)

        //Ввод текста в поле телефона
        try {
            inputTextInField(
                locatorType = locatorTypes.id,
                locator = AuthorizationAndRegistrationLocators().telephoneFieldOnAuthorizationAndRegistration.androidId,
                inputText = "9999999944"
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, продолжаем тест")
        }
        TimeUnit.SECONDS.sleep(5)

        //Клик на кнопку Получить код
        try {
            clickToElement(
                locatorType = locatorTypes.id,
                locator = AuthorizationAndRegistrationLocators().buttonGetCodeOnAuthorizationAndRegistration.androidId
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, продолжаем тест")
        }
        TimeUnit.SECONDS.sleep(5)

        //Вводим код из смс
        try {
            inputTextInField(
                locatorType = locatorTypes.id,
                locator = PinCodeScreenLocators().pinCodeEditTextOnPinCodeScreen.androidId,
                inputText = "1111"
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, продолжаем тест")
        }
        TimeUnit.SECONDS.sleep(8)


        //Согласие на доступ к данным устройства
        try {
            clickToElement(
                locatorType = locatorTypes.id,
                locator = PermissionLocators().permissionAllowButtonOnPermissionLocators.androidId
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, продолжаем тест")
        }
        TimeUnit.SECONDS.sleep(8)

        //Соглашаемся с городом
        try {
            clickToElement(
                locatorType = locatorTypes.id,
                locator = ProposedCityLocators().proposedCityButtonOnProposedCity.androidId
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, продолжаем тест")
        }
            TimeUnit.SECONDS.sleep(8)

        //Тап по кнопке профиля в таббаре для перехода в профиль
        clickToElement(
            locatorType = locatorTypes.id,
            locator = ProfileTabBarLocators().profileButtonTabOnProfileTabBar.androidId
        )
        TimeUnit.SECONDS.sleep(5)

        //Тап по карандашу чтобы перейти в настройки профиля
        clickToElement(
            locatorType = locatorTypes.id,
            locator = ProfileScreenLocators().buttonEditProfileOnProfileScreen.androidId
        )
        TimeUnit.SECONDS.sleep(5)

        //Свайп по экрану вниз до кнопки выхода из профиля
        swipeOnScreen(
            startCordX = 480,
            startCordY = 1233,
            moveCordX = 487,
            moveCordY = 742
        )
        TimeUnit.SECONDS.sleep(5)

        //Тап по кнопке выхода из профиля внизу
        clickToElement(
            locatorType = locatorTypes.id,
            locator = ProfileEditScreenLocators().buttonLogoutOnProfileEditScreen.androidId
        )
        TimeUnit.SECONDS.sleep(8)

        //Проверка доступности кнопки Войти на экране профиля после разлогина
        checkAvailableElement(
            locatorType = locatorTypes.id,
            locator = ProfileOutScreenLocators().buttonSignInOnProfileOutScreen.androidId
        )
        TimeUnit.SECONDS.sleep(5)
    }
}