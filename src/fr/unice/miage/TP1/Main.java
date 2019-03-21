package fr.unice.miage.TP1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    // --------------------------------------------main--------------------------------------------------------------------
    public static void main (String[] args) throws FileNotFoundException {
        // Initialisation
        Lister l = new Lister();
        ListerFiltrerExterne e = new ListerFiltrerExterne();
        SeLit s = new SeLit();
        Scanner scInt = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);

        // Choix de méthode de recherche
        System.out.println("Choisissez la méthode que vous voulez utiliser: ");
        System.out.println("1- List Files");
        System.out.println("2- List Files FilenameFilter");
        System.out.println("3- List Files FilenameFilter classe extèrne");
        System.out.println("4- List Files FilenameFilter classe anonyme");
        System.out.println("5- Se Lit");

        // Test sur le choix saisi
        int choix = 0;
        do {
            System.out.print("Votre choix: ");
            choix = scInt.nextInt();
        } while (choix <1  || choix > 5);

        // Appel de la méthode en fonction du choix saisi
        switch (choix) {
            case 1:
                l.lister(".");
                break;
            case 2: {
                // Initialisation de l'extension
                System.out.print("Extension des fichier à afficher (.txt, .java, ..): ");
                String ext = scString.nextLine();
                l.listerFilter(".", ext);
                break;
            }
            case 3:{
                // Initialisation de l'extension
                System.out.print("Extension des fichier à afficher (.txt, .java, ..): ");
                String ext = scString.nextLine();
                e.listerFiltrerExterne(".", ext);
                break;
            }
            case 4: {
                // Initialisation de l'extension
                System.out.print("Extension des fichier à afficher (.txt, .java, ..): ");
                String ext = scString.nextLine();
                // class anonyme qui appelle la méthode listerFiltrerExterne de la classe ListerFiltrerExterne
                ListerFiltrerExterne a = new ListerFiltrerExterne(){
                    public void listerAnonyme () {
                        ListerFiltrerExterne ea = new ListerFiltrerExterne();
                        ea.listerFiltrerExterne(".", ext);
                    }
                };
                ((ListerFiltrerExterne) a).listerAnonyme();
            }
            case 5: {
                // Initialisation du ficher à lire
                System.out.print("Tapez le nom du fichier: ");
                String name = scString.nextLine();
                // Initialisation du path du fichier à lire
                FileInputStream in = new FileInputStream(new File("src/fr/unice/miage/TP1/" + name));
                Scanner sc = new Scanner(in);
                System.out.println("Lu: <" + name + "> - Contenu transféré vers le fichier output.txt");
                s.lecture(sc);
            }
        }
    }
}
