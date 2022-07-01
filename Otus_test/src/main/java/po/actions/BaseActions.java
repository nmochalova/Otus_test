package po.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class BaseActions<T> {

  protected BiFunction<LocalDate, WebElement, T> setDateInCalendar = (LocalDate date, WebElement element) -> {
    element.click();
    for(int i = 0; i < 8; i++) {
      element.sendKeys(Keys.BACK_SPACE);
    }

    element.sendKeys(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), Keys.ESCAPE);

    return (T)this;
  };
}
