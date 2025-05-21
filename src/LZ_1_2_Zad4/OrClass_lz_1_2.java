package LZ_1_2_Zad4;

import java.util.Date;

public class OrClass_lz_1_2 {
    public static void main(String[] args) {
        int operations = 10000; // Количество операций склеивания строк

        // ---------- String ----------
        // String — обычная строка, но она неизменяемая.
        // Каждая операция += создает новую строку, это медленно.
        String str = "";
        Date start = new Date(); // Время начала
        for (int i = 0; i < operations; i++) {
            str += "a"; // Склеиваем строку 10 000 раз
        }
        Date end = new Date(); // Время окончания
        long stringTime = end.getTime() - start.getTime(); // Вычисляем время выполнения
        System.out.println("Время работы String: " + stringTime + " мс");

        // ---------- StringBuffer ----------
        // StringBuffer — изменяемая строка. Работает быстрее, чем String.
        // Подходит для многопоточной работы (если несколько потоков работают с одной строкой).
        StringBuffer stringBuffer = new StringBuffer();
        start = new Date();
        for (int i = 0; i < operations; i++) {
            stringBuffer.append("a"); // Добавляем символ к строке
        }
        end = new Date();
        long stringBufferTime = end.getTime() - start.getTime();
        System.out.println("Время работы StringBuffer: " + stringBufferTime + " мс");

        // ---------- StringBuilder ----------
        // StringBuilder — самый быстрый способ. Работает как StringBuffer,
        // но не подходит для многопоточности. В одиночной программе — идеальный выбор.
        StringBuilder stringBuilder = new StringBuilder();
        start = new Date();
        for (int i = 0; i < operations; i++) {
            stringBuilder.append("a"); // Добавляем символ к строке
        }
        end = new Date();
        long stringBuilderTime = end.getTime() - start.getTime();
        System.out.println("Время работы StringBuilder: " + stringBuilderTime + " мс");
    }
}