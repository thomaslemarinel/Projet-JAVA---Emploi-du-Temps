package schedules.factoredconstraints;

import schedules.activities.*;

public class MeetConstraint extends BinaryConstraint{

    //Constructeur initialisant les deux activites concernees par la contrainte
    public MeetConstraint(Activity activite1, Activity activite2){
        super(activite1, activite2);
    }

    //Methode qui permet de verifier si la contrainte est satisfaite ou non
    public boolean isSatisfied(int debut_activite1, int debut_activite2){
        return debut_activite1 + activite1.getDuration() == debut_activite2;
    }
    
    public String toString() {
        return "{" + "activite1 = " + activite1 + ", activite2 = " + activite2 + '}';
    }

}
