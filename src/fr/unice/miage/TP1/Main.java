package fr.unice.miage.TP1;

import java.util.*;
import java.io.File;
import java.io.FilenameFilter;

public class Main extends ListerFiltrerExterne {
    // --------------------------------------------Lister--------------------------------------------------------------
    private void lister (String path) {
        File file = new File(path);

        // Si c'est un dossier on récupère son path et on rappelle la méthode lister (récursivité)
        // Si non on affiche les fichiers trouvés
        if (file.isDirectory()){
            for (File files: file.listFiles()) {
                // Appel récursive de la méthode lister
                lister(files.getPath());
            }
        } else {
            // Affichege des fichiers trouvés
            System.out.println("[ " + file.getPath() + " ]");
        }
    }
// --------------------------------------------Lister Filtrer----------------------------------------------------------
    private void listerFilter (String path, String ext) {
        File f = new File(path);

        // Initialisation du filre (FilenameFilter)
        FilenameFilter textFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // Convertion des caractères en miniscule
                String lowercaseName = name.toLowerCase();
                // Retourne True si le nom du fichier se términe par la bonne extension
                // Retourne False si non
                if (lowercaseName.endsWith(ext)) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        // Si c'est un dossier on récupère son path et on rappelle la méthode listerFiltrer (récursivité)
        // Si non on affiche les fichiers filtrés par extension
        if (f.isDirectory()) {
            for (File filess: f.listFiles()) {
                // Appel récursif de la méthode listerFiltrer
                listerFilter(filess.getPath(), ext);
            }
        } else {
            // Affichage des fichiers qui ont la bonne extension
            if (textFilter.accept(f, f.getName())) {
                System.out.println("[ " + f.getPath() + " ]");
            }
        }
    }

// --------------------------------------------main--------------------------------------------------------------------
    public static void main (String[] args){
        // Initialisation
        Main m = new Main();
        ListerFiltrerExterne e = new ListerFiltrerExterne();
        Scanner scInt = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);

        // Choix de méthode de recherche
        System.out.println("Choisissez la méthode de recherche: ");
        System.out.println("1- List Files");
        System.out.println("2- List Files FilenameFilter");
        System.out.println("3- List Files FilenameFilter classe extèrne: ");
        System.out.println("4- List Files FilenameFilter classe anonyme: ");

        // Test sur le choix saisi
        int choix = 0;
        do {
            System.out.print("Votre choix: ");
            choix = scInt.nextInt();
        } while (choix <1  || choix > 4);

        // Appel de la méthode en fonction du choix saisi
        switch (choix) {
            case 1:
                m.lister(".");
                break;
            case 2: {
                // Initialisation de l'extension
                System.out.print("Extension des fichier à afficher (.txt, .java, ..): ");
                String ext = scString.nextLine();
                m.listerFilter(".", ext);
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
                System.out.print("Extension des fichier à afficher (.txt, .java, ..): ");
                String ext = scString.nextLine();
                ListerFiltrerExterne a = new ListerFiltrerExterne(){
                    public void listerAnonyme () {
                        ListerFiltrerExterne ea = new ListerFiltrerExterne();
                        ea.listerFiltrerExterne(".", ext);
                    }
                };
                ((ListerFiltrerExterne) a).listerAnonyme();
            }
        }
    }
}
