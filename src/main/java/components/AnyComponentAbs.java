package components;

import org.openqa.selenium.WebDriver;
import po.PageObjectAbs;

public abstract class AnyComponentAbs<T> extends PageObjectAbs<T> {

  public AnyComponentAbs(WebDriver driver) {
    super(driver);
  }

}
