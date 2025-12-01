package D04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AOCD4 {
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
    int i_change = 0, j_change = 0, multiplier;
    try {

      switch (c) {
        case 'M':
          multiplier = 1;
          break;
        case 'A':
          multiplier = 2;
          break;
        case 'S':
          multiplier = 3;
          break;
        default:
          multiplier = 0;
          break;
      }

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

  private static boolean checkEach(int i, int j, String dir) {
    try {
      if (checkEachChar(i, j, dir, 'M')
      && checkEachChar(i, j, dir, 'A')
      && checkEachChar(i, j, dir, 'S')) {
        return true;
      }
      return false;
    } catch (Exception e) {
      return false;
    }
  }

  private static int check(int i, int j) {
    int count = 0;

    if (checkEach(i, j, "N"))
      count++;
    if (checkEach(i, j, "NE"))
      count++;
    if (checkEach(i, j, "E"))
      count++;
    if (checkEach(i, j, "SE"))
      count++;
    if (checkEach(i, j, "S"))
      count++;
    if (checkEach(i, j, "SW"))
      count++;
    if (checkEach(i, j, "W"))
      count++;
    if (checkEach(i, j, "NW"))
      count++;

    return count;
  }

  public static void main(String[] args) {
    global_input = readInput(INPUT);

    int result = 0;

    for (int i = 0; i < global_input.size(); i++) {
      String line = global_input.get(i);
      for (int j = 0; j < line.length(); j++) {
        if (line.charAt(j) == 'X') {
          result += check(i, j);
        }
      }
    }

    System.out.println(result);

  }
}
