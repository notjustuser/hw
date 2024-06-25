import animals.Animal;
import data.AnimalTypeData;
import data.ColorData;
import data.CommandsData;
import data.IData;
import factory.AnimalFactory;
import tools.EnumValidate;
import tools.NumbersTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static data.CommandsData.*;

public class Main {

    private static final NumbersTools numbersTools = new NumbersTools();
    private static final EnumValidate enumValidate = new EnumValidate();

    public static void main(String... args) {
        List<Animal> animals = new ArrayList();

        Scanner scanner = new Scanner(System.in);


        CommandsData[] commandsData = CommandsData.values();
        String[] commandsStr = new String[commandsData.length];
        for (int i = 0; i < commandsData.length; i++) {
            commandsStr[i] = commandsData[i].getName().toLowerCase();
        }

        AnimalTypeData[] animalTypeData = AnimalTypeData.values();
        String[] animalTypeStr = new String[animalTypeData.length];
        for (int i = 0; i < animalTypeData.length; i++) {
            animalTypeStr[i] = animalTypeData[i].getName().toLowerCase();
        }

        ColorData[] colorData = ColorData.values();
        String[] colorStr = new String[colorData.length];
        for (int i = 0; i < colorData.length; i++) {
            colorStr[i] = colorData[i].getName().toLowerCase();
        }

        while (true) {
            System.out.printf("Введите одну из команд: %s\n", String.join("/", commandsStr));
            IData userCommand = enumValidate.checkValueInEnum(scanner, CommandsData.class);

            switch (userCommand) {
                case ADD:
                    AnimalFactory animalFactory = new AnimalFactory();
                    System.out.printf("Введите тип животного: %s\n", String.join("/", animalTypeStr));
                    IData userAnimalType = enumValidate.checkValueInEnum(scanner, AnimalTypeData.class);
                    Animal userAnimal = animalFactory.create((AnimalTypeData) userAnimalType);

                    System.out.println("Введите имя животного:");
                    String name = scanner.next().trim();
                    userAnimal.setName(name);

                    System.out.println("Введите возраст животного от 1 до 50:");
                    userAnimal.setAge(numbersTools.getNumberFromScanner(scanner, 1, 50));

                    System.out.println("Введите вес животного от 1 до 100:");
                    userAnimal.setWeight(numbersTools.getNumberFromScanner(scanner, 1, 100));

                    System.out.printf("Введите цвет животного: %s\n", String.join("/", colorStr));
                    IData userColor = enumValidate.checkValueInEnum(scanner, ColorData.class);
                    userAnimal.setColor((ColorData) userColor);

                    animals.add(userAnimal);

                case LIST:
                    for (Animal animalList : animals) {
                        System.out.println(animalList.toString());
                    }
                    break;
                case EXIT:
                    System.exit(0);
                default:
                    throw new IllegalStateException("Unexpected value: " + userCommand);
            }
        }

    }
}
