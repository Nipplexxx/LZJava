package LZ_3_4_Zad2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileOperations_lz_2_4 {
    public static void main(String[] args) {
        try {
            // 1 СОЗДАЕМ 10 ФАЙЛОВ с названиями от 1.txt до 10.txt
            for (int i = 1; i <= 10; i++) {
                String fileName = i + ".txt"; // Пример: "1.txt"
                FileWriter writer = new FileWriter(fileName); // Открываем файл на запись

                // Получаем текущее время в формате "часы:минуты:секунды"
                String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());

                writer.write(currentTime); // Записываем текущее время в файл
                writer.close(); // Закрываем файл
            }

            // 2 УДАЛЯЕМ СЛУЧАЙНЫМ ОБРАЗОМ 3 ФАЙЛА из 10
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                int randomNumber = random.nextInt(10) + 1; // случайное число от 1 до 10
                File file = new File(randomNumber + ".txt");

                if (file.exists()) {
                    file.delete(); // Удаляем файл, если он существует
                }
            }

            // 3 СОЗДАЕМ ФАЙЛ all.txt и записываем туда информацию обо всех 10 файлах
            FileWriter allWriter = new FileWriter("all.txt");

            for (int i = 1; i <= 10; i++) {
                String fileName = i + ".txt";

                try {
                    // Пытаемся прочитать файл
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    String time = reader.readLine(); // Считываем первую строку (время)
                    reader.close();

                    // Записываем строку вида: hh:mm:ss – i.txt
                    allWriter.write(time + " - " + fileName + "\n");

                } catch (FileNotFoundException e) {
                    // Если файл не найден — пишем "Not Found – i.txt"
                    allWriter.write("Not Found - " + fileName + "\n");
                }
            }

            allWriter.close(); // Закрываем файл all.txt

        } catch (IOException e) {
            // Обработка любых ошибок ввода/вывода
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            // Этот блок выполняется ВСЕГДА — даже если произошла ошибка
            System.out.println("Операции с файлами завершены.");
        }
    }
}