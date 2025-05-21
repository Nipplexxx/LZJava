package LZ_5_Zad2;

// Интерфейс "Фигура". Любая фигура должна уметь возвращать свою площадь.
interface IFigure_zad2 {
    double getArea(); // Метод для получения площади
}

// Класс "Круг", реализует интерфейс IFigure
class Circle_zad2 implements IFigure_zad2 {
    private double radius;

    public Circle_zad2(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        // Площадь круга: π * r²
        return Math.PI * radius * radius;
    }
}

// Класс "Прямоугольник", тоже реализует IFigure
class Rectangle_zad2 implements IFigure_zad2 {
    private double width;
    private double height;

    public Rectangle_zad2(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        // Площадь прямоугольника: ширина * высота
        return width * height;
    }
}

// Класс "Стол". Он не реализует IFigure, но имеет метод расчёта площади.
class Table_zad2 {
    private double length;
    private double width;

    public Table_zad2(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Метод расчёта площади стола
    public double calculateArea() {
        return length * width;
    }
}

// Адаптер: делает так, будто Table_zad2 реализует интерфейс IFigure
class TableAdapter_zad2 implements IFigure_zad2 {
    private Table_zad2 tableZad2;

    // Передаём объект "стола", который будем адаптировать
    public TableAdapter_zad2(Table_zad2 tableZad2) {
        this.tableZad2 = tableZad2;
    }

    // Теперь мы можем использовать calculateArea как getArea
    @Override
    public double getArea() {
        return tableZad2.calculateArea();
    }
}

// Класс "Клиент", который работает с фигурами через интерфейс IFigure
class Client_zad2 {
    public void getArea(IFigure_zad2 f) {
        // Выводит площадь фигуры
        System.out.println("Площадь: " + f.getArea());
    }
}

// Главный класс программы
public class Main_zad2 {
    public static void main(String[] args) {
        // Создаём фигуры: круг, прямоугольник и стол
        Circle_zad2 circleZad2 = new Circle_zad2(5);            // Радиус 5
        Rectangle_zad2 rectangleZad2 = new Rectangle_zad2(3, 4); // 3x4
        Table_zad2 tableZad2 = new Table_zad2(6, 8);             // 6x8

        // Создаём клиента, который умеет работать с интерфейсом IFigure
        Client_zad2 clientZad2 = new Client_zad2();

        // Передаём круг и прямоугольник — они уже реализуют IFigure
        clientZad2.getArea(circleZad2);
        clientZad2.getArea(rectangleZad2);

        // Стол не реализует IFigure напрямую, поэтому используем адаптер
        TableAdapter_zad2 tableAdapterZad2 = new TableAdapter_zad2(tableZad2);
        clientZad2.getArea(tableAdapterZad2); // Теперь клиент может работать и с "столом"
    }
}