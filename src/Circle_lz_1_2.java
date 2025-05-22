import java.util.Scanner;
import static java.lang.Math.PI;
import static java.lang.Math.pow;

// Класс описывает окружность с центром и диаметром
class Circle_lz_1_2 {
    public double x, y; // координаты центра окружности
    public double d;    // диаметр окружности

    // Конструктор без параметров запрашивает данные у пользователя
    public Circle_lz_1_2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите координату X центра окружности: ");
        x = scanner.nextDouble(); // Сохраняем значение X

        System.out.print("Введите координату Y центра окружности: ");
        y = scanner.nextDouble(); // Сохраняем значение Y

        System.out.print("Введите диаметр окружности: ");
        d = scanner.nextDouble(); // Сохраняем диаметр
    }

    // Конструктор с параметрами данные задаются напрямую в коде
    public Circle_lz_1_2(double x, double y, double d) {
        this.x = x; // Присваиваем значение координаты X
        this.y = y; // Присваиваем значение координаты Y
        this.d = d; // Присваиваем диаметр
    }

    // Метод для вычисления площади круга
    public double getArea() {
        double radius = d / 2; // Радиус это половина диаметра
        return PI * pow(radius, 2); // Формула: π * r^2
    }
}