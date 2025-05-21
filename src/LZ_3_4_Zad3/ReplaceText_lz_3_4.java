package LZ_3_4_Zad3;

import java.io.*;

public class ReplaceText_lz_3_4 {
    public static void main(String[] args) {
        // Имя файла, в котором будем искать и заменять текст
        String filePath = "sample.txt";

        // Что ищем и на что заменяем
        String searchString = "russia";
        String replacementString = "RUSSIA";

        try {
            // Шаг 1: Считываем весь файл в память
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");

            // Хранилище для всего содержимого файла
            StringBuilder content = new StringBuilder();

            String line;
            while ((line = file.readLine()) != null) {
                // Заменяем в строке все "russia" на "RUSSIA"
                content.append(line.replaceAll(searchString, replacementString)).append("\n");
            }

            // Шаг 2: Перезаписываем файл с самого начала
            file.setLength(0); // Очищаем файл
            file.seek(0);      // Ставим курсор в начало

            // Записываем обновлённое содержимое
            file.writeBytes(content.toString());

            file.close(); // Закрываем файл
            System.out.println("Замена выполнена успешно.");
        } catch (IOException e) {
            // Если произошла ошибка (например, файла нет), выводим сообщение
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}