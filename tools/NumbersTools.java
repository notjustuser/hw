package tools;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersTools {
    public int getNumberFromScanner(Scanner scanner, int start, int end) {
        Pattern pattern = Pattern.compile("\\d+");
        while (true) {
            String userStr = scanner.next().trim();
            Matcher matcher = pattern.matcher(userStr);
            boolean isNumber = matcher.find();
            int result = 0;
            if (!isNumber) {
                System.out.printf("Вы ввели: %s, попробуйте еще раз\n", userStr);
                continue;
            }
            result = Integer.parseInt(userStr);
            if (result >= start && result <= end) {
                return result;
            }
            System.out.printf("Вы ввели: %d, попробуйте еще раз\n", result);

        }
    }
}
