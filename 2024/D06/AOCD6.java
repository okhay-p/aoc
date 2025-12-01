import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AOCD6 {
  private static final String INPUT = "D06/input.txt";
  private static final String SAMPLE_INPUT = "D06/sample.txt";

  private static char[][] map;

  private static int mapWidth;
  private static int mapHeight = 0;

  private static boolean end = false;
  private static int[] curIdx = new int[2];
  private static char curDir;
  private static int turn = 0;

  private static String readInput(String filePath) {
    String input = "";

    try {
      List<String> lines = Files.readAllLines(Paths.get(filePath));
      for (String line : lines) {
        mapWidth = line.length();
        mapHeight++;
        input += line + '\n';
      }
      return input;
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
      return input;
    }
  }

  private static boolean move() {
    int i = curIdx[0];
    int j = curIdx[1];
    map[i][j] = 'x';
    switch (curDir) {

      case '^':
        if (i - 1 < 0) {
          return true;
        }
        if (map[i - 1][j] == '#') {
          turn++;
          curDir = '>';
          map[i][j] = '>';
        } else {
          curIdx[0] = i - 1;
        }
        break;

      case '>':
        if (j + 1 == mapWidth) {
          return true;
        }
        if (map[i][j + 1] == '#') {
          turn++;
          curDir = 'v';
          map[i][j] = 'v';
        } else {
          curIdx[1] = j + 1;
        }
        break;

      case 'v':
        if (i + 1 == mapHeight) {
          return true;
        }
        if (map[i + 1][j] == '#') {
          turn++;
          curDir = '<';
          map[i][j] = '<';
        } else {
          curIdx[0] = i + 1;
        }
        break;

      case '<':
        if (j - 1 < 0) {
          return true;
        }
        if (map[i][j - 1] == '#') {
          turn++;
          curDir = '^';
          map[i][j] = '^';
        } else {
          curIdx[1] = j - 1;
        }
        break;

      default:
        break;
    }
    return false;
  }

  private static int countVisited() {
    int count = 0;
    for (char[] row : map) {
      for (char c: row) {
        if (c == 'x') {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    String input = readInput(SAMPLE_INPUT);
    map = new char[mapHeight][mapWidth];

    String[] lines = input.split("\n");
    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];
      for (int j = 0; j < line.length(); j++) {
        char c = line.charAt(j);
        map[i][j] = c;

        if (c == '^' || c == '>' || c == 'v' || c == '<') {
          curIdx[0] = i;
          curIdx[1] = j;
          curDir = c;
        }
      }
    }

    while (!end) {
      end = move();
    }
    
    int result = countVisited();

    System.out.println(result);
    System.out.println(turn);
  }
}
