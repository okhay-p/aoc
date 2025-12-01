import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AOCD6_part2 {
  private static final String INPUT = "D06/input.txt";
  private static final String SAMPLE_INPUT = "D06/sample.txt";

  private static char[][] map;
  private static char[][] mapOriginal;
  private static char[][] mapNew;

  private static int mapWidth;
  private static int mapHeight = 0;

  private static boolean end = false;
  private static int[] curIdx = new int[2];
  private static int[] curOriIdx = new int[2];
  private static char curDir;
  private static char curOriDir;
  private static int loop = 0;

  private static boolean curIsX = false;
  private static boolean prevIsX = false;
  private static boolean prevPrevIsX = false;

  private static int count = 0;

  /* 
   * ERROR IN LOOP DETECTION LOGIC
   */


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

  private static void printArr(char[] arr) {
    String result = "[";
    for (int i = 0; i < arr.length; i++) {
      result += arr[i] + ", ";
    }
    result += "\b\b]";
    System.out.println(result);
  }

  private static boolean moveFirst() {
    int i = curIdx[0];
    int j = curIdx[1];
    map[i][j] = 'x';
    switch (curDir) {

      case '^':
        if (i - 1 < 0) {
          return true;
        }
        if (map[i - 1][j] == '#') {
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

  private static boolean move() {
    count++;
    int i = curIdx[0];
    int j = curIdx[1];

    curIsX = mapNew[i][j] == 'x'; 

    mapNew[i][j] = 'x';
    switch (curDir) {
      case '^':
        if (i - 1 < 0) {
          return true;
        }
        if (mapNew[i - 1][j] == '#') {
          curDir = '>';
          mapNew[i][j] = '>';
        } else {
          // map[i][j] = '^';
          curIdx[0] = i - 1;
        }
        break;

      case '>':
        if (j + 1 == mapWidth) {
          return true;
        }
        if (mapNew[i][j + 1] == '#') {
          curDir = 'v';
          mapNew[i][j] = 'v';
        } else {
          // map[i][j] = '>';
          curIdx[1] = j + 1;
        }
        break;

      case 'v':
        if (i + 1 == mapHeight) {
          return true;
        }
        if (mapNew[i + 1][j] == '#') {
          curDir = '<';
          mapNew[i][j] = '<';
        } else {
          // map[i][j] = 'v';
          curIdx[0] = i + 1;
        }
        break;

      case '<':
        if (j - 1 < 0) {
          return true;
        }
        if (mapNew[i][j - 1] == '#') {
          curDir = '^';
          mapNew[i][j] = '^';
        } else {
          // map[i][j] = '<';
          curIdx[1] = j - 1;
        }
        break;

      default:
        break;
    }

    if(count > 100000) {
      loop++;
      System.out.println(loop + " loop(s) found");
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    String input = readInput(INPUT);
    map = new char[mapHeight][mapWidth];
    mapOriginal = new char[mapHeight][mapWidth];
    mapNew = new char[mapHeight][mapWidth];

    String[] lines = input.split("\n");
    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];
      for (int j = 0; j < line.length(); j++) {
        char c = line.charAt(j);
        map[i][j] = c;
        mapOriginal[i][j] = c;
        mapNew[i][j] = c;

        if (c == '^' || c == '>' || c == 'v' || c == '<') {
          curIdx[0] = i;
          curIdx[1] = j;
          curOriIdx = curIdx.clone();
          curDir = c;
          curOriDir = c;
        }
      }
    }

    while (!end) {
      end = moveFirst();
    }

    // int result = countVisited();

    // System.out.println(result);

    for (char[] row : map) {
      printArr(row);
    }

    // Simulate the block addition on the 'x'
    for (int i = 0; i < mapHeight; i++) {
      for (int j = 0; j < mapHeight; j++) {
        if (map[i][j] == 'x') {
          mapNew[i][j] = '#';
          curIdx[0] = curOriIdx[0];
          curIdx[1] = curOriIdx[1];
          curDir = curOriDir;

          end = false;
          count = 0;
          while (!end) {
            end = move();
          }

         /*  for (char[] row : mapNew) {
            printArr(row);
          } */

          for (int x = 0; x < mapHeight; x++) {
            for (int y = 0; y < mapWidth; y++) {
              mapNew[x][y] = mapOriginal[x][y];
            }
          }
          System.out.println();

        }
      }
    }

    System.out.println(loop);

  }
}
