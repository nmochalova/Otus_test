package com.otus.practice;

import com.otus.practice.pages.AboutMyself;
import com.otus.practice.pages.MainPage;
import com.otus.practice.pages.MenuComponent;
import org.junit.Assert;
import org.junit.Test;

//vladoladvlad@gtest.com
//veryStrongPassword111!
//mvn clean test -Dmail="vladoladvlad@gtest.com" -Dpass="veryStrongPassword111!"

public class OtusTest extends BaseTest{
    @Test
    public void OtusTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();

        String mail = System.getProperty("mail");
        String password = System.getProperty("pass");
        AboutMyself myself = new MenuComponent(driver)
                .getLoginPage()
                .authorize(mail,password)
                .goToProfile();

        Assert.assertEquals(myself.getName(), "Владимир");
        Assert.assertEquals(myself.getSurname(), "Владимиров");
    }
}
