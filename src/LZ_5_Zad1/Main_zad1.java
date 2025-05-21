package LZ_5_Zad1;

import java.util.Scanner;

// Родительский (базовый) класс "Фигура"
class Figure_zad1 {
    // Пустой метод для расчёта площади.
    // Он переопределяется (перезаписывается) в дочерних классах.
    public double area() {
        return 0.0;
    }

    // Важно: этот метод НЕ должен быть private,
    // иначе его нельзя будет переопределить в дочерних классах (см. ниже).
}

// Класс "Круг", наследуется от "Фигуры"
class Circle_zad1 extends Figure_zad1 {
    // Поле "радиус" сделано закрытым (инкапсуляция)
    private double radius;

    // Конструктор для создания круга
    public Circle_zad1(double radius) {
        if (radius <= 0) {
            System.out.println("Ошибка: радиус должен быть положительным.");
            this.radius = 1; // устанавливаем значение по умолчанию
        } else {
            this.radius = radius;
        }
    }

    // Переопределяем метод area() — теперь он возвращает площадь круга
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Класс "Прямоугольник", тоже наследуется от "Фигуры"
class Rectangle_zad1 extends Figure_zad1 {
    private double length; // длина
    private double width;  // ширина

    public Rectangle_zad1(double length, double width) {
        if (length <= 0 || width <= 0) {
            System.out.println("Ошибка: длина и ширина должны быть положительными.");
            this.length = 1;
            this.width = 1;
        } else {
            this.length = length;
            this.width = width;
        }
    }

    // Переопределяем метод area() — теперь он возвращает площадь прямоугольника
    @Override
    public double area() {
        return length * width;
    }
}

// Главный класс программы с точкой входа main()
public class Main_zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество фигур: ");
        int size = scanner.nextInt();

        // Создаём массив, в который можно поместить как круги, так и прямоугольники
        Figure_zad1[] figures = new Figure_zad1[size];

        // Заполняем массив фигурами: по очереди круг и прямоугольник
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                figures[i] = new Circle_zad1(5.0); // создаём круг с радиусом 5
            } else {
                figures[i] = new Rectangle_zad1(4.0, 3.0); // создаём прямоугольник 4x3
            }
        }

        int circleCount = 0;
        int rectangleCount = 0;

        // Выводим площади и считаем, сколько каких фигур
        for (Figure_zad1 figure : figures) {
            if (figure instanceof Circle_zad1) {
                circleCount++;
            } else if (figure instanceof Rectangle_zad1) {
                rectangleCount++;
            }

            // Полиморфизм: у каждой фигуры вызывается "свой" метод area()
            System.out.println("Площадь фигуры: " + figure.area());
        }

        // Вывод количества кругов и прямоугольников
        System.out.println("Количество кругов: " + circleCount);
        System.out.println("Количество прямоугольников: " + rectangleCount);
    }
}