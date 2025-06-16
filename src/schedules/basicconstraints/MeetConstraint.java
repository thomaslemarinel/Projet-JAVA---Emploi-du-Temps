package schedules.basicconstraints;
import schedules.activities.*;

public class MeetConstraint{
    private Activity activite1;
    private Activity activite2;

    //Constructeur de la classe MeetConstraint 
    public MeetConstraint(Activity activite1, Activity activite2){
        this.activite1 = activite1;
        this.activite2 = activite2;
    }

    public Activity getFirst(){
        return activite1;
    }

    public Activity getSecond(){
        return activite2;
    }

    //Methode qui permet de verifier si la contrainte est satisfaite ou non
    public boolean isSatisfied(int debut_activite1, int debut_activite2){
        return debut_activite1 + activite1.getDuration() == debut_activite2;
    }
    
    public String toString() {
        return "{" + "activite1 = " + activite1 + ", activite2 = " + activite2 + '}';
    }

}
