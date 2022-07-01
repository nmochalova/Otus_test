package components.blocks;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import annotations.Component;
import components.AnyComponentAbs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class StaticComponent<T> extends AnyComponentAbs<T> {

  public StaticComponent(WebDriver driver) {
    super(driver);
  }

  {
    validateComponent();
  }

  private By getComponentBy() {
    Component component = getClass().getAnnotation(Component.class);
    if (component != null) {
      String value = component.value();

      return value.startsWith("/") ? By.xpath(value): By.cssSelector(value);
    }

    return null;
  }

  private void validateComponent() {
    assertThat(this.standartWaiter.elementShouldBePresent(getComponentBy()))
        .as("Component doesn't present on page")
        .isTrue();
  }

  protected WebElement getComponentEntity() {
    return $(getComponentBy());
  }
}
