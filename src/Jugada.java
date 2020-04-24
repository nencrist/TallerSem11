import processing.core.PApplet;

public class Jugada {
	
	private PApplet app;
	private String texto;
	private int turno;

	public Jugada(PApplet app) {
		this.app = app;
		this.texto = "Tu juegas";
		this.turno = 1;
	}
	
	public void miTurno() {
		if(turno == 1) {
		app.fill(255);
		app.textSize(25);
		app.text(texto, 190, 520);
		}
	}
	
	public void espera() {
		if(turno == 2) {
		app.fill(255);
		app.textSize(25);
		texto = "El juega";
		app.text(texto, 190, 520);
		}	
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	

}
