package chap15;

import java.io.*;

public class HelloYou {

    public static void main(String[] args) {
        System.out.print("What's your name? ");

        /*
         * Set up so that we can do line-oriented character reads
         * from the standard input stream.
         */

        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String name = input.readLine();
            System.out.println("Hello, " + name + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}