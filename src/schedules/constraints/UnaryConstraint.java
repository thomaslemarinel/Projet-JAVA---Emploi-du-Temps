package schedules.constraints;

import schedules.activities.Activity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnaryConstraint implements Constraint{
    private Activity activite;
    private int date_min;
    private int date_max;

    //Constructeur initialisant l'activite et la plage de dates autorisees
    public UnaryConstraint(Activity activite, int date_min, int date_max) {
        this.activite = activite;
        this.date_min = date_min;
        this.date_max = date_max;
    }

    public Activity getActivity() {
        return this.activite;
    }

    public int getMinDate() {
        return this.date_min;
    }

    public int getMaxDate() {
        return this.date_max;
    }

    //Methode qui retourne l'ensemble des activites concernees par la contrainte
    public Set<Activity> getActivities() {
        Set<Activity> ensemble_activites = new HashSet<>();
        ensemble_activites.add(activite);
        return ensemble_activites;
    }

    //Methode qui permet de verifier si la contrainte est satisfaite ou non
    public boolean isSatisfied(Map<Activity, Integer> couple_activites_dates) {
        int date_activite = couple_activites_dates.get(activite);
        //On verifie si la date est comprise entre la date minimale et la date maximale autorisee
        return date_activite >= this.date_min && date_activite <= this.date_max;
    }
}