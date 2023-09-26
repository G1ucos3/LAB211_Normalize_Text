package controller;

import common.Files;
import common.Normalize;
import model.Text;


/**
 *
 * @author ASUS
 */
public class Program {
    Files files;
    Normalize normalize;
    Text text;
    
    public Program(){
        files = new Files();
        normalize = new Normalize();
        text = new Text();
    }
    
    public void run(){
        text.setText(files.readFromFile("input.txt"));
        normalize.normalize(text.getText());
        files.writeToFile("output.txt", text.getText());
        System.out.println("Normalize success!");
    }
}
