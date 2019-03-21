package fr.unice.miage.TP2;

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {
    public void analyseClasse(String nomClasse) throws ClassNotFoundException {
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres
        System.out.println();
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
    }

    public void afficheAttributs(Class cl) {
        System.out.println("// Champs ");
    }

    public void afficheConstructeurs(Class cl) {
        System.out.println("// Constructeurs");
    }


    public void afficheMethodes(Class cl) {
        System.out.println("// Méthodes");
    }
}
