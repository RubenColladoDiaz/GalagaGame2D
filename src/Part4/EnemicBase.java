package Part4;

import Core.Field;
import Core.PhysicBody;
import Core.Sprite;
import Core.Window;
import Part3.Disparable;
import Part3.Projectil;

public class EnemicBase extends Enemic {
	
	EnemicBase(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f){
		super(name, x1, y1, x2, y2, angle, path, f);
		
		this.hp = 5;
		
	}

}
