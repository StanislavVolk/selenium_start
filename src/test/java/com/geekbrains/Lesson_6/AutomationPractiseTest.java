package com.geekbrains.Lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AutomationPractiseTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://diary.ru");
    }

    @Test
    @DisplayName("Тест: Вход на сайт")
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
        assertTrue(s.equals("volkovc"));
        System.out.println("Тест пройден!");
    }

    @AfterEach
    void killDriver() {
        driver.quit();
    }
}
