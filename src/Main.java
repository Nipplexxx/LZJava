public class Main {
    public static void main(String[] args) {
        System.out.println("Hi!");

        //Circle конструктора без параметров
        Circle circle1 = new Circle();
        double area1 = circle1.getArea();
        System.out.println("Площадь круга 1: " + area1);

        //Circle конструктора с параметрами
        Circle circle2 = new Circle(3, 4, 6);
        double area2 = circle2.getArea();
        System.out.println("Площадь круга 2: " + area2);
    }
}