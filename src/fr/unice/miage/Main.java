package fr.unice.miage;

import java.util.*;
import java.io.File;
import java.io.FilenameFilter;

public class Main {
    private void lister (String path) {
        File f = new File(path);

        if (f.isDirectory()){
            for (File file: f.listFiles()) {
                lister(file.getPath());
            }
        } else {
            System.out.println("[ " + f.getPath() + " ]");
        }
    }

    private void listerFilter (String path) {
        File f = new File(path);
        FilenameFilter fl = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".txt")){
                    return true;
                } else {
                    return false;
                }
            }
        };

        for (File afile: f.listFiles()) {
            for (String file : afile.list(fl)) {
                System.out.println("[ " + file + " ]");
            }
        }
    }

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
            m.listerFilter("C:/Users/'Chatti Nader/Documents/M1/S2");
        }
    }
}
