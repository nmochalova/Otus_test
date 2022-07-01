package pages;

public interface IPage<T> {
  T open();
  T open(String name, String... data);
}
