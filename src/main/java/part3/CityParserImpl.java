package part3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityParserImpl implements CityParser {

  public List<City> parseCity(File csvFile) throws IOException {
    List<City> cities = new ArrayList<>();
    try (Scanner scanner = new Scanner(csvFile)) {
      scanner.nextLine();
      while (scanner.hasNextLine()) {
        City newCity = readCity(scanner.nextLine());
        cities.add(newCity);
      }
    }
    return cities;
  }

  private City readCity(String nextLine) {
    String[] data = nextLine.split(";");
    City city = new City();
    city.setId(Long.parseLong(data[0]));
    city.setName(data[1]);
    city.setRegion(data[2]);
    city.setDistrict(data[3]);
    city.setPopulation(Integer.parseInt(data[4]));
    if (data.length == 6){
      city.setFoundation(data[5]);
    }
    return city;
  }
}
