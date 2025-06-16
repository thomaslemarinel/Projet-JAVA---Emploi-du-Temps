package schedules.basicconstraints;

import schedules.activities.*;

public class PrecedenceConstraint{
    protected Activity activite1;
    protected Activity activite2;

    //Constructeur de la classe PrecedenceConstraint 
    public PrecedenceConstraint(Activity activite1, Activity activite2){
        this.activite1 = activite1;
        this.activite2 = activite2;
    }

    public Activity getFirst(){
        return activite1;
    }

    public Activity getSecond(){
        return activite2;
    }

    //Permet d'indiquer si la contrainte est satisfaite ou non
    public boolean isSatisfied(int debut_activite1, int debut_activite2) {
        return debut_activite1 + activite1.getDuration() <= debut_activite2;
    }

    //Renvoie une representation sous forme de chaine de la contrainte de precedence
    public String toString(){
        return "" + activite1 + "->" + activite2;
    }
}

