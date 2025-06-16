package schedules.constraints;

import schedules.activities.*;

public class PrecedenceConstraint extends BinaryConstraint implements Constraint{

    //Constructeur initialisant les deux activites concernees par la contrainte
    public PrecedenceConstraint(Activity activite1, Activity activite2){
        super(activite1, activite2); //La classe herite de BinaryConstraint
    }

    //Methode qui permet d'afficher la contrainte sous forme de chaine de caracteres
    public String toString(){
        return "" + activite1 + "->" + activite2;
    }
    
    //Methode qui permet de verifier si la contrainte de precedence est satisfaite ou non
    public boolean isSatisfied(int debut_activite1, int debut_activite2) {
        return debut_activite1 + activite1.getDuration() <= debut_activite2;
    }
    
}
