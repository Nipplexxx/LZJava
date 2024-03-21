import java.util.Date;

public class OrClass {
        public static void main(String[] args) {
            int sumochka = 10000;
            String str = "";
            StringBuilder stringBuffer = new StringBuilder();
            StringBuilder stringBuilder = new StringBuilder();

            Date start = new Date();
            for (int i = 0; i < sumochka; i++) {
                str += "a";
            }
            Date end = new Date();
            long stringTime = end.getTime() - start.getTime();
            System.out.println("Время stringTime: " + stringTime + "ms");

            start = new Date();
            for (int i = 0; i < sumochka; i++) {
                stringBuffer.append("a");
            }
            end = new Date();
            long stringBufferTime = end.getTime() - start.getTime();
            System.out.println("Время stringBufferTime: " + stringBufferTime + "ms");

            start = new Date();
            for (int i = 0; i < sumochka; i++) {
                stringBuilder.append("a");
            }
            end = new Date();
            long stringBuilderTime = end.getTime() - start.getTime();
            System.out.println("Время stringBuilderTime: " + stringBuilderTime + "ms");
    }
}
