package part3;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Main {

  public static void main(String[] args) {
    File csvFile;
    try {
      csvFile = new File(
          Objects.requireNonNull(Main.class.getClassLoader().getResource("cities.csv")).getFile());
    } catch (NullPointerException exp) {
      System.out.println("Нет файла для загрузки: orgStructure.csv");
      exp.printStackTrace();
      return;
    }

    CityParser cityParser = new CityParserImpl();
    try {
      List<City> cities = cityParser.parseCity(csvFile);
      for (City city : cities) {
        System.out.println(city);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
