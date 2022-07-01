package com.otus.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//input[@placeholder='Электронная почта' and @type='text']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Введите пароль' and @type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Войти')]")
    private WebElement logIn;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public MenuComponent authorize(String mail, String password) {
        emailField.sendKeys(mail);
        passwordField.sendKeys(password);
        logIn.click();
        return new MenuComponent(driver);
    }
}
