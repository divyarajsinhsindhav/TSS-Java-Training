import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        final String FILE_NAME = "test.txt";
        final String DIR_NAME = "test";

        File file = new File(DIR_NAME);

        if (file.exists()) {
            if (file.isFile()) {
                readFile(file);
            } else if (file.isDirectory()) {
                listDirectory(file);
            }
        } else {
            System.out.println("Doesn't exist");
        }
    }

    private static void readFile(File file) {
        try {
            Reader r = new FileReader(file);
            int data = r.read();
            while (data != -1) {
                System.out.print((char) data);
                data = r.read();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listDirectory(File file) {
        try {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    System.out.println("\n" + f.getName() + "(dir)");
                    listDirectory(f);
                } else {
                    System.out.println(f.getName() + "(file)");
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

