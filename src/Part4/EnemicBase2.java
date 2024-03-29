package Part4;

import Core.Field;

public class EnemicBase2 extends Enemic {

	EnemicBase2(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f){
		super(name, x1, y1, x2, y2, angle, path, f);
		
		this.hp = 10;
		
	}

}
