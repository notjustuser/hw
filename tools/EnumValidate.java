package tools;

import data.IData;

import java.util.Scanner;

public class EnumValidate {
    public <T extends IData> IData checkValueInEnum(Scanner scanner, Class<T> enumType) {
        while (true) {
            String userStr = scanner.next().trim().toLowerCase();
            for (T val : enumType.getEnumConstants()) {
                if (val.getName().equals(userStr)) {
                    return val;
                }
            }
            System.out.printf("Вы ввели: %s, попробуйте еще раз\n", userStr);
            continue;
        }
    }
}