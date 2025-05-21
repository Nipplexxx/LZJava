package LZ_3_4_Zad1;

import java.io.File;
import java.io.IOException;

/*
 Класс LZ_3_4_Zad1.CreateFile_lz_2_4 предназначен для создания файла по указанному пути.
 Подходит для генерации JavaDoc.
*/
public class CreateFile_lz_2_4 {

    // Приватное поле - имя файла
    private String fileName;

    // Публичное поле - размер файла (в условных единицах)
    public int fileSize;

    // Защищённое поле - указывает, был ли создан файл
    protected boolean isCreated;

    // Поле без модификатора - доступно только в пределах пакета
    int filePermissions;

    /*
     Конструктор класса.
     fileName путь и имя файла
     fileSize размер файла
     filePermissions условные "права доступа"
     */
    public CreateFile_lz_2_4(String fileName, int fileSize, int filePermissions) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePermissions = filePermissions;
    }

    /*
     Метод создает файл по указанному пути.
     Выводит сообщение о результате создания.
     */
    public void createFile() {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                isCreated = true; // Сохраняем информацию об успешном создании
                System.out.println("Файл создан: " + file.getName());
            } else {
                System.out.println("Файл уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла.");
            e.printStackTrace(); // Печатаем информацию об ошибке
        }
    }

    /*
     Приватный метод (не попадёт в документацию javadoc, если не использовать ключ `-private`)
     Демонстрирует, как метод может быть скрыт от внешнего доступа.
     @return всегда возвращает true
     */
    private boolean somePrivateMethod() {
        return true;
    }

    /*
     Главный метод программы.
     @param args первый элемент массива должен содержать путь к файлу, например: c:/newfile.txt
     */
    public static void main(String[] args) {
        // Проверяем, передан ли аргумент командной строки
        if (args.length < 1) {
            System.out.println("Запуск: java LZ_3_4_Zad1.CreateFile_lz_2_4 c:/newfile.txt");
            return;
        }

        String fileName = args[0]; // Получаем имя файла из аргумента
        // Создаём объект класса LZ_3_4_Zad1.CreateFile_lz_2_4 с параметрами
        CreateFile_lz_2_4 fileCreator = new CreateFile_lz_2_4(fileName, 1024, 755);
        fileCreator.createFile(); // Пытаемся создать файл
    }
}