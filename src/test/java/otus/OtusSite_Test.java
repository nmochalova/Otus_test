package otus;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPageOtus;

@ExtendWith(UIExtension.class)
public class OtusSite_Test {

    @Driver
    public WebDriver driver;

    @Test
    public void test_open_page_course() {
        MainPageOtus mainPageOtus = new MainPageOtus(driver);
        //mainPageOtus.open("otus","/");
        mainPageOtus.open();
    }

}
