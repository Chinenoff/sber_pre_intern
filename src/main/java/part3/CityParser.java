package part3;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CityParser {
  /*public Map<Long, City> parseCity(File csvFile) throws IOException;*/
   List<City> parseCity(File csvFile) throws IOException;
}
