package Part4;

import java.awt.Color;

import Core.*;

public class Puntuacio extends Sprite {
	
	static int punts = 0;

	public Puntuacio(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		// TODO Auto-generated constructor stub
		
		this.solid = false;
		this.text = true;
		this.textColor=0xffff00;
		
		this.path = "Puntuacio: " + punts;
		
	}
	
	public void sumaPunts(int num) {
		
		punts += num;
		this.path = "Puntuacio: "+ punts;
	}

}
