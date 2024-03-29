package Part4;

import java.util.Timer;
import java.util.TimerTask;

import Core.*;


public class test {
	
	public static Field f = new Field();
	public static Window w = new Window(f);

	public static void main(String[] args) throws InterruptedException {

		w.changeSize(1920, 1080);
		
		Nau nau = new Nau("Nau", 800, 800, 900, 900, 0, "resources/Iker.png", f);
		
		Spawner spawner = new Spawner(f, 0);
		// UI.getInstance(f);
		
		Sprite bg = new Sprite("fons", 0, 0, w.getWidth() + 1000, w.getHeight() + 1000, 0, "resources/FondoEstrellas.jpg", f);
		bg.solid = false;
		bg.orderInLayer = -2;
		
		Sprite bg2 = new Sprite("fons2", 0, -w.getHeight(), w.getWidth() + 1000, 0, 0, "resources/FondoEstrellas.jpg", f);
		bg2.solid = false;
		bg2.orderInLayer = -2;
		
    	Puntuacio puntuacio = new Puntuacio("Marcador", 20, 20, 20, 20, 0, "Puntuacio: "+Puntuacio.punts, f);
    	Vides vides = new Vides("Vidas", 20, 20, 20, 50, 0, "Vides: "+Vides.vides, f);
    	
		w.musicVolume = 100;
		w.playMusic("resources/GallagaBackgroundMusic.wav");
		
		boolean sortir = false;
		while(!sortir) {
			
			if (nau.hp > 0) {
			
			 Nau.controls(nau, w);
			 
			}
			 f.draw();
	         Thread.sleep(30);
	         
	         bg.y1 += 10;
	         bg.y2 += 10;
	         
	         if (bg.y1 > 850) {
	        	 
	        	 bg.y1 = -w.getHeight();
	        	 bg.y2 = 0;
	        	 
	         }
	         
	         bg2.y1 += 10;
	         bg2.y2 += 10;
	         
	         if (bg2.y1 > 850) {
	        	 
	        	 bg2.y1 = -w.getHeight();
	        	 bg2.y2 = 0;
	        	 
	         }
	         
	         puntuacio.path = "Puntuacio: "+Puntuacio.punts;
	         vides.path = "Vides: "+Vides.vides;
	         
		}

	}

}