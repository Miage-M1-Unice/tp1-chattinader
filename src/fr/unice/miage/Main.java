package fr.unice.miage;
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
            System.out.println("[" + f.getPath() + "]");
        }
    }

    public static void main (String[] args){
        Main m = new Main();
        m.lister("C:/Users/'Chatti Nader/Documents/M1/S2/Prog. Avancée");
    }
}
