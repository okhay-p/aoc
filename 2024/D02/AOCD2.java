
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AOCD2 {

    private static final String INPUT = "D02/inputD02.txt";
    // private static final String INPUT = "D02/sample.txt";

    private static String readInput(String filePath) {
        String input = "";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                input += line;
                input += "\n";
            }
            return input;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return input;
        }
    }

    private static boolean checkSafety(List<Integer> numbers) {
        boolean isSafe = true;
        boolean isDecreasing = true;

        if (numbers.get(0) == numbers.get(1)) {
            isSafe = false;
        } else {
            isDecreasing = numbers.get(0) > numbers.get(1);
            if (Math.abs(numbers.get(0) - numbers.get(1)) > 3) {
                isSafe = false;
            }
        }

        if (isSafe) {
            for (int i = 2; i < numbers.size(); i++) {
                int prev = numbers.get(i - 1);
                int cur = numbers.get(i);

                if (isDecreasing) {
                    if (prev <= cur || Math.abs(prev - cur) > 3) {
                        isSafe = false;
                        break;
                    }
                } else {
                    if (prev >= cur || Math.abs(prev - cur) > 3) {
                        isSafe = false;
                        break;
                    }
                }

            }
        }
        return isSafe;
    }

    public static void main(String[] args) {

        int result = 0;

        String input = readInput(INPUT);
        String[] lines = input.split("\n");
        for (String line : lines) {

            boolean isSafe = true;
            int removed = 0;

            String[] parts = line.split("\\s+");
            List<Integer> numbers = new ArrayList<>();
            List<Integer> numbersCopy = new ArrayList<>();
            for (String part : parts) {
                numbers.add(Integer.parseInt(part));
                numbersCopy.add(Integer.parseInt(part));
            }

            isSafe = checkSafety(numbers);

            if(!isSafe) {
                for (int i = 0; i < numbersCopy.size(); i++) {
                    numbers = new ArrayList<>(numbersCopy);
                    numbers.remove(i);
                    isSafe = checkSafety(numbers);
                    if(isSafe) {
                        removed = numbersCopy.get(i);
                        break;
                    }
                }

            }

            if (isSafe) {
                System.out.println(line + " : " + removed);
                result++;
            }
        }

        System.out.println("result: " + result);

    }
}
