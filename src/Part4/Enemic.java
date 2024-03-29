package Part4;

import Core.Field;
import Core.PhysicBody;
import Core.Sprite;
import Core.Window;
import Part3.Disparable;
import Part3.Input;
import Part3.Projectil;
import Part3.ProjectilEnemigo;

public class Enemic extends PhysicBody implements Disparable{
	
	static ProjectilEnemigo pe;
	int hp;
	static boolean viu;

	public Enemic(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.viu=true;
		this.setConstantForce(0, 0.2);
	}

	@Override
	public void onCollisionEnter(Sprite sprite) {
		if(sprite instanceof Nau) {
			if(sprite.y2==this.y1) {
				Vides.vides = 0;
				this.delete();
			}else sprite.delete();
		}
	}

	@Override
	public void onCollisionExit(Sprite sprite) {
		
	}
	public static void disparar(Enemic e) {
		if(viu==true) {
		ProjectilEnemigo p1 = new ProjectilEnemigo("Misil", (int) e.x1, (int) e.y1, (int) e.x1, (int) e.y2, 0, "", e.f);
		pe = new ProjectilEnemigo(p1, (int) e.x1-50, (int) e.y1, (int) e.x1, (int) e.y2);
		pe.setVelocity(-1, 15);
		
		}
	}
	
	@Override
	public void danyar() {
		this.hp-=1;
		if(this.hp==0) {
			System.out.println("Has eliminado a un enemigo");
			this.delete();
			// UI.getInstance(f).punts.sumaPunts(100);
			// "Part4.UI.getInstance(Core.Field).punts" is null
			Puntuacio.punts = Puntuacio.punts + 100;
			
			if (Puntuacio.punts >= 1000) {
				
				Puntuacio.punts = Puntuacio.punts + 200;
				
			}
			
		}else System.out.println("Te queda "+this.hp+" de vida");
	}
	
	@Override
	public void update() {
		if(this.viu==false) {
			this.delete();
		}
		super.update();
	}
	
}
