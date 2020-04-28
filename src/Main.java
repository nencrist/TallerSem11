import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import com.google.gson.Gson;

import processing.core.PApplet;

public class Main extends PApplet{
	
	private DatagramSocket socket;
	private InetAddress android;
	//variables de los rectangulos, las x
	private Rectangulo rect1, rect2,rect3, rect4, rect5, rect6, rect7, rect8, rect9;
	private ArrayList<X> xArray;
	//variables jugada
	private Jugada jugar;
	//variables alerta jugada
	private JugadaAlerta alerta1, alerta2, alerta3, alerta4, alerta5, alerta6, alerta7, alerta8, alerta9;
	
	
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		
	}
	
	public void settings() {
		size(500,550);
	}
	
	public void setup() {
		//inicializacion rectangulos
		rect1 = new Rectangulo(this, 20, 20, 252, 34, 101);
		rect2 = new Rectangulo(this, 177, 20, 86, 114, 255);
		rect3 = new Rectangulo(this, 335, 20, 242, 242, 64);
		rect4 = new Rectangulo(this, 20, 178, 143, 47, 244);
		rect5 = new Rectangulo(this, 177, 178, 77, 244, 84);
		rect6 = new Rectangulo(this, 335, 178, 239, 72, 239);
		rect7 = new Rectangulo(this, 20, 335, 244, 197, 49);
		rect8 = new Rectangulo(this, 177, 335, 78, 244, 216);
		rect9 = new Rectangulo(this, 335, 335, 244, 59, 59);
		//inicializacion x
		xArray = new ArrayList<X> ();
		//inicializacion jugada
		jugar = new Jugada(this);
		//inicializacion alertas
		alerta1 = new JugadaAlerta(1);
		alerta2 = new JugadaAlerta(2);
		alerta3 = new JugadaAlerta(3);
		alerta4 = new JugadaAlerta(4);
		alerta5 = new JugadaAlerta(5);
		alerta6 = new JugadaAlerta(6);
		alerta7 = new JugadaAlerta(7);
		alerta8 = new JugadaAlerta(8);
		alerta9 = new JugadaAlerta(9);
		
		//hilo recepcion udp
		new Thread(
				
				() -> {
					try {
						android = InetAddress.getByName("192.168.0.5");
						socket = new DatagramSocket (8000);
						
						while(true) {
							byte[] buffer = new byte[100];
							DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
							socket.receive(packet);
							
							String mensajeRecibido = new String(packet.getData());
							System.out.println(mensajeRecibido);
							
						}
					} catch (SocketException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				).start();
		
		
	}


	
	public void draw() {
		background(77);
		//pintar los rectangulos
		rect1.pintar();
		rect2.pintar();
		rect3.pintar();
		rect4.pintar();
		rect5.pintar();
		rect6.pintar();
		rect7.pintar();
		rect8.pintar();
		rect9.pintar();
		//pintar texto jugada
		jugar.miTurno();
		jugar.espera();
		//pintar las x
		for (int i = 0; i < xArray.size(); i++) {
			X x = xArray.get(i);
			x.pintar();
			
		}

	}
	
	public void mousePressed() {
		//enviarMensaje("hola eclipse");
		
		//validaciones area sensible
		//rect1
		if(jugar.getTurno() == 1) {
		if(mouseX > 20 && mouseX < 165 && mouseY > 20 && mouseY < 165) {
			X x = new X(this, 64, 121);
			xArray.add(x);
			jugar.setTurno(2);
			Gson gson = new Gson();
			String json = gson.toJson(alerta1);
			enviarMensaje(json);
			System.out.println(json);
			}
		}
		//rect2
		if(jugar.getTurno() == 1) {
		if(mouseX > 177 && mouseX < 322 && mouseY > 20 && mouseY < 165) {
			X x = new X(this, 225, 121);
			xArray.add(x);
			jugar.setTurno(2);
			}
		}
		//rect3
		if(jugar.getTurno() == 1) {
		if(mouseX > 335 && mouseX < 480 && mouseY > 20 && mouseY < 165) {
			X x = new X(this, 383, 121);
			xArray.add(x);	
			jugar.setTurno(2);
			}
		}
		//rect4
		if(jugar.getTurno() == 1) {
		if(mouseX > 20 && mouseX < 165 && mouseY > 178 && mouseY < 323) {
			X x = new X(this, 64, 281);
			xArray.add(x);
			jugar.setTurno(2);
			}
		}
		//rect5
		if(jugar.getTurno() == 1) {
		if(mouseX > 177 && mouseX < 322 && mouseY > 178 && mouseY < 323) {
			X x = new X(this, 225, 281);
			xArray.add(x);	
			jugar.setTurno(2);
			}
		}
		//rect6
		if(jugar.getTurno() == 1) {
		if(mouseX > 335 && mouseX < 480 && mouseY > 178 && mouseY < 323) {
			X x = new X(this, 383, 281);
			xArray.add(x);	
			jugar.setTurno(2);
			}
		}
		//rect7
		if(jugar.getTurno() == 1) {
		if(mouseX > 20 && mouseX < 165 && mouseY > 335 && mouseY < 480) {
			X x = new X(this, 64, 438);
			xArray.add(x);	
			jugar.setTurno(2);
			}
		}
		//rect8
		if(jugar.getTurno() == 1) {
		if(mouseX > 177 && mouseX < 322 && mouseY > 335 && mouseY < 480) {
			X x = new X(this, 225, 438);
			xArray.add(x);	
			jugar.setTurno(2);
			}
		}
		//rect9
		if(jugar.getTurno() == 1) {
		if(mouseX > 335 && mouseX < 480 && mouseY > 335 && mouseY < 480) {
			X x = new X(this, 383, 438);
			xArray.add(x);	
			jugar.setTurno(2);
			}	
		}
		
	}
	
	public void enviarMensaje(String mensaje) {
		//hilo envios udp
		new Thread(
				() -> {
	
					try {
						byte[] buffer = mensaje.getBytes();
						DatagramPacket packet = new DatagramPacket(buffer, buffer.length, android, 8000);
						socket.send(packet);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				).start();
	}

}
