package chap15;

import java.io.*;

public class FileReadWrite {

    private static void readUTF8(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
            try {
                OutputStreamWriter writer = new OutputStreamWriter(System.out, "UTF-8");
                int ch;
                while ((ch = reader.read()) != -1) {
                    writer.write(ch);
                }
                writer.flush();
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("No such file exists: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Cannot read file: "
                    + file.getAbsolutePath() + ": " + e.getMessage());
        }
    }

    public static void main(String... args) {
        readUTF8(new File("/tmp/test.txt"));
    }
}
