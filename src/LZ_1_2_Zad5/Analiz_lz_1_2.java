package LZ_1_2_Zad5;

public class Analiz_lz_1_2 {

    // Класс-родитель
    static class Insect {
        int i = 9; // Переменная i сразу инициализируется значением 9
        int j;     // Переменная j пока не инициализирована (по умолчанию 0)

        // Конструктор класса Insect
        Insect() {
            prt("i = " + i + ", j = " + j); // Вывод текущих значений переменных
            j = 39; // Присваиваем j новое значение
        }

        // Статическая переменная, инициализируется при первой загрузке класса Insect
        static int x1 = prt("static Insect.x1 initialized");

        // Метод для вывода строки и возврата значения (используется в статической инициализации)
        static int prt(String s) {
            System.out.println(s);
            return 47; // Просто возвращаем 47, но это значение нигде не используется
        }
    }

    // Класс-наследник
    static class Beetle extends Insect {
        int k = prt("Beetle.k initialized"); // Переменная k инициализируется сразу с выводом

        // Конструктор класса Beetle
        Beetle() {
            prt("k = " + k); // Показываем значение k
            prt("j = " + j); // Показываем значение j (унаследовано от Insect)
        }

        // Статическая переменная класса Beetle, инициализируется при первой загрузке этого класса
        static int x2 = prt("static Beetle.x2 initialized");
    }

    // Главный метод программы
    public static void main(String[] args) {
        prt("Beetle constructor"); // Первая строчка, которая выводится в консоль

        // Создание объекта Beetle, тут запускается вся магия
        Beetle b = new Beetle();
    }

    // Метод для вывода строки (аналогичен тому, что в классе Insect)
    static void prt(String s) {
        System.out.println(s);
    }
}