package com.geekbrains.Lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class EfesTest {
    static WebDriver driver;
    Logger logger = LoggerFactory.getLogger("TestEfes");
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void initTest() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://efeskazakhstan.kz/check-age/");
    }


    @Test
    @DisplayName("Тест1 Вход на сайт")
    public void test1() {

        driver.get("https://efeskazakhstan.kz/check-age/");
        driver.findElement(By.xpath("//input[@id='checkageform-day']")).sendKeys("19");
        driver.findElement(By.xpath("//input[@id='checkageform-month']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@id='checkageform-year']")).sendKeys("1983");
        logger.info("Тест№1 пройден");
    }

    @Test
    @DisplayName("Тест2 Невалидные значения по возрасту")
    public void test2() {

        driver.get("https://efeskazakhstan.kz/check-age/");
        driver.findElement(By.xpath("//input[@id='checkageform-day']")).sendKeys("19");
        driver.findElement(By.xpath("//input[@id='checkageform-month']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@id='checkageform-year']")).sendKeys("2020");
        String s = driver.findElement(By.xpath("//div[@class='error-text']")).getText();
        assertTrue(s.equals("Ваш возраст не позволяет нам пустить вас на сайт :("));
        logger.info("Тест№2 пройден");
    }


    @AfterEach
    void finalBrowser() {
        driver.quit();
    }


}
