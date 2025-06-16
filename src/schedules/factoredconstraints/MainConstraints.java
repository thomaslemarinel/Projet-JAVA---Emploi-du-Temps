package schedules.factoredconstraints;

import schedules.activities.*;

public class MainConstraints{
    
    public static void main(String[] args){
        
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
    }
}
