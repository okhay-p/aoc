import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class AOCD5 {
  private static final String INPUT = "D05/input.txt";
  private static final String SAMPLE_INPUT = "D05/sample.txt";

  private static String readInput(String filePath) {
    String input = "";

    try {
      List<String> lines = Files.readAllLines(Paths.get(filePath));
      for (String line : lines) {
        input += line + '\n';
      }
      return input;
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
      return input;
    }
  }

  public static void main(String[] args) {
    String input = readInput(INPUT);

    String[] parts = input.split("\\n{2,}");
    String[] rules = parts[0].split("\n");
    String[] updates = parts[1].split("\n");

    int result = 0;

    Graph graph = new Graph();
    for (String rule : rules) {
      String[] pages = rule.split("\\|");
      int src = Integer.parseInt(pages[0]);
      int dest = Integer.parseInt(pages[1]);

      graph.addVertex(src);
      graph.addVertex(dest);

      graph.addEdge(src, dest);
    }

    for (String update : updates) {

      boolean valid = true;

      String[] pages = update.split(",");
      for (int i = 0; i < pages.length && valid; i++) {
        for(int j = i  + 1; j < pages.length && valid; j++) {
          if(!graph.checkEdge(Integer.parseInt(pages[i]), Integer.parseInt(pages[j]))) {
            valid = false;
            break;
          }
        }
      }

      if (valid) {
        result += Integer.parseInt(pages[pages.length / 2]);
      }
    }


    System.out.print(result);

  }
}
