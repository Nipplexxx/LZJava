import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileOperations {
    public static void main(String[] args) {
        try {
            // Создание 10 файлов с текущим временем в формате hh:mm:ss
            for (int i = 1; i <= 10; i++) {
                String fileName = i + ".txt";
                FileWriter fileWriter = new FileWriter(fileName);
                String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
                fileWriter.write(currentTime);
                fileWriter.close();
            }

            // Удаление случайным образом 3 файлов
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                int fileNumber = random.nextInt(10) + 1;
                File fileToDelete = new File(fileNumber + ".txt");
                if (fileToDelete.exists()) {
                    fileToDelete.delete();
                }
            }

            // Объединение содержимого оставшихся файлов в файл all.txt
            FileWriter allFileWriter = new FileWriter("all.txt");
            for (int i = 1; i <= 10; i++) {
                String fileName = i + ".txt";
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    String time = reader.readLine();
                    allFileWriter.write(time + " - " + fileName + "\n");
                    reader.close();
                } catch (FileNotFoundException e) {
                    allFileWriter.write("Not Found - " + fileName + "\n");
                }
            }
            allFileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("File operations completed.");
        }
    }
}