package fr.unice.miage.TP1;

import java.io.*;
import java.util.Scanner;

public class SeLit {
    public void lecture(Scanner source) {
        PrintStream fileStream;
        try {
            // Génération d'un fichier Output.txt qui contiendra le contenu du fichier lu
            fileStream = new PrintStream("Output.txt");
            System.setOut(fileStream);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while(source.hasNextLine()) {
            String s = source.nextLine();
            if (!s.trim().startsWith("//")) {
                System.out.println(s);
            }
        }
    }
}
