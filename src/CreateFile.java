import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    private String fileName;
    public int fileSize;
    protected boolean isCreated;
    int filePermissions;

    public CreateFile(String fileName, int fileSize, int filePermissions) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePermissions = filePermissions;
    }

    public void createFile() {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                isCreated = true;
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    private void somePrivateMethod() {
        // Некоторая реализация
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("javac /Users/vladislavgavrilov/Documents/ВГТУ/Программирование/programmer/world/src/CreateFile.java");
            return;
        }

        String fileName = args[0];
        CreateFile fileCreator = new CreateFile(fileName, 1024, 755);
        fileCreator.createFile();
    }
}