package pages;

import static org.assertj.core.api.Assertions.assertThat;

import annotations.navigation.Url;
import annotations.navigation.UrlPattern;
import annotations.navigation.UrlPrefix;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import po.PageObjectAbs;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public abstract class AnyPageAbs<T> extends PageObjectAbs<T> implements IPage<T> {

  public AnyPageAbs(WebDriver driver) {
    super(driver);
  }

  private String getBaseUrl() {
    String baseUrl = StringUtils.stripEnd(System.getProperty("webdriver.base.url"), "/");
    return baseUrl;
  }

  private String getUrlPrefix() {
    UrlPrefix urlAnnotation = getClass().getAnnotation(UrlPrefix.class);

    if (urlAnnotation != null) {
      String urlPrefix = urlAnnotation.value();
      return urlPrefix;
    }

    return "";
  }

  private String getUrlByPattern(String name, String[] data) {
    Url url = getClass().getAnnotation(Url.class);
    if (url != null) {
      UrlPattern[] urlPatterns = url.value();

      Optional<UrlPattern> optionalUrlPattern = Arrays.stream(urlPatterns)
          .filter((UrlPattern pattern) -> Objects.equals(pattern.name(), name))
          .findFirst();

      assertThat(optionalUrlPattern.isPresent()).isTrue();

      String resultUrl = "";
      for (int i = 0; i < data.length; i++) {
        resultUrl = optionalUrlPattern.get().pattern().replace(String.format("{%d}", i + 1), data[i]);
      }

      return resultUrl;
    }

    return "";
  }

  public T open() {
    driver.get(getBaseUrl() + getUrlPrefix());

    return (T) page(getClass());
  }

  public T open(String urlPatternName, String... data) {
    String url = getBaseUrl() + getUrlByPattern(urlPatternName, data) + getUrlPrefix();
    driver.get(url);

    return (T)page(getClass());
  }

  public <T> T page(Class<T> clazz) {
    try {
      Constructor constructor = clazz.getConstructor(WebDriver.class);

      return convertInstanceOfObject(constructor.newInstance(driver), clazz);

    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
      e.printStackTrace();
    }

    return null;
  }

  private static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
    try {
      return clazz.cast(o);
    } catch (ClassCastException e) {
      return null;
    }
  }

}
