package fr.unice.miage.TP2;

import java.lang.reflect.*;
import java.io.*;

public class Main {
    public static void main (String[] args) {
        AnalyseurDeClasse ac = new AnalyseurDeClasse();
        boolean ok = false;

        while (!ok) {
            try {
                System.out.print("Entrez le nom d'une classe (ex : java.util.Scanner): ");
                String nomClasse = ac.litChaineAuClavier();

                ac.analyseClasse(nomClasse);

                ok = true;
            } catch (ClassNotFoundException e) {
                System.out.println("Classe non trouvée.");
            } catch (IOException e) {
                System.out.println("Erreur d'E/S!");
            }
        }
    }
}
