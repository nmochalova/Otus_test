package com.otus.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    private final String SITE = "https://otus.ru";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openSite() {
        driver.get(SITE);
    }
}
