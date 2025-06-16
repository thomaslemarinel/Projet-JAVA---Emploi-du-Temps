package schedules.factoredconstraints;

import schedules.activities.*;
import schedules.basictopologicalsort.*;

//Classe representant une contrainte de precedence entre deux activites avec une plage de delai
public class PrecedenceConstraintWithGap extends PrecedenceConstraint{
    protected int delai_min; //Delai minimal autorise
    protected int delai_max; //Delai maximal autorise

    public PrecedenceConstraintWithGap(Activity activite1, Activity activite2, int delai_min, int delai_max){
        super(activite1, activite2); //La classe herite de PrecedenceConstraint
        this.delai_min = delai_min;
        this.delai_max = delai_max;
    }

    public int getMinDelay(){
        return delai_min;
    }

    public int getMaxDelay(){
        return delai_max;
    }

    //Methode pour verifier si la contrainte de precedence avec plage de delai est satisfaite
    public boolean isSatisfied(int debut_activite1, int debut_activite2){
        return (debut_activite1 + activite1.getDuration() <= debut_activite2) && (debut_activite1 + activite1.getDuration() + delai_min <= debut_activite2) && (debut_activite1 + activite1.getDuration() + delai_max >= debut_activite2);
    }
}
