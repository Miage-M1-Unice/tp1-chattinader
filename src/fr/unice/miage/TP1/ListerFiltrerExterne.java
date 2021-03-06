package fr.unice.miage.TP1;

import java.io.File;
import java.io.FilenameFilter;

public class ListerFiltrerExterne {
    public void listerFiltrerExterne (String path, String ext) {
        File f = new File(path);

        // Initialisation du filre (FilenameFilter)
        FilenameFilter textFilter;
        textFilter = new FilenameFilter() {
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
                listerFiltrerExterne(filess.getPath(), ext);
            }
        } else {
            // Affichage des fichiers qui ont la bonne extension
            if (textFilter.accept(f, f.getName())) {
                System.out.println("[ " + f.getPath() + " ]");
            }
        }
    }

    protected void listerAnonyme() {
    }
}
