import processing.core.PApplet;

public class Rectangulo {
	
	private PApplet app;
	private int posX, posY;
	private int r,g,b;

	public Rectangulo(PApplet app, int posX, int posY, int r, int g, int b) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.r = r;
		this.g = g;
		this.b = b;
		
	}
	
	public void pintar() {
		app.fill(r, g, b);
		app.noStroke();
		app.rect(posX, posY, 145, 145);
	}
	
	
}
