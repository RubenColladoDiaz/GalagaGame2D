package Part3;

import Core.Field;
import Core.PhysicBody;
import Core.Sprite;
import Part4.Nau;
import Part4.UI;
import Part4.Vides;
import Part4.test;

public class ProjectilEnemigo extends PhysicBody{


	int b = (int) this.x1-1000;
	
	public ProjectilEnemigo(String name, int x1, int y1, int x2, int y2, double angle, String path, Field f) {
		super(name, x1, y1, x2, y2, angle, path, f);
		this.trigger=true;
	}
	public ProjectilEnemigo(ProjectilEnemigo pe, int x1, int y1, int x2, int y2) {
		super(pe.name, x1, y1, x2, y2, 180, "resources/BombaEnemiga.png", pe.f);
		this.trigger=true;
	}

	@Override
	public void onCollisionEnter(Sprite sprite) {
		System.out.println("Ha sido impactado: "+sprite.name);
		if(sprite instanceof Nau) {
			
			test.w.sfxVolume = 100;
			test.w.playSFX("resources/DolorJugador.wav");
			
			Nau d = (Nau) sprite;
			d.danyar();
			this.delete();
			
			// UI.getInstance(f).vides.menysVida(1);
			Vides.vides--;
			
			if (Vides.vides < 0) {
				
				Vides.vides = 0;
				
			}
			
		}
	}

	@Override
	public void onCollisionExit(Sprite sprite) {
		
	}
	
	@Override
	public void update() {
		if(this.x1<b) {
			this.delete();
		}
		super.update();
	}

}
