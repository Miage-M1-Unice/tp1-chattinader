package fr.unice.miage;

import java.util.*;
import java.io.File;
import java.io.FilenameFilter;

public class Main {
    // --------------------------------------------Lister--------------------------------------------------------------
    private void lister (String path) {
        File file = new File(path);

        if (file.isDirectory()){
            for (File files: file.listFiles()) {
                lister(files.getPath());
            }
        } else {
            System.out.println("[ " + file.getPath() + " ]");
        }
    }
// --------------------------------------------Lister Filtrer----------------------------------------------------------
    private void listerFilter (String path) {
        File f = new File(path);

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".java")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        if (f.isDirectory()) {
            for (File filess: f.listFiles()) {
                listerFilter(filess.getPath());
            }
        } else {
            if (textFilter.accept(f, f.getName())) {
                System.out.println("[ " + f.getPath() + " ]");
            }
        }
    }


// --------------------------------------------main--------------------------------------------------------------------
    public static void main (String[] args){
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println("Choisissez la méthode de recherche: ");
        System.out.println("1- List Files");
        System.out.println("2- List Files Filter Name");
        System.out.print("Votre choix: ");
        int choix = sc.nextInt();

        if (choix == 1) {
            m.lister("C:/Users/'Chatti Nader/Documents/M1/S2/Prog. Avancée");
        } else if (choix == 2) {
            m.listerFilter("C:/Users/'Chatti Nader/Documents/M1");
        }
    }
}
