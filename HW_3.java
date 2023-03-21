// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
//  И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000

public class HW_3 {
    public static void main(String[] args) {
        int[] ferz = new int[8];
        find_position(0, ferz);

        // Вывод доски в консоль
        for (int row = 0; row < 8; row++) {
            for (int i = 0; i < 8; i++) {
                if (ferz[row] == i) {
                    System.out.print("X");
                } else {
                    System.out.print("o");
                }
            }
            System.out.println();
        }
    }

    // Вызов функции
    private static boolean find_position(int row, int[] ferz) {
        if (row == 8) { // Вернуть true, если расставили всех ферзей
            return true;
        }
        for (int col = 0; col < 8; col++) {
            boolean safe_position = true;
            for (int i = 0; i < row; i++) {
                // Если клетка занята возвращаем false
                if (ferz[i] == col || ferz[i] == col - row + i || ferz[i] == col + row - i) {
                    safe_position = false;
                    break;
                }
            }
            if (safe_position) {
                ferz[row] = col; // Сохраняем расстановку
                if (find_position(row + 1, ferz)) { // Рекурсия для проверки следующего ряда
                    return true;
                }
            }
        }
        return false;
    }
}
