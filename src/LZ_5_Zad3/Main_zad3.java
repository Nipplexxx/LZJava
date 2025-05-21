package LZ_5_Zad3;

// Интерфейс фигуры — задаёт правило: у любой фигуры должен быть метод getArea()
interface IFigure_zad3 {
    double getArea(); // Метод, возвращающий площадь
}

// Класс "Квартира" — просто хранит значение площади и умеет его возвращать
class Apartment_zad3 {
    private double area; // Площадь квартиры

    public Apartment_zad3(double area) {
        this.area = area;
    }

    public double getArea() {
        return area; // Возвращаем сохранённую площадь
    }
}

// Класс "Клиент" — работает с любым объектом, реализующим интерфейс LZ_5_Zad3.IFigure_zad3
class Client_zad3 {
    public void getArea(IFigure_zad3 f) {
        // Выводит площадь, используя метод getArea интерфейса LZ_5_Zad3.IFigure_zad3
        System.out.println("Площадь квартиры: " + f.getArea());
    }
}

// Главный класс программы
public class Main_zad3 {
    public static void main(String[] args) {
        Client_zad3 clientZad3 = new Client_zad3(); // Создаём объект клиента

        // Создаём анонимный класс (то есть без имени), реализующий интерфейс LZ_5_Zad3.IFigure_zad3
        // Этот класс создаётся прямо на месте — не нужно писать отдельный "class"
        IFigure_zad3 apartmentFigure = new IFigure_zad3() {
            // Внутри анонимного класса создаём объект "Квартира" с площадью 80.5
            Apartment_zad3 apartment = new Apartment_zad3(80.5);

            @Override
            public double getArea() {
                // Вызываем метод getArea() у объекта квартиры
                return apartment.getArea();
            }
        };

        // Передаём анонимный класс в метод клиента
        clientZad3.getArea(apartmentFigure); // Клиент получит и выведет площадь
    }
}