package Part4;

import Core.*;

public class UI{
	
    public static UI instance = null;
    public Puntuacio punts;
    public Vides vides;

    
    //en un singleton el Consturctor es privat
    private UI(Field f) {
    	
    	Puntuacio puntuacio = new Puntuacio("Marcador", 20, 20, 20, 20, 0, "Puntuacio", f);
    	Vides vides = new Vides("Vidas", 20, 20, 20, 50, 0, "Vides", f);

    }
    public static UI getInstance(Field f) {
    	
        //si no existeix el creem
        if(instance == null) {
        	
            instance = new UI(f);
            
        }
        
        //tant si ja existia com si l'hem creat, tornem instance
        return instance;
    }
}