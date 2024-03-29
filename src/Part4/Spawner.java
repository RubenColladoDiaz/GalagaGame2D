package Part4;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Core.*;

public class Spawner {
	
	static Random rm = new Random();
	
	public Spawner(Field f, int xmax) {
		
		//schedule. Passes la tasca que vols executar, quan trigarà a 
		//executarse per primer cop (en milisegons), i quants ms trigarà 
		//entre cada execució. Aquesta tasca s’executa inmediatament, i 
		//cada segón després d’això
		
        timer.schedule(task1, 0, 2000);
		
	}
	
	public static void generarEnemic() {
		
		int x1 = rm.nextInt(1, 1000);
		int x2 = x1 + 100;
		
		int tipusEnemic = rm.nextInt(2);
		
		if (Puntuacio.punts >= 1000) {
			
			tipusEnemic = 1;
			
		}
		
		if (tipusEnemic == 0) {
			
			test.w.sfxVolume = 100;
			test.w.playSFX("resources/ApareceEnemigo.wav");
			EnemicBase enemic1 = new EnemicBase("Enemic", x1, 100, x2, 200, 0, "resources/Enemic3.png", test.f);
			EnemicBase.disparar(enemic1);
			
		}
		if (tipusEnemic == 1) {
			
			test.w.sfxVolume = 100;
			test.w.playSFX("resources/ApareceEnemigo.wav");
			EnemicBase2 enemic2 = new EnemicBase2("Enemic2", x1, 100, x2, 200, 0, "resources/Enemic4.png", test.f);
			EnemicBase2.disparar(enemic2);
			
		}
		
	}
	
	//Timer representa el temporitzador. Només en cal un
    Timer timer = new Timer();
    //tasca. Cada tasca es individual. si vols 5 events necessitaràs 5 tasques.
    TimerTask task1 = new TimerTask() {
    	
        //la funció run indica tot allò que volguem executar
        @Override
        public void run()
        {
            //en aquest cas volem executar la funció de generarEnemic
                generarEnemic();
                // Enemic.disparar(enemic);
        }
    };

}