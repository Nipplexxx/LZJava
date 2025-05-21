package LZ_1_2_Zad2;

import java.util.Arrays;  // Для вывода массива в удобном виде
import java.util.Random;  // Для генерации случайных чисел
import java.util.Scanner; // Для ввода данных с клавиатуры

public class Sort_lz_1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Просим пользователя ввести размер массива
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt(); // Сохраняем введённое значение

        // Генерируем массив случайных чисел от 0 до 20 (без чисел, оканчивающихся на 0)
        int[] array = generateRandomArray(n);

        // Показываем массив до сортировки
        System.out.println("Массив до сортировки: " + Arrays.toString(array));

        // Сортируем массив по возрастанию
        Arrays.sort(array);

        // Показываем массив после сортировки
        System.out.println("Массив после сортировки: " + Arrays.toString(array));
    }

    /*
     Метод для создания массива из n случайных чисел от 0 до 20
     Ни одно число не должно заканчиваться на 0 (то есть не должно быть 0, 10, 20)
     */
    public static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n]; // Создаём массив на n элементов

        for (int i = 0; i < n; i++) {
            int number;
            // Генерируем число до тех пор, пока оно не оканчивается на 0
            do {
                number = random.nextInt(21); // Случайное число от 0 до 20
            } while (number % 10 == 0); // Повторять, если число оканчивается на 0 (0, 10, 20)

            array[i] = number; // Сохраняем подходящее число в массив
        }

        return array; // Возвращаем готовый массив
    }
}