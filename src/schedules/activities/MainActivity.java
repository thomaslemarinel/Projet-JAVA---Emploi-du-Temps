package schedules.activities;

import schedules.activities.*;

public class MainActivity{
    
    public static void main(String[] args){
        
        Activity activite1 = new Activity("Aller à l'Université", 15);
        Activity activite2 = new Activity("Attacher le vélo", 1);

        //On affiche la description et la duree pour les deux activites
        System.out.println("Description : " + activite1.getDescription() + ", Duree : " + activite1.getDuration());
        System.out.println("Description : " + activite2.getDescription() + ", Duree : " + activite2.getDuration());
        
    }
}
