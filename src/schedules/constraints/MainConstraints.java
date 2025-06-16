package schedules.constraints;

import schedules.activities.*;
import schedules.solvers.*;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Map;



public class MainConstraints{
    
    public static void main(String[] args){
        
		//On cree des activites
        Activity activite1 = new Activity("Aller à l'Université", 15);
        Activity activite2 = new Activity("Attacher le vélo", 1);
        
        Activity activite3 = new Activity("Aller au RU", 5);
        Activity activite4 = new Activity("Choisir son repas", 10);

		//Exemple d'utilisation de PrecedenceConstraint
        PrecedenceConstraint constraint1 = new PrecedenceConstraint(activite1, activite2);

        System.out.println(constraint1.isSatisfied(500, 515));
        System.out.println(constraint1.isSatisfied(500, 13));
        System.out.println(constraint1.isSatisfied(500, 518));

		//Exemple d'utilisation de MeetConstraint
        MeetConstraint constraint2 = new MeetConstraint(activite3, activite4);

        System.out.println(constraint2.isSatisfied(500, 515));
        System.out.println(constraint2.isSatisfied(500, 210));
        System.out.println(constraint2.isSatisfied(150, 157));

        Activity activite5 = new Activity("Mettre ses chaussettes", 2);
        Activity activite6 = new Activity("Mettre ses chaussures", 5);
        
		//Exemple d'utilisation de PrecedenceConstraintWithGap
        PrecedenceConstraintWithGap constraint3 = new PrecedenceConstraintWithGap(activite5, activite6, 2, 4);

        System.out.println(constraint3.isSatisfied(0, 10));
        System.out.println(constraint3.isSatisfied(6, 10));
        
		//On cree un ensemble de contraintes
        Set<Constraint> constraints = new HashSet<>();

    	// Contrainte : activite1 doit se terminer avant qu’activite2 ne commence
    	constraints.add(new PrecedenceConstraint(activite1, activite2));

    	// Contrainte : activite4 doit commencer exactement quand activite3 se termine
    	constraints.add(new MeetConstraint(activite3, activite4));

    	// Contrainte : activite1, activite2 et activite3 doivent toutes
    	// prendre place en au plus 90 minutes
    	Set<Activity> activities = new HashSet<> ();
    	activities.add(activite1);
    	activities.add(activite2);
    	activities.add(activite3);
    	MaxSpanConstraint spanConstraint = new MaxSpanConstraint(activities, 90);
    	constraints.add(spanConstraint);

    	Verifier verifier = new Verifier(constraints);

		//On cree un emploi du temps (schedule)
    	Map<Activity, Integer> schedule = new HashMap<Activity, Integer> ();

		//On remplit l'emploi du temps avec des dates pour chaque activite
		schedule.put(activite1, 0);
		schedule.put(activite2, 5);
		schedule.put(activite3, 20);
		schedule.put(activite4, 30);

		//Verification de la satisfaction des contraintes pour l'emploi du temps
    	System.out.println("L’emploi du temps satisfait-il toutes les contraintes ? ");
    	Set<Constraint> unsatisfied = verifier.unsatisfied(schedule);
    	if (unsatisfied.isEmpty()){
        	System.out.println("Oui");
    	}
    	else{
        	System.out.println("Non, les contraintes suivantes sont non satisfaites.");
    	}
    }
}
