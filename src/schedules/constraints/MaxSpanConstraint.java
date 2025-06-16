package schedules.constraints;

import schedules.activities.Activity;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class MaxSpanConstraint implements Constraint{
    private Set<Activity> ensemble_activites;
    private int max_span; //Duree maximale autorisee pour l'ensemble d'activites

    //Constructeur initialisant l'ensemble d'activites et la duree maximale
    public MaxSpanConstraint(Set<Activity> ensemble_activites, int max_span){
        this.ensemble_activites = ensemble_activites;
        this.max_span = max_span; 
    }

    public Set<Activity> getActivities(){
        return ensemble_activites;
    }
    
    //Methode pour verifier si la contrainte de duree maximale est satisfaite
    public boolean isSatisfied(Map<Activity, Integer> couple_activites_dates){
        //On initialise des variables pour la date minimale et maximale
        int v_min = 10000; 
        int v_max = 0 ;
        if(couple_activites_dates.isEmpty()){
            return true ; 
        }
        for(Activity activite : this.ensemble_activites){
            int date = couple_activites_dates.get(activite);
            int duree_activite = date + activite.getDuration();
            //Mise à jour de la date minimale si la date actuelle est plus petite
            if(date < v_min ){
                v_min = date ;
            }
            //Mise à jour de la date maximale si la date de fin actuelle est plus grande
            if(duree_activite > v_max){
                v_max =  duree_activite;
            }
        }
        return (v_max - v_min) <= this.max_span;
    } 

}