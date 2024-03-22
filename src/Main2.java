import java.util.Scanner;

class Figure {
    private double area;

    public Figure() {
        this.area = 0.0;
    }

    public double getArea() {
        return area;
    }
}

class Circle2 extends Figure {
    private double radius;

    public Circle2(double radius) {
        if (radius <= 0) {
            System.out.println("Некорректное значение радиуса. Радиус должен быть положительным.");
        } else {
            this.radius = radius;
        }
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Figure {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            System.out.println("Некорректные значения длины или ширины. Длина и ширина должны быть положительными.");
        } else {
            this.length = length;
            this.width = width;
        }
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество фигур: ");
        int size = scanner.nextInt();

        Figure[] figures = new Figure[size];

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                figures[i] = new Circle2(5.0); // Пример создания круга с радиусом 5.0
            } else {
                figures[i] = new Rectangle(4.0, 3.0); // Пример создания прямоугольника с длиной 4.0 и шириной 3.0
            }
        }

        int circleCount = 0;
        int rectangleCount = 0;

        for (Figure figure : figures) {
            if (figure instanceof Circle2) {
                circleCount++;
            } else if (figure instanceof Rectangle) {
                rectangleCount++;
            }
            System.out.println("Площадь фигуры: " + figure.getArea());
        }

        System.out.println("Количество кругов: " + circleCount);
        System.out.println("Количество прямоугольников: " + rectangleCount);
    }
}