package D03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class template {
  private static final String INPUT = "D03/inputD03.txt";
  private static final String SAMPLE_INPUT = "D03/sample.txt";

  private static String readInput(String filePath) {
    String input = "";

    try {
      List<String> lines = Files.readAllLines(Paths.get(filePath));
      for (String line : lines) {
        input += line;
      }
      return input;
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
      return input;
    }
  }

  public static void main(String[] args) {
    String input = readInput(SAMPLE_INPUT);
  }
}
