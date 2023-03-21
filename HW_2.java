// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HW_2 {
    public static void main(String[] args) {
        Map<String, Integer> Names = new HashMap<>();  // Задаем список имен
        String Peoples = "Иван Иванов " +
                "Светлана Петрова " +
                "Кристина Белова " +
                "Анна Мусина " +
                "Анна Крутова " +
                "Иван Юрин " +
                "Петр Лыков " +
                "Павел Чернов " +
                "Петр Чернышов " +
                "Мария Федорова " +
                "Марина Светлова " +
                "Мария Савина " +
                "Мария Рыкова " +
                "Марина Лугова " +
                "Анна Владимирова " +
                "Иван Мечников " +
                "Петр Петин " +
                "Иван Ежов ";

        String[] Peoples_lst = Peoples.split(" ");   // ПОдсчитываем количество совпадений
        for (int i = 0; i < Peoples_lst.length; i += 2) {
            if (Names.containsKey(Peoples_lst[i])) {
                Names.replace(Peoples_lst[i], Names.get(Peoples_lst[i]) + 1);
            } else {
                Names.put(Peoples_lst[i], 1);
            }

        }
        Map<String, Integer> Name_sort = new LinkedHashMap<>();   
        int max = 1;
        for (int value : Names.values()) {
            if (value > max) {
                max = value;
            }

        }
        for (int i = max; i > 0; i--) {                 
            for (Map.Entry<String, Integer> entry : Names.entrySet()) {
                String key = entry.getKey();
                if (Names.get(key) == i) {
                    Name_sort.put(key, Names.get(key));
                }
            }
        }
        for (Map.Entry<String, Integer> entry : Names.entrySet()) { // выводим результаты на экран
            System.out.println(entry.getKey() + " - " + entry.getValue() + " раз(а)");
        }// System.out.println(Name_sort);
    }
}

 