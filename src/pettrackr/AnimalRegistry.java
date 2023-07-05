package pettrackr;

import data_validator.Validator;
import exception.InvalidNumberException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {

    private List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    Validator validator = new Validator();

    public void start() throws InvalidNumberException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            
            System.out.println("=== Животные ===");
            System.out.println("1. Показать список животных");
            System.out.println("2. Завести новое животное");
            System.out.println("3. Увидеть список команд животного");
            System.out.println("4. Обучить животное новым командам");
            System.out.println("5. Выход");
            System.out.print("Введите номер выбранной операции: ");
            int choice = validator.checkNumber();

            switch (choice) {
                case 1:
                    showAnimalList(animals);
                    break;
                case 2:
                    addAnimal();
                    break;
                case 3:
                    listAnimalCommands();
                    break;
                case 4:
                    trainAnimal();
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор операции. Попробуйте снова.");
            }
        }
    }

    private void addAnimal() {
        try (Counter counter = new Counter()) {
            String name = validator.checkNameLength();

            LocalDate dateOfBirth = validator.dateOfBirthValidator();

            Gender gender = validator.validateGender();

            System.out.print("Выберите тип животного (1 - Домашнее животное, 2 - Вьючное животное): ");
            int typeChoice = validator.checkNumberOneTwo();
            Animal animal;
            switch (typeChoice) {
                case 1:
                    animal = new DomesticAnimal(name, dateOfBirth, gender);
                    break;
                case 2:
                    animal = new DraftAnimal(name, dateOfBirth, gender);
                    break;
                default:
                    System.out.println("Неверный выбор типа животного. Ввод нового животного отменен.");
                    return;
            }

            animals.add(animal);
            counter.add(); // Увеличение счетчика
            System.out.println("Животное успешно добавлено.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    private void listAnimalCommands() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = findAnimalByName(name);
        if (animal != null) {
            System.out.println("=== Список команд животного " + animal.getName() + " ===");
            animal.listCommands();
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    private void trainAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = findAnimalByName(name);
        if (animal != null) {
            System.out.print("Введите новую команду для животного " + animal.getName() + ": ");
            String command = scanner.nextLine();
            animal.addCommand(command);
            System.out.println("Команда успешно добавлена.");
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    private Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public static void showAnimalList(List<Animal> animals) {
        System.out.println("Список всех животных:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) throws InvalidNumberException {
        AnimalRegistry registry = new AnimalRegistry();
        registry.start();

    }
}
