public class Main_lz_1_2 {
    public static void main(String[] args) {
        System.out.println("Программа для расчёта площади круга двумя способами\n");

        // Создание объекта через ввод данных с клавиатуры
        // Пользователь сам вводит координаты центра и диаметр
        Circle_lz_1_2 circleFromInput = new Circle_lz_1_2();
        double area1 = circleFromInput.getArea();
        System.out.println("Площадь круга (введённая вручную): " + area1);

        System.out.println(); // Пустая строка для читаемости в терминале

        // Создание объекта с заранее заданными координатами и диаметром
        // Здесь координаты (3, 4), диаметр — 6
        Circle_lz_1_2 circleFromParams = new Circle_lz_1_2(3, 4, 6);
        double area2 = circleFromParams.getArea();
        System.out.println("Площадь круга (задана в коде): " + area2);
    }
}