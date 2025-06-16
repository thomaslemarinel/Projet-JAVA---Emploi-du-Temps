package schedules.factoredconstraints;

import schedules.activities.*;

public abstract class BinaryConstraint{
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
}

	
