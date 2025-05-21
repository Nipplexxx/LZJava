package LZ_6;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

/*
 Первый поток, записывает текст и текущее время в файл `currentdata.txt`
*/
class FirstThread_lz6 extends Thread {
    private final File file = new File("currentdata.txt"); // основной файл для записи
    private volatile boolean running = true;               // переменная для остановки потока
    public static final Object LOCK = new Object();        // объект блокировки для синхронизации

    // Метод для остановки потока извне
    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            synchronized (LOCK) {
                try (FileOutputStream fos = new FileOutputStream(file, true)) {
                    // Текст, который будет записан в файл по одному символу
                    String text = "the first thread writes the time:";
                    for (char c : text.toCharArray()) {
                        fos.write(c);             // записываем один символ
                        Thread.sleep(200);        // ждём 200 мс
                    }

                    // Получаем текущее время
                    String time = Calendar.getInstance().getTime().toString();

                    fos.write(("\n" + time + "\n").getBytes()); // записываем текущее время
                    Thread.sleep(1000); // ждём 1 секунду
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace(); // если произошла ошибка, выводим её
                }
            }
        }
    }
}

/*
 Второй поток, проверяет размер файла и сохраняет его под другим именем, если он слишком большой
*/
class SecondThread_lz6 extends Thread {
    private final File file = new File("currentdata.txt"); // файл, который проверяем
    private volatile boolean running = true;

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(15000); // ждём 15 секунд

                synchronized (FirstThread_lz6.LOCK) {
                    if (file.length() > 200) {
                        // Генерируем уникальное имя файла по текущему времени
                        String timestamp = Calendar.getInstance().getTime().toString().replaceAll("[: ]", "_");
                        String newFileName = "backup_" + timestamp + ".txt";

                        File newFile = new File(newFileName);

                        // Копируем содержимое в новый файл
                        try (InputStream in = new FileInputStream(file);
                             OutputStream out = new FileOutputStream(newFile)) {
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = in.read(buffer)) > 0) {
                                out.write(buffer, 0, length);
                            }
                        }

                        // Очищаем оригинальный файл
                        try (FileOutputStream fos = new FileOutputStream(file)) {
                            // ничего не записываем — просто создаём пустой файл
                        }
                    }
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 Главный класс, запускает оба потока и ждёт команды пользователя на завершение программы
*/
public class Lines_lz6 {
    public static void main(String[] args) {
        // Создаём оба потока
        FirstThread_lz6 firstThread = new FirstThread_lz6();
        SecondThread_lz6 secondThread = new SecondThread_lz6();

        // Запускаем потоки
        firstThread.start();
        secondThread.start();

        // Ожидаем ввода пользователя для завершения
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 'q' и нажмите Enter для выхода.");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                // Останавливаем оба потока
                firstThread.stopThread();
                secondThread.stopThread();
                break;
            }
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }
}