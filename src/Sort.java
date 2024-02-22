import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //Массив
        int[] array = randomArray(n);

        System.out.println(": " + Arrays.toString(array));

        Arrays.sort(array);

        System.out.println("Массив после сортировки: " + Arrays.toString(array));
    }
    //Случайного массива
    public static int[] randomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(21);
            while (array[i] % 10 == 0) {
                array[i] = random.nextInt(21);
            }
        }
        return array;
    }
}