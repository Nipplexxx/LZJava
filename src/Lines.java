import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

class FirstThread extends Thread {
    private File file = new File("currentdata.txt");
    private volatile boolean running = true;

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try (FileOutputStream fos = new FileOutputStream(file, true)) {
                String data = "the first thread writes the time:";
                for (char c : data.toCharArray()) {
                    fos.write(c);
                    Thread.sleep(200);
                }
                fos.write(Calendar.getInstance().getTime().toString().getBytes());
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SecondThread extends Thread {
    private File file = new File("currentdata.txt");
    private volatile boolean running = true;

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(15000);
                if (file.length() > 200) {
                    String newFileName = "data_" + Calendar.getInstance().getTimeInMillis() + ".txt";
                    File newFile = new File(newFileName);
                    file.renameTo(newFile);
                    file.createNewFile();
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Lines {
    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();
        firstThread.start();
        secondThread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Жми 'q'.");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("q")) {
                firstThread.stopThread();
                secondThread.stopThread();
                break;
            }
        }

        scanner.close();
    }
}