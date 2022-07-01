package com.otus.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuComponent {
    private WebDriver webDriver;

    public MenuComponent(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Вход')]")
    private WebElement auth;
    @FindBy(xpath = "//div[@class='header2-menu__icon-img ic-blog-default-avatar']")
    private WebElement avatar;
    @FindBy(xpath ="//a[@title='Личный кабинет']")
    private WebElement lk;
    @FindBy(xpath ="//a[@title='О себе']")
    private WebElement personal;

    public LoginPage getLoginPage() {
        auth.click();
        return new LoginPage(webDriver);
    }

    public AboutMyself goToProfile(){
        avatar.click();
        lk.click();
        personal.click();
        return new AboutMyself(webDriver);
    }
}
