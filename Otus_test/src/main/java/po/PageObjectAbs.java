package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import po.actions.BaseActions;
import waiters.StandartWaiter;

import java.util.List;

public abstract class PageObjectAbs<T> extends BaseActions<T> {

  protected WebDriver driver;
  protected StandartWaiter standartWaiter;

  public PageObjectAbs(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
    standartWaiter = new StandartWaiter(driver);
  }

  protected WebElement $(By locator) {
    return driver.findElement(locator);
  }

  protected List<WebElement> $$(By locator) {
    return driver.findElements(locator);
  }

}
