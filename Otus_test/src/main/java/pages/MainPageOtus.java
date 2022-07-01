package pages;

import annotations.navigation.Url;
import annotations.navigation.UrlPattern;
import annotations.navigation.UrlPrefix;
import org.openqa.selenium.WebDriver;

@UrlPrefix("/")
@Url({
        @UrlPattern(name = "otus", pattern = "{1}")
})
public class MainPageOtus extends AnyPageAbs<MainPageOtus> {

    public MainPageOtus(WebDriver driver) {
        super(driver);
    }
}
