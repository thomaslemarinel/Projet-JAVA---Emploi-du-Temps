package schedules.constraints;

import schedules.activities.Activity;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

//Interface representant une contrainte pour les activites d'un emploi du temps
public interface Constraint{

    //Retourne l'ensemble des activites concernees par la contrainte
    Set<Activity> getActivities();

    //Retourne un booleen indiquant si la contrainte est satisfaite par ces dates
    boolean isSatisfied(Map<Activity, Integer> ensemble_activite_dates);

}