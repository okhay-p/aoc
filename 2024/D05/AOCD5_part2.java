import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class AOCD5_part2 {
  private static final String INPUT = "D05/input.txt";
  private static final String SAMPLE_INPUT = "D05/sample.txt";

  private static boolean valid = true;

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

  private static boolean isValid(String[] pages, Graph graph) {

    boolean valid = true;

    for (int i = 0; i < pages.length && valid; i++) {
      for (int j = i + 1; j < pages.length && valid; j++) {
        if (!graph.checkEdge(Integer.parseInt(pages[i]), Integer.parseInt(pages[j]))) {
          valid = false;
          break;
        }
      }
    }

    return valid;
  }

  public static void generatePermutations(String[] pages, int start, Graph graph) {
    if (start == pages.length) {
      if (isValid(pages, graph)) {
        System.out.println("Valid permutation: " + java.util.Arrays.toString(pages));
        valid = true; // Set valid to true if the condition is met
      }
      return;
    }

    for (int i = start; i < pages.length; i++) {
      swap(pages, start, i);
      generatePermutations(pages, start + 1, graph);

      if(valid) {
        return;
      }

      swap(pages, start, i);
    }
  }

  private static void swap(String[] pages, int i, int j) {
    String temp = pages[i];
    pages[i] = pages[j];
    pages[j] = temp;
  }

  private static void printArr(String[] arr) {
    String result = "[";
    for (int i = 0; i < arr.length; i++) {
      result += arr[i] + ", ";
    }
    result += "\b\b]";
    System.out.println(result);
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

      System.out.println("===========");
      System.out.println(update);

      boolean swapped = false;

      String[] pages = update.split(",");
      valid = isValid(pages, graph);

      if (!valid) {
        swapped = true;
        generatePermutations(pages, 0, graph);
      }

      if (swapped && valid) {
        result += Integer.parseInt(pages[pages.length / 2]);
      }
    }

    System.out.print(result);

  }
}
