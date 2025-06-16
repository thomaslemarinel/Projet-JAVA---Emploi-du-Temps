package schedules.activities;

public class Activity{
    private String description;
    private int duree;

    //Constructeur de la classe Activity
    public Activity(String description, int duree){
        this.description = description;
        this.duree = duree;
    }

    public String getDescription(){
        return description;
    }

    public int getDuration(){
        return duree;
    }

    //Renvoie une representation sous forme de chaine de caracteres de l'activite
    public String toString(){
        return description + " " + duree;
    }

}
