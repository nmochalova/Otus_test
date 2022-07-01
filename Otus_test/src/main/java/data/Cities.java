package data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public enum Cities {
  Moscow("Москва"),
  Ekaterinburg("Екатеринбург");

  private String name;
}
