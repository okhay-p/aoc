package D04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AOCD4_part2 {
  private static final String INPUT = "D04/inputD04.txt";
  private static final String SAMPLE_INPUT = "D04/sample.txt";

  private static List<String> global_input;

  private static List<String> readInput(String filePath) {
    List<String> input = new ArrayList<>();

    try {
      input = Files.readAllLines(Paths.get(filePath));

      return input;
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
      return input;
    }
  }

  private static boolean checkEachChar(int i, int j, String dir, char c) {
    int i_change = 0, j_change = 0, multiplier = 1;
    try {
      if (dir.contains("N")) {
        i_change = -1 * multiplier;
      }
      if (dir.contains("E")) {
        j_change = 1 * multiplier;
      }
      if (dir.contains("S")) {
        i_change = 1 * multiplier;
      }
      if (dir.contains("W")) {
        j_change = -1 * multiplier;
      }

      return global_input.get(i + i_change).charAt(j + j_change) == c;
    } catch (Exception e) {
      return false;
    }
  }

  private static boolean checkDiagonal(int i, int j, int diagonal) {
    try {

      if (diagonal < 0) {
        if (checkEachChar(i, j, "NW", 'M') && checkEachChar(i, j, "SE", 'S')) {
          return true;
        }

        if (checkEachChar(i, j, "SE", 'M') && checkEachChar(i, j, "NW", 'S')) {
          return true;
        }

      } else {
        if (checkEachChar(i, j, "NE", 'M') && checkEachChar(i, j, "SW", 'S')) {
          return true;
        }

        if (checkEachChar(i, j, "SW", 'M') && checkEachChar(i, j, "NE", 'S')) {
          return true;
        }

      }

      return false;
    } catch (Exception e) {
      return false;
    }
  }

  private static boolean check(int i, int j) {
    if (checkDiagonal(i, j, 1) && checkDiagonal(i, j, -1)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    global_input = readInput(INPUT);

    int result = 0;

    for (int i = 0; i < global_input.size(); i++) {
      String line = global_input.get(i);
      for (int j = 0; j < line.length(); j++) {
        if (line.charAt(j) == 'A') {
          if(check(i, j)) {
            result++;
          }
        }
      }
    }

    System.out.println(result);

  }
}
