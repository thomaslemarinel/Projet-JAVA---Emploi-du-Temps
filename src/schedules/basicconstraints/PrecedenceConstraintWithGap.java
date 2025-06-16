package schedules.basicconstraints;

import schedules.activities.*;
import schedules.basictopologicalsort.*;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint{
    protected int delai_min;
    protected int delai_max;

    //Constructeur de la classe PrecedenceConstraintWithGap (Classe qui herite de la classe PrecedenceConstraint)
    public PrecedenceConstraintWithGap(Activity activite1, Activity activite2, int delai_min, int delai_max){
        super(activite1, activite2);
        this.delai_min = delai_min;
        this.delai_max = delai_max;
    }

    public int getMinDelay(){
        return delai_min;
    }

    public int getMaxDelay(){
        return delai_max;
    }

    //Permet d'indiquer si la contrainte est satisfaite ou non, ici les activites doivent respecter un delai
    public boolean isSatisfied(int debut_activite1, int debut_activite2){
        return (debut_activite1 + activite1.getDuration() <= debut_activite2) && (debut_activite1 + activite1.getDuration() + delai_min <= debut_activite2) && (debut_activite1 + activite1.getDuration() + delai_max >= debut_activite2);
    }
}
