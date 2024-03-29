package Part4;

import java.util.Timer;
import java.util.TimerTask;

import Core.Field;
import Core.PhysicBody;
import Core.Sprite;
import Core.Window;
import Part3.Disparable;
import Part3.Input;
import Part3.Projectil;

public class Nau extends PhysicBody implements Disparable{

	static Projectil p;
	public int hp;
    private static Timer timer = new Timer();

	public Nau(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.hp=5;
		
	}

	public static void controls(Nau a, Window w) {

		if (a.hp > 0) {
		
		if (w.getPressedKeys().contains('d')) {
			accions(a, Input.DRETA);
		} else if (w.getPressedKeys().contains('a')) {
			accions(a, Input.ESQUERRA);
		}
		if (w.getKeysDown().contains(' ')) {
			accions(a, Input.SALTAR);
		}
		if (w.getKeysDown().contains('e')) {
			accions(a, Input.DISPARAR);

		}
		if (w.getKeysDown().contains('q')) {
			accions(a, Input.QUIET);
		}
		
		}
		
	}

	public static void accions(Nau a, Input in) {

		if (a.hp > 0) {
		
		if (in == Input.ESQUERRA) {
			a.x1 = a.x1 - 28;
			a.x2 = a.x2 - 28;
		}
		if (in == Input.DRETA) {
			a.x1 = a.x1 + 28;
			a.x2 = a.x2 + 28;
		}

		if (in == Input.DISPARAR) {
			disparar(a);
			test.w.sfxVolume = 100;
			test.w.playSFX("resources/ShootSound.wav");

		}
		if (in == Input.QUIET) {
			a.setVelocity(0, 0);
		}

		if (a.velocity[0] >= 5) {
			a.velocity[0] = 5;
		} else if (a.velocity[0] <= -5) {
			a.velocity[0] = -5;
		}
		
		}

	}

	private static void disparar(Nau a) {
			
		Projectil p1 = new Projectil("Misil", (int) a.x2, (int) a.y1, (int) a.x2, (int) a.y2, 0, "", a.f);
		p = new Projectil(p1, (int) a.x1+40, (int) a.y1-70, (int) a.x2-40, (int) a.y2-90); // static Projectil
		p.setVelocity(0, -20);
		
	}
	

	@Override
	public void onCollisionEnter(Sprite sprite) {
		if (sprite instanceof Enemic) {
			this.delete();
			Vides.vides = 0;
		}
		
		if (sprite instanceof EnemicBase || sprite instanceof EnemicBase2) {
			this.hp = 0;
			Vides.vides = 0;
		}
		
	}

	@Override
	public void onCollisionExit(Sprite sprite) {
		
	}

	@Override
	public void danyar() {
		this.hp-=1;
		if(this.hp==0) {
			this.delete();
		}
		
	}

}