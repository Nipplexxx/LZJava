import java.io.*;

public class ReplaceText {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        String searchString = "russia";
        String replacementString = "RUSSIA";

        try {
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            String line;
            while ((line = file.readLine()) != null) {
                String modifiedLine = line.replaceAll(searchString, replacementString);
                file.seek(file.getFilePointer() - line.length());
                file.writeBytes(modifiedLine); // Записываем измененную строку
            }
            file.close();
            System.out.println("Замена выполнена успешно.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}