package common;

import controller.Program;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Files {

    public StringBuilder readFromFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String s = sc.nextLine();
                if (s.isBlank()) {
                    continue;
                }
                sb.append(s);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
        return sb;
    }

    public void writeToFile(String filename, StringBuilder s) {
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.append(s);
            pw.close();
        } catch (IOException e) {
            System.err.println("IO Exception!");
        }
    }
}
