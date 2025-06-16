package schedules.solvers;

import schedules.activities.Activity;
import schedules.constraints.*;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

//Classe representant un verificateur de contraintes pour un emploi du temps
public class Verifier{
    private Set<Constraint> ensemble_contraintes;

    //Constructeur initialisant l'ensemble de contraintes à verifier
    public Verifier(Set<Constraint> ensemble_contraintes) {
        this.ensemble_contraintes = ensemble_contraintes;
    }

    //Methode qui permet de verifier quelles contraintes ne sont pas satisfaites par un emploi du temps
    public Set<Constraint> unsatisfied(Map<Activity, Integer> couple_activites_dates) {
        //On initialise un ensemble pour stocker les contraintes non satisfaites
        Set<Constraint> contraintes_non_satisfaites = new HashSet<>();
        //On parcours toutes les contraintes dans l'ensemble
        for (Constraint contrainte : ensemble_contraintes) {
            //On verifie si la contrainte n'est pas satisfaite pour l'emploi du temps donne
            if (!contrainte.isSatisfied(couple_activites_dates)){
                //On ajoute la contrainte non satisfaite à l'ensemble (contraintes_non_satisfaites)
                contraintes_non_satisfaites.add(contrainte);
            }
        }
        //On retourne l'ensemble des contraintes non satisfaites
        return contraintes_non_satisfaites;
    }
}
