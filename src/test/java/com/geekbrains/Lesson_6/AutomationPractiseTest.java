package com.geekbrains.Lesson_6;

import com.geekbrains.Lesson_7.AdditionalAllureSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import static org.junit.Assert.assertTrue;

@Feature("Вход на сайт под тестовым логином")
public class AutomationPractiseTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalAllureSteps()).decorate(new ChromeDriver());
        driver.get("https://diary.ru");
    }

    @Test
    @DisplayName("Тест: Вход на сайт Diary.ru")
    @Story("Тест - Тест")
    void logInToDiary() throws InterruptedException {
        Thread.sleep(5000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginButton.click();
        loginPage.userNameField.sendKeys("volkovc");
        loginPage.passwordField.sendKeys("stas123456");
        loginPage.LocReCap();// Пришлось использовать метод.
        loginPage.reCaptCheckBox.click();
        Thread.sleep(10000);
        loginPage.ReCaptchaExit();
        loginPage.singInButton.click();
        Thread.sleep(5000);
        String s = loginPage.userEquals.getText();
        Allure.step("Проверяем Логин после авторизации.");
        assertTrue(s.equals("volkovc"));
        System.out.println("Тест пройден!");
    }




    @AfterEach
    void killDriver() {
        driver.quit();
    }
}
