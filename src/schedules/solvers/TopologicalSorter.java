package schedules.solvers;

import schedules.activities.*;
import schedules.constraints.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopologicalSorter{

    //Constructeur de la classe TopologicalSorter
    public TopologicalSorter(){
        
    }

    //Methode qui effectue un tri topologique par force brute (le moins efficace niveau optimisation)
    public List<Activity> bruteForceSort(Set<Activity> ensemble_activites, Set<PrecedenceConstraint> ensemble_contraintes){
        //Cree une copie de l'ensemble des activites pour ne pas modifier l'original
        Set<Activity> copie_ensemble_activites = new HashSet<Activity>(ensemble_activites);
        List<Activity> resultat = new ArrayList<Activity>();
        while (!copie_ensemble_activites.isEmpty()){
            //System.out.println("resultat = " + resultat);
            //On cherche si une activite est disponible
            Activity objet = objetDisponible(copie_ensemble_activites, resultat, ensemble_contraintes);
            if (objet == null){
                System.out.println("Pas de solution");
                return null;
            }
            else{
                //On ajoute l'activite à la liste "resultat" et on retire l'activite de l'ensemble
                resultat.add(objet);
                copie_ensemble_activites.remove(objet);
            }
        }
        //On retourne la liste triee
        return resultat;

    }

    // Algorithme auxiliaire pour chercher un objet disponible
    public Activity objetDisponible(Set<Activity> ensemble_activites, List<Activity> resultat, Set<PrecedenceConstraint> ensemble_contraintes){
        for (Activity activite : ensemble_activites){
            boolean ok = true;
            //System.out.println("activite = " + activite);
            //On verifie si l'activite est disponible en respectant les contraintes de precedence
            for (PrecedenceConstraint contrainte : ensemble_contraintes){
                Activity o1 = contrainte.getFirst();
                Activity o2 = contrainte.getSecond();
                //System.out.println("contrainte = " + contrainte);
                if (o2.equals(activite) && !resultat.contains(o1)){
                    ok = false;
                    //System.out.println("Echec");
                    break;
                }
            }
            if (ok == true){
                //System.out.println("L'activite " + activite + "est disponible");
                return activite;
            }
        }
        return null;
    }

    //Methode qui genere un emploi du temps en respectant les contraintes de precedence
    public Map<Activity, Integer> schedule(Set<Activity> ensemble_activites, Set<PrecedenceConstraint> ensemble_contraintes, int date_depart){
        Map<Activity, Integer> emploi_temps = new HashMap<>();
        //On effectue un tri topologique par force brute
        List<Activity> activites_triees = bruteForceSort(ensemble_activites, ensemble_contraintes);
        if (activites_triees == null){
            return null;
        }
        int temps_actuel = date_depart;
        //On remplit l'emploi du temps en respectant la duree de chaque activite
        for (int i = 0 ; i < activites_triees.size() ; i++){
            emploi_temps.put(activites_triees.get(i), temps_actuel);
            temps_actuel += (activites_triees.get(i)).getDuration() ; 
        }
        return emploi_temps;
    }

    //Methode qui effectue un tri topologique en temps lineaire
    public List<Activity> linearTimeSort(Set<Activity> dico_activites, Set<PrecedenceConstraint> dico_contraintes){
        //On definit un HashMap pour stocker le nombre de predecesseurs de chaque activite
        Map<Activity, Integer> nb_predecesseurs = new HashMap<Activity, Integer>();
        //On definit un HashMap pour stocker la liste des successeurs de chaque activite
        Map<Activity, ArrayList<Activity>> successeurs = new HashMap<Activity, ArrayList<Activity>>();
        //On initialise les structures de donnees (Map) avec les activites
        for(Activity activite : dico_activites){
            nb_predecesseurs.put(activite, 0);
            successeurs.put(activite, new ArrayList<Activity>());
        }
        //On remplit les structures de donnees (HashMap) avec les contraintes de precedence
        for(PrecedenceConstraint contrainte : dico_contraintes){
            nb_predecesseurs.put(contrainte.getSecond(), nb_predecesseurs.get(contrainte.getSecond()) + 1);
            successeurs.get(contrainte.getFirst()).add(contrainte.getSecond());
        }
        //On instancie une liste pour stocker le resultat du tri topologique
        List<Activity> liste = new ArrayList<Activity>();
        //On instancie une liste (resultat) pour stocker le resultat final
        List<Activity> resultat = new ArrayList<Activity>();
        //On ajoute les activites sans predecesseurs à la liste
        for(Activity activite : dico_activites){
            if(nb_predecesseurs.get(activite) == 0){
                liste.add(activite);
            }
        }
        //On effectue le tri topologique en temps lineaire
        while(!liste.isEmpty()){
            Activity activite1 = liste.get(0);
            resultat.add(activite1);
            liste.remove(activite1);
            //On met à jour le nombre de predecesseurs des successeurs de l'activite actuelle
            for (Activity activite2 : successeurs.get(activite1)){
                nb_predecesseurs.put(activite2, nb_predecesseurs.get(activite2) - 1);
                //Si le predecesseur n'a plus de predecesseurs, on l'ajoute à la liste
                if(nb_predecesseurs.get(activite2) == 0){
                    liste.add(activite2);
                }
            }
        }
        //On verifie si toutes les activites ont ete triees
        if(resultat.size() == dico_activites.size()){
            //On retourne la liste triee
            return resultat;
        }
        else{
            //On retourne null si il n'y a pas de solutions
            return null;
        }
    }
}
