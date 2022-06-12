package pages;

import annotations.navigation.Url;
import annotations.navigation.UrlPattern;
import annotations.navigation.UrlPrefix;
import org.openqa.selenium.WebDriver;

@UrlPrefix("/")
@Url({
    @UrlPattern(name = "delivery", pattern = "{1}")

})
public class CardDeliveryPage extends AnyPageAbs<CardDeliveryPage> {

  public CardDeliveryPage(WebDriver driver) {
    super(driver);
  }
}
