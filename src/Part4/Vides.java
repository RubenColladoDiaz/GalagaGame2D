package Part4;

import Core.Field;
import Core.*;

public class Vides extends Sprite {
	
	public static int vides = 5;

	public Vides(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		// TODO Auto-generated constructor stub
		
		this.solid = false;
		this.text = true;
		this.textColor=0xffff00;
		
		this.path = "Vides: " + vides;
		
	}
	
	public void menysVida(int num) {
		
		vides -= num;
		this.path = "Vides: " + vides;		
	}

}
