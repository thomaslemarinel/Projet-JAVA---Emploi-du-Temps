package schedules.factoredtopologicalsort;

import schedules.activities.*;
import schedules.factoredconstraints.*;
import schedules.factoredtopologicalsort.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class MainTopologicalSorter {

    public static void main(String[] args) {
        Activity activite1 = new Activity("Se lever", 5);
        Activity activite2 = new Activity("Prendre un petit déjeuner", 10);
        Activity activite3 = new Activity("Sortir sa carte de Tramway", 1);
        Activity activite4 = new Activity("Voyage en Tramway", 20);

        HashSet<Activity> activities = new HashSet<Activity>();
        activities.add(activite1);
        activities.add(activite2);
        activities.add(activite3);
        activities.add(activite4);

    //On ajoute les contraintes de precedences à l'ensemble des contraintes (constraints)
        HashSet<PrecedenceConstraint> constraints = new HashSet<PrecedenceConstraint>();
        constraints.add(new PrecedenceConstraint(activite1, activite2));
        constraints.add(new PrecedenceConstraint(activite1, activite3));
        constraints.add(new PrecedenceConstraint(activite1, activite4));
        constraints.add(new PrecedenceConstraint(activite2, activite3));
        constraints.add(new PrecedenceConstraint(activite2, activite4));
        constraints.add(new PrecedenceConstraint(activite3, activite4));

        //Exemple d'utilisation de la methode bruteForceSort
        TopologicalSorter tri1 = new TopologicalSorter();
        ArrayList<Activity> liste1 = tri1.bruteForceSort(activities, constraints);
        System.out.println(liste1);

        //Exemple d'utilisation de la methode schedule (Tri topologique)
        TopologicalSorter tri2 = new TopologicalSorter();
        HashMap<Activity, Integer> liste2 = tri2.schedule(activities, constraints, 25);
        System.out.println(liste2);

        int nombre_activites = 2000;
        HashSet<Activity> ensemble_activites = new HashSet<>();
        HashSet<PrecedenceConstraint> ensemble_contraintes = new HashSet<>();

        for (int i = 0; i < nombre_activites; i++) {
            Activity activite = new Activity("Activité " + i, 5);  
            ensemble_activites.add(activite);

            // Ajouter des contraintes de précédence pour que l'activité i précède i + 1
            if (i < nombre_activites - 1) {
                ensemble_contraintes.add(new PrecedenceConstraint(activite, new Activity("Activité " + (i + 1), 5)));
            }
        }

        TopologicalSorter tri_ensemble = new TopologicalSorter();

        // Effectuer un tri topologique en utilisant l'approche par force brute
        ArrayList<Activity> liste_grand_ensemble = tri_ensemble.bruteForceSort(ensemble_activites, ensemble_contraintes);
        //System.out.println("Tri par force brute pour le grand ensemble : " + liste_grand_ensemble);

        // Effectuer la planification en fonction du tri topologique
        HashMap<Activity, Integer> emploi_du_temps = tri_ensemble.schedule(ensemble_activites, ensemble_contraintes, 25);
        //System.out.println("Emploi du temps pour le grand ensemble : " + emploi_du_temps);

        // Effectuer un tri topologique linéaire avec quelques activités et contraintes
        TopologicalSorter tri_lineaire = new TopologicalSorter();

        HashSet<Activity> ensemble_activites_lineaires = new HashSet<>();
        HashSet<PrecedenceConstraint> ensembles_contraintes_lineaires = new HashSet<>();

        Activity activite_lineaire1 = new Activity("Tâche A", 8);
        Activity activite_lineaire2 = new Activity("Tâche B", 5);
        Activity activite_lineaire3 = new Activity("Tâche C", 10);

        //On ajoute les activites à l'ensemble d'activites
        ensemble_activites_lineaires.add(activite_lineaire1);
        ensemble_activites_lineaires.add(activite_lineaire2);
        ensemble_activites_lineaires.add(activite_lineaire3);

        //On ajoute les contraintes à l'ensemble de contraintes
        ensembles_contraintes_lineaires.add(new PrecedenceConstraint(activite_lineaire1, activite_lineaire2));
        ensembles_contraintes_lineaires.add(new PrecedenceConstraint(activite_lineaire2, activite_lineaire3));

        ArrayList<Activity> liste_activites_triees = tri_lineaire.linearTimeSort(ensemble_activites_lineaires, ensembles_contraintes_lineaires);
        System.out.println("Tri topologique linéaire pour quelques activités : " + liste_activites_triees);

    }
}
