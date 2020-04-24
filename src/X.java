import processing.core.PApplet;

public class X {
	
	private PApplet app;
	private int posX, posY;
	
	
	public X() {
		
	}

	public X(PApplet app, int posX, int posY) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void pintar() {
		app.fill(55);
		app.textSize(90);
		app.text("X", posX, posY);
	
	}
	
}
