package D03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AOCD3 {
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
    String input = readInput(INPUT);
    int result = 0;

    /*
     * Part 1
     * String mulPattern = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
     */
    String mulPattern = "mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don\\'t\\(\\)";
    Pattern pattern = Pattern.compile(mulPattern);
    Matcher matcher = pattern.matcher(input);

    boolean toDo = true;
    while (matcher.find()) {
      String cur = matcher.group();
      System.out.println(cur);

      if (cur.equals("don't()")) {
        toDo = false;
      } else if (cur.equals("do()")) {
        toDo = true;
      } else {
        if (toDo) {
          cur = cur.substring(4, cur.length() - 1);
          String[] parts = cur.split(",");
          result += Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
        }
      }

      /*
       * Part 1
       * cur = cur.substring(4,cur.length()-1);
       * String[] parts = cur.split(",");
       * result += Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
       */
    }

    System.out.println(result);
  }
}
