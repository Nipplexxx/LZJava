// Интерфейс фигуры
interface IFigure {
    double getArea();
}
class Circle3 implements IFigure {
    private double radius;
    public Circle3(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
class Rectangle3 implements IFigure {
    private double width;
    private double height;
    public Rectangle3(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea() {
        return width * height;
    }
}
class Table {
    private double length;
    private double width;

    public Table(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}
class TableAdapter implements IFigure {
    private Table table;

    public TableAdapter(Table table) {
        this.table = table;
    }

    @Override
    public double getArea() {
        return table.calculateArea();
    }
}
class Client {
    public void getArea(IFigure f) {
        System.out.println("Площадь стола: " + f.getArea());
    }
}
public class Main3 {
    public static void main(String[] args) {
        Circle3 circle3 = new Circle3(5);
        Rectangle3 rectangle3 = new Rectangle3(3, 4);
        Table table = new Table(6, 8);

        Client client = new Client();
        client.getArea(circle3);
        client.getArea(rectangle3);

        TableAdapter tableAdapter = new TableAdapter(table);
        client.getArea(tableAdapter);
    }
}