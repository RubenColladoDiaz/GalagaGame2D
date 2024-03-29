package Part3;

import Core.Field;
import Core.PhysicBody;
import Core.Sprite;
import Part4.UI;
import Part4.Nau;

public class Projectil extends PhysicBody{


	int b = (int) this.x1+1000;
	
	public Projectil(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.trigger=true;
	}
	public Projectil(Projectil p, int x1, int y1, int x2, int y2) {
		super(p.name, x1, y1, x2, y2, 0, "resources/Shoot.png", p.f);
		this.trigger=true;
	}

	@Override
	public void onCollisionEnter(Sprite sprite) {
		System.out.println("Le has dado a: "+sprite.name);
		if(sprite instanceof Disparable) {
			Disparable d = (Disparable) sprite;
			d.danyar();
			this.delete();
		}
	}

	@Override
	public void onCollisionExit(Sprite sprite) {
		
	}
	
	@Override
	public void update() {
		if(this.y1 < 0) {
			this.delete();
		}
		super.update();
	}

}
