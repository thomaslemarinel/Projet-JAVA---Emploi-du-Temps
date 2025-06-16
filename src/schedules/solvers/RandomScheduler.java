package schedules.solvers;

import schedules.activities.*;
import schedules.constraints.*;
import java.util.Random ;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RandomScheduler{
    private Random objet_random; //On utilise un bjet Random pour generer des nombres aleatoires

    //Constructeur initialisant l'objet Random
    public RandomScheduler(Random objet_random){
        this.objet_random = objet_random;
    }

    public Random getObjetRandom(){
        return objet_random;
    }

    //Methode qui permet de generer un emploi du temps aleatoire pour un ensemble d'activites
    public Map<Activity, Integer> generateOneSchedule(Set<Activity> ensemble_activites, int date_minimale, int date_maximale){
        Map<Activity, Integer> emploi_du_temps = new HashMap<>();
        for (Activity activite : ensemble_activites){
            //Generation d'une date aleatoire entre date_minimale et date_maximale
            int debut_random = objet_random.nextInt(date_maximale - date_minimale + 1) + date_minimale;
            emploi_du_temps.put(activite , debut_random);
        }
        return emploi_du_temps;
    }

    //Methode qui permet de generer un emploi du temps qui satisfait le plus de contraintes possibles (parmi n (nombre_tirages) emploi du temps)
    public Map<Activity, Integer> generateSchedule(Set<Activity> ensemble_activites , Set<Constraint> ensemble_contraintes, int date_minimale , int date_maximale , int nombre_tirages){
        Verifier satisfaction_contraintes = new Verifier(ensemble_contraintes);
        //On initialise la variable qui va contenir l'emploi du temps final
        Map<Activity, Integer> emploi_du_temps =  new HashMap<>();
        //On repete la generation d'emploi du temps n fois (n -> nombre_tirages)
        for (int i = 0; i < nombre_tirages; i++){
            Map<Activity, Integer> un_emploi_du_temps = generateOneSchedule(ensemble_activites, date_minimale, date_maximale);
            //On verifie si l'emploi du temps aleatoire genere satisfait les contraintes
            Set<Constraint> contraintes_non_satisfaites = satisfaction_contraintes.unsatisfied(un_emploi_du_temps);
            //Si l'emploi du temps genere respecte plus de contraintes que l'emploi du temps resultat, alors on remplace le resultat
            if(contraintes_non_satisfaites.isEmpty()){
                emploi_du_temps = un_emploi_du_temps;
            }
        }
        //On retourne l'emploi du temps qui respecte le plus de contraintes
        return emploi_du_temps;
    }
}
