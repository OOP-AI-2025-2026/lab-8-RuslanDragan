package ua.opnu;

import java.util.ArrayList;
import java.util.Arrays; // Додано для виводу масивів
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate; // Додано для Task 4

public class Main {
    public static void main(String[] args) {


        System.out.println("==========================================");
        System.out.println("       ЗАВДАННЯ 1: MyOptional");
        System.out.println("==========================================");

        System.out.println("--- Тест 1: Порожнє значення ---");
        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"


        System.out.println("--- Тест 2: Заповнене значення ---");
        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"


        System.out.println("--- Тест 3: Помилка при get() на порожньому ---");
        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get(); // має кинути IllegalStateException
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }


        System.out.println("--- Тест 4: Заборона null у конструкторі ---");
        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }



        System.out.println("==========================================");
        System.out.println("       ЗАВДАННЯ 2: BookData");
        System.out.println("==========================================");

        List<BookData> library = new ArrayList<>();

        // книги для тестування сортування
        // Рейтинг 4.5
        library.add(new BookData("Java для чайників", "Баррі Берд", 10, 45.0));
        // Рейтинг 5.0 (Найвищий -> має бути першою)
        library.add(new BookData("Clean Code", "Роберт Мартін", 5, 25.0));
        // Рейтинг 4.0
        library.add(new BookData("Гаррі Поттер", "Дж. Роулінг", 100, 400.0));
        // Рейтинг 4.5 (Рейтинг такий же як у першої, але назва на 'A' -> має бути вище першої)
        library.add(new BookData("Algorithms", "Томас Кормен", 20, 90.0));

        System.out.println("--- Список книг ДО сортування ---");
        for (BookData book : library) {
            System.out.println(book);
        }

        Collections.sort(library);

        System.out.println("\n--- Список книг ПІСЛЯ сортування ---");
        System.out.println("(Правило: спочатку вищий рейтинг, якщо рівні - за алфавітом)");
        for (BookData book : library) {
            System.out.println(book);
        }



        System.out.println("==========================================");
        System.out.println("       ЗАВДАННЯ 3: Printer");
        System.out.println("==========================================");

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        System.out.println("Друк масиву цілих чисел:");
        myPrinter.printArray(intArray);

        System.out.println("Друк масиву рядків:");
        myPrinter.printArray(stringArray);

        // ==========================================
        // ЗАВДАННЯ 4: Generic Filter
        // ==========================================
        System.out.println("==========================================");
        System.out.println("       ЗАВДАННЯ 4: Generic Filter");
        System.out.println("==========================================");

        Task4 task4 = new Task4();

        // Тест 1: Числа (Integer)
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Predicate<Integer> isEven = n -> n % 2 == 0;

        Object[] evenNumbers = task4.filter(numbers, isEven);

        System.out.println("Початкові числа: " + Arrays.toString(numbers));
        System.out.println("Тільки парні:    " + Arrays.toString(evenNumbers));

        // Тест 2: Рядки (String)
        String[] words = {"Java", "C", "Python", "Go", "Pascal"};
        Predicate<String> isLong = s -> s.length() > 3;

        // ВИПРАВЛЕННЯ: Приймаємо результат як Object[]
        Object[] longWords = task4.filter(words, isLong);

        System.out.println("Початкові слова: " + Arrays.toString(words));
        System.out.println("Слова > 3 літер: " + Arrays.toString(longWords));


        System.out.println("==========================================");
        System.out.println("       ЗАВДАННЯ 5: Generic Contains");
        System.out.println("==========================================");

        String[] cities = {"Kyiv", "Lviv", "Odesa", "Kharkiv"};
        String searchCity = "Odesa";
        String missingCity = "Dnipro";

        boolean hasOdesa = Task5.contains(cities, searchCity);
        boolean hasDnipro = Task5.contains(cities, missingCity);

        System.out.println("Масив: " + Arrays.toString(cities));
        System.out.println("Чи є 'Odesa'? " + hasOdesa);
        System.out.println("Чи є 'Dnipro'? " + hasDnipro);

        Integer[] primes = {2, 3, 5, 7, 11, 13};
        Integer searchNumber = 7;
        Integer missingNumber = 9;

        boolean hasSeven = Task5.contains(primes, searchNumber);
        boolean hasNine = Task5.contains(primes, missingNumber);

        System.out.println("Масив: " + Arrays.toString(primes));
        System.out.println("Чи є '7'? " + hasSeven);
        System.out.println("Чи є '9'? " + hasNine);

        System.out.println("\n==========================================");
        System.out.println("       ЗАВДАННЯ 6: Generic Tuples");
        System.out.println("==========================================");

        // 1. Демонстрація GenericTwoTuple (Студентський рейтинг: String, Integer)
        GenericTwoTuple<String, Integer> studentRating = new GenericTwoTuple<>("Іванов", 85);
        System.out.println("TwoTuple (Прізвище, Бал): " + studentRating);
        System.out.println("   Тип першого поля: " + studentRating.first.getClass().getSimpleName());
        System.out.println("   Тип другого поля: " + studentRating.second.getClass().getSimpleName());

        System.out.println();

        // 2. Демонстрація GenericThreeTuple (ID, Назва, Зарплата: Integer, String, Double)
        GenericThreeTuple<Integer, String, Double> employeeData =
                new GenericThreeTuple<>(1001, "Технічний відділ", 45000.75);

        System.out.println("ThreeTuple (ID, Назва відділу, Зарплата): " + employeeData);
        System.out.println("   ID: " + employeeData.getFirst());
        System.out.println("   Зарплата (третє поле): " + employeeData.three);
    }
}