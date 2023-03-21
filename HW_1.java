// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HW_1 {

    public static void main(String[] args) {
        Map<String, ArrayList<String>> Book_phone = new HashMap<>();
        
        boolean book = true;

        while (book) {
            System.out.println();
            String operation = input.Str("Введите команду:\n1- Добавить номер,\n" +
                    "2- Показать все контакты,\n" +
                    "0- Выход: ");
            
            switch (operation) {
                case "1":
                    AddContact(Book_phone);
                    break;
                case "2":
                    showAllContacts(Book_phone);
                    break;
                case "0":
                    book = false;
                    System.out.println("Всего доброго!");
                    break;
                default:
                    System.out.println("Неверная операция.");
                    break;
            }
        }
    }

    // Функция добавления нового контакта
    public static void AddContact(Map<String, ArrayList<String>> contact) {
        ArrayList<String> Num_phone = new ArrayList<>();
        String name = input.Str("Введите ФИО: ");
        String number = input.Str("Введите номер телефона: ");
        if (!contact.containsKey(name)) {
            contact.put(name, Num_phone);
        }
        
        contact.get(name).add(number);

    }
    // Функция вывода всей телефонной книги
    public static void showAllContacts(Map<String, ArrayList<String>> book) {
        for (String name : book.keySet()) {
            System.out.printf("Имя: " + name + "\n");
            ArrayList<String> phone2 = book.get(name);
            for (String phone : phone2) {
                System.out.printf("Номер телефона: " + phone + "\n");
            }
        }
    }
}
