package fr.unice.miage.TP2;

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {
    public void analyseClasse(String nomClasse) throws ClassNotFoundException {
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres
        Class cl = getClasse(nomClasse);

        afficheEnTeteClasse(cl);

        System.out.println();
        afficheAttributs(cl);

        System.out.println();
        afficheConstructeurs(cl);

        System.out.println();
        afficheMethodes(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /** Retourne la classe dont le nom est passé en paramètre */
    public Class getClasse(String nomClasse) throws ClassNotFoundException {
        return Class.forName(nomClasse);
    }

    /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
    public void afficheEnTeteClasse(Class cl) {
        //  Affichage du modifier et du nom de la classe
        System.out.print(Modifier.toString(cl.getModifiers()) + " ");
        System.out.print(cl.getName() + " ");

        // Récupération de la superclasse si elle existe (null si cl est le type Object)
        // Class supercl = // CODE A ECRIRE
        if(cl.getSuperclass() != null && cl.getSuperclass().getName() != "java.lang.Object"){
            Class supercl = cl.getSuperclass();
            System.out.print("extends " + supercl.getName());
        }

        // Affichage des interfaces que la classe implemente
        if(cl.getInterfaces().length > 0){
            System.out.print("implements ");
            for(int i = 0; i < cl.getInterfaces().length; i++){
                System.out.print(cl.getInterfaces()[i]);
            }
        }

        // Enfin, l'accolade ouvrante !
        System.out.print(" {\n");
    }

    public void afficheAttributs(Class cl) {
        System.out.println("// Champs ");
        for(int i = 0; i < cl.getFields().length ; i++){
            System.out.println(cl.getFields()[i]);
        }
    }

    public void afficheConstructeurs(Class cl) {
        System.out.println("// Constructeurs");
        for(int i = 0; i < cl.getConstructors().length ; i++){
            System.out.println(cl.getConstructors()[i]);
        }
    }


    public void afficheMethodes(Class cl) {
        System.out.println("// Méthodes");
        for(int i = 0; i < cl.getDeclaredMethods().length ; i++){
            System.out.println(cl.getDeclaredMethods()[i]);
        }
    }

    public String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
