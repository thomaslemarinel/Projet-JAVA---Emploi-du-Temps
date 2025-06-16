package schedules.constraints;

import schedules.activities.*;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public abstract class BinaryConstraint implements Constraint{
    protected Activity activite1;
    protected Activity activite2;

    //Constructeur permettant d'initialiser les activites de la contrainte
    public BinaryConstraint(Activity activite1, Activity activite2){
        this.activite1 = activite1;
        this.activite2 = activite2;
    }

    public Activity getFirst(){
        return activite1;
    }

    public Activity getSecond(){
        return activite2;
    }

    //Methode abstraite pour verifier si la contrainte est satisfaite ou non
    public abstract boolean isSatisfied(int debut_activite1, int debut_activite2);

    //Methode qui rentourne l'ensemble des activites
    public Set<Activity> getActivities(){
        Set<Activity> ensemble_activites = new HashSet<>();
        ensemble_activites.add(activite1);
        ensemble_activites.add(activite2);
        return ensemble_activites;
    }

    public boolean isSatisfied(Map<Activity, Integer> couple_activites_dates){
        //On recupere les dates de debut des deux activites
        int debut_activite1 = couple_activites_dates.get(activite1);
        int debut_activite2 = couple_activites_dates.get(activite2);
        return isSatisfied(debut_activite1, debut_activite2);
    }
}

	
