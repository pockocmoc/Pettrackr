package data_validator;

import exception.InvalidIDateFormatException;
import exception.InvalidNumberException;
import exception.InvalidSurnameException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import pettrackr.Gender;

public class Validator {

    private static Scanner scanner = new Scanner(System.in);

    public int checkNumber() {
        int number;
        do {
            try {
                System.out.print("Введите число от 1 до 5: ");
                number = Integer.parseInt(scanner.nextLine());
                if (number < 1 || number > 5) {
                    throw new InvalidNumberException("Число должно быть от 1 до 5");
                }
                break; // Введено правильное число, выходим из цикла
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            } catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return number;
    }

    public int checkNumberOneTwo() {
        int number;
        do {
            try {
                System.out.print("Введите число: ");
                number = Integer.parseInt(scanner.nextLine());
                if (number != 1 && number != 2) {
                    throw new InvalidNumberException("Число должно быть либо 1, либо 2");
                }
                break; // Введено правильное число, выходим из цикла
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            } catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return number;
    }

    public String checkNameLength() {
        String surname;
        do {
            try {
                System.out.print("Введите имя (от 2 до 50 символов): ");
                surname = scanner.nextLine();
                if (surname.length() < 2 || surname.length() > 50) {
                    throw new InvalidSurnameException("Имя должна быть не менее 2 символов и не более 50");
                }
                break; // Введена правильная фамилия, выходим из цикла
            } catch (InvalidSurnameException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return surname;
    }

    public LocalDate dateOfBirthValidator() {
        LocalDate dateOfBirth;
        do {
            try {
                System.out.print("Введите дату рождения в формате гггг-мм-дд: ");
                String dateString = scanner.nextLine();
                if (!dateString.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                    throw new InvalidIDateFormatException("Ошибка: неверный формат даты рождения.");
                }
                dateOfBirth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break; // Введена правильная дата рождения, выходим из цикла
            } catch (InvalidIDateFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return dateOfBirth;
    }

    public Gender validateGender() {
        Gender gender;
        do {
            try {
                System.out.print("Введите пол (M - мужской, F - женский): ");
                String input = scanner.nextLine();
                String normalizedInput = input.toUpperCase();

                if (normalizedInput.equals("M")) {
                    gender = Gender.MALE;
                    break; // Введен правильный пол, выходим из цикла
                } else if (normalizedInput.equals("F")) {
                    gender = Gender.FEMALE;
                    break; // Введен правильный пол, выходим из цикла
                } else {
                    throw new IllegalArgumentException("Ошибка: пол должен быть указан как 'M' или 'F'");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return gender;
    }

}
