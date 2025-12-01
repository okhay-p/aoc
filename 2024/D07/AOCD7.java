package D07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AOCD7 {
  private static final String INPUT = "D07/input.txt";
  private static final String SAMPLE_INPUT = "D07/sample.txt";

  private static String readInput(String filePath) {
    String input = "" + "";

    try {
      List<String> lines = Files.readAllLines(Paths.get(filePath));
      for (String line : lines) {
        input += line + "\n";
      }
      return input;
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
      return input;
    }
  }

  public static void main(String[] args) {
    String input = readInput(SAMPLE_INPUT);

    for (String line : input.split("\n")) {
      int result = Integer.parseInt(line.split(":")[0]);
      String[] parts = line.split(":")[1].split(" ");
      int[] numbers = new int[parts.length];
      for (int i = 0; i < parts.length; i++) {
        String part = parts[i];
        numbers[i] = Integer.parseInt(part);
      }
    }
  }
}
