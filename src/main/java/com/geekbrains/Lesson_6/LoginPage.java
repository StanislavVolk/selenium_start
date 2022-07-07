package com.geekbrains.Lesson_6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li//a[@href='https://diary.ru/user/login']")
    public WebElement loginButton;

    @FindBy(id = "loginform-username")
    public WebElement userNameField;

    @FindBy(id = "loginform-password")
    public WebElement passwordField;

    @Step("Проходим Капчу")
    public void LocReCap() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
    }

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement reCaptCheckBox;

    @Step("Выходим из Капчи")
    public void ReCaptchaExit() {
        driver.switchTo().parentFrame();//Долго парился и не мог понять, почему у меня кнопка входа не работает)))
    }

    @FindBy(id = "login_btn")
    public WebElement singInButton;




    @FindBy(xpath = "//li[@class='username']")
    public WebElement userEquals;
}





