package annotations.navigation;

import java.lang.annotation.*;

@Repeatable(Url.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UrlPattern {
  String name();
  String pattern();
}
