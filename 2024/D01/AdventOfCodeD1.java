
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdventOfCodeD1 {

    private static final String INPUT1 = "inputD01-1.txt";

    private static List<List<Integer>> readInput(String filePath) {

        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>());
        input.add(new ArrayList<>());

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split("\\s+");
                input.get(0).add(Integer.parseInt(parts[0]));
                input.get(1).add(Integer.parseInt(parts[1]));
            }
            return input;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
            return input;
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> input = readInput(INPUT1);
        List<Integer> left = input.get(0);
        List<Integer> right = input.get(1);
        Collections.sort(left);
        Collections.sort(right);

        int result = 0;
        for(int i = 0; i < left.size(); i++) {
            result += Math.abs(right.get(i) - left.get(i));
        }

        System.out.println("Part 1 result: " + result);

        int prev = 0;
        int prevScore = 0;
        int result2 = 0;
        for (int i = 0; i < left.size(); i++) {
            int cur = left.get(i);
            int curOccur = 0;
            int curScore = 0;
            if (cur == prev) {
                result2 += prevScore;
                continue;
            }

            for(int j = 0; right.get(j) <= cur; j++) {
                if(cur == right.get(j)) {
                    curOccur++;
                }
            }

            curScore = cur * curOccur;
            result2 += curScore;
            prev = cur;
            prevScore = curScore;

        }

        System.out.println("Part 2 result: " + result2);
    }
}
