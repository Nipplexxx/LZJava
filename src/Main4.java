interface IFigure2 {
    double getArea();
}
class Apartment {
    private double area;
    public Apartment(double area) {
        this.area = area;
    }
    public double getArea() {
        return area;
    }
}
class Client2 {
    public void getArea(IFigure2 f) {
        System.out.println("Площадь квартиры: " + f.getArea());
    }
}
//использования анонимного класса для квартиры
public class Main4 {
    public static void main(String[] args) {
        Client2 client2 = new Client2();
        //создание анонимного класса, реализующего интерфейс IFigure2 для квартиры
        IFigure2 apartmentFigure = new IFigure2() {
            Apartment apartment = new Apartment(80.5);
            @Override
            public double getArea() {
                return apartment.getArea();
            }
        };
        //передача анонимного класса в метод getArea класса Client2
        client2.getArea(apartmentFigure);
    }
}