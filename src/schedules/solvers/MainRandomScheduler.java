package schedules.solvers;

import schedules.activities.Activity;
import schedules.constraints.*;
import schedules.solvers.RandomScheduler;
import schedules.solvers.TopologicalSorter;

import java.util.*;

public class MainRandomScheduler{

    public static void main(String[] args){
        //Exemple 1 : 

        System.out.println("Exemple 1 :");
        
        // Création d'activités
        Activity reveil = new Activity("Se réveiller", 5);
        Activity manger = new Activity("Manger", 20);
        Activity dents = new Activity("Se brosser les dents", 3);
        Activity habiller = new Activity("S'habiller", 5);
        Activity douche = new Activity("Se doucher", 10);

        // Création de contraintes
        PrecedenceConstraint constraint1 = new PrecedenceConstraint(reveil, manger);
        PrecedenceConstraint constraint2 = new PrecedenceConstraint(manger, habiller);
        MeetConstraint constraint3 = new MeetConstraint(manger, dents);
        PrecedenceConstraintWithGap constraint4 = new PrecedenceConstraintWithGap(douche, habiller, 1, 5);

        // Création d'un ensemble de contraintes
        Set<Constraint> constraints = new HashSet<>();
        constraints.add(constraint1);
        constraints.add(constraint2);
        constraints.add(constraint3);
        constraints.add(constraint4);

        // Création d'un ensemble d'activités
        Set<Activity> activities = new HashSet<>();
        activities.add(reveil);
        activities.add(manger);
        activities.add(dents);
        activities.add(habiller);
        activities.add(douche);

        // Utilisation du RandomScheduler
        Random random = new Random();
        RandomScheduler randomScheduler = new RandomScheduler(random);

        // Génération d'un emploi du temps aléatoire
        Map<Activity, Integer> randomSchedule = randomScheduler.generateOneSchedule(activities, 0, 10);

        System.out.println("Emploi du temps aléatoire :");
        System.out.println(randomSchedule);

        // Vérification des contraintes
        Verifier verifier = new Verifier(constraints);
        Set<Constraint> unsatisfiedConstraints = verifier.unsatisfied(randomSchedule);

        if (unsatisfiedConstraints.isEmpty()) {
            System.out.println("Les contraintes sont satisfaites.");
        } else {
            System.out.println("Contraintes non satisfaites : " + unsatisfiedConstraints);
        }


        //Exemple 2 : 

        System.out.println("Exemple 2 :");

        //On garde les memes activites de depart

        // Création de contraintes
        PrecedenceConstraint constraint1_2 = new PrecedenceConstraint(dents, habiller);
        MeetConstraint constraint2_2 = new MeetConstraint(manger, dents);
        MeetConstraint constraint3_2 = new MeetConstraint(douche, habiller);
        PrecedenceConstraintWithGap constraint4_2 = new PrecedenceConstraintWithGap(dents, douche, 1, 20);

        // Création d'un ensemble de contraintes
        Set<Constraint> constraints_2 = new HashSet<>();
        constraints_2.add(constraint1_2);
        constraints_2.add(constraint2_2);
        constraints_2.add(constraint3_2);
        constraints_2.add(constraint4_2);

        // Création d'un ensemble d'activités
        Set<Activity> activities_2 = new HashSet<>();
        activities_2.add(reveil);
        activities_2.add(manger);
        activities_2.add(dents);
        activities_2.add(habiller);
        activities_2.add(douche);

        // Utilisation du RandomScheduler
        Random random_2 = new Random();
        RandomScheduler randomScheduler_2 = new RandomScheduler(random_2);

        // Génération d'un emploi du temps aléatoire
        Map<Activity, Integer> randomSchedule_2 = randomScheduler_2.generateOneSchedule(activities_2, 0, 20);

        System.out.println("Emploi du temps aléatoire :");
        System.out.println(randomSchedule_2);

        // Vérification des contraintes
        Verifier verifier_2 = new Verifier(constraints_2);
        Set<Constraint> unsatisfiedConstraints_2 = verifier_2.unsatisfied(randomSchedule_2);

        if (unsatisfiedConstraints_2.isEmpty()) {
            System.out.println("Les contraintes sont satisfaites.");
        } else {
            System.out.println("Contraintes non satisfaites : " + unsatisfiedConstraints_2);
        }


        //Exemple 3 : 

        System.out.println("Exemple 3 :");

        //On garde les memes activites de depart

        // Création de contraintes
        PrecedenceConstraint constraint1_3 = new PrecedenceConstraint(dents, habiller);

        // Création d'un ensemble de contraintes
        Set<Constraint> constraints_3 = new HashSet<>();
        constraints_3.add(constraint1_3);

        // Création d'un ensemble d'activités
        Set<Activity> activities_3 = new HashSet<>();
        activities_3.add(reveil);
        activities_3.add(manger);
        activities_3.add(dents);
        activities_3.add(habiller);
        activities_3.add(douche);

        // Utilisation du RandomScheduler
        Random random_3 = new Random();
        RandomScheduler randomScheduler_3 = new RandomScheduler(random_3);

        // Génération d'un emploi du temps aléatoire
        Map<Activity, Integer> randomSchedule_3 = randomScheduler_3.generateSchedule(activities_3, constraints_3, 0, 50, 20);

        System.out.println("Emploi du temps aléatoire :");
        System.out.println(randomSchedule_3);

        // Vérification des contraintes
        Verifier verifier_3 = new Verifier(constraints_3);
        Set<Constraint> unsatisfiedConstraints_3 = verifier_3.unsatisfied(randomSchedule_3);

        if (unsatisfiedConstraints_3.isEmpty()) {
            System.out.println("Les contraintes sont satisfaites.");
        } else {
            System.out.println("Contraintes non satisfaites : " + unsatisfiedConstraints_3);
        }

    }


}

