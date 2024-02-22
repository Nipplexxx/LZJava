import java.util.Scanner;
import static java.lang.Math.PI;
import static java.lang.Math.pow;

class Circle {
    public double x, y; //центра окружности
    public double d; //диаметр окружности

    //Конструктор без параметров
    public Circle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату x центра окружности: ");
        x = scanner.nextDouble();
        System.out.print("Введите координату y центра окружности: ");
        y = scanner.nextDouble();
        System.out.print("Введите диаметр окружности: ");
        d = scanner.nextDouble();
    }

    //Конструктор с параметрами
    public Circle(double x, double y, double d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    // Метод для определения площади круга
    public double getArea() {
        double radius = d / 2;
        return PI * pow(radius, 2);
    }
}
