package com.geekbrains.Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPractiseExample
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php?id_category=5&controller=category#/");
        WebElement sSize = webDriver.findElement(By.xpath("//input[@id='layered_id_attribute_group_1']"));
        sSize.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Cancel']")));
        //Thread.sleep(9000);
        webDriver.findElement(By.xpath("//a[@title='Cancel']")).click();
        Thread.sleep(5000);
        webDriver.quit();
    }
}
