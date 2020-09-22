package controller;

import java.util.concurrent.Semaphore;

/*4 pessoas caminham, cada uma em um corredor diferente. 
 * Os 4 corredores terminam em uma �nica porta. 
 * Apenas 1 pessoa pode cruzar a porta, por vez. 
 * Considere que cada corredor tem 200m. e cada pessoa anda de 4 a 6 m/s. 
 * Cada pessoa leva de 1 a 2 segundos para abrir e cruzar a porta. 
 * Fa�a uma aplica��o em java que simule essa situa��o.*/

public class ThreadController extends Thread {
	private Semaphore semaforo;
	private int pessoa;
	private int distancia = 200;
	private int metros;
	private static int num = 0;
	
	public ThreadController(Semaphore semaforo, int pessoa) {
		this.semaforo = semaforo;
		this.pessoa = pessoa;
	}
	
		public void run() {
			andaCorredor();
// Sess�o Cr�tica 
			try {
				semaforo.acquire();
				abrirPorta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}

		}
//	Fim da Sess�o Cr�tica
		
		private void andaCorredor() {
			while (metros < distancia) {
				metros = metros + (int) (Math.random() * 2) + 4;
				System.out.println("A pessoa "+pessoa+"andou"+metros+"metros!");
			}
		}
		
		private void abrirPorta() {
			num++;
			int tempo = (int)(Math.random() + 1);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A pessoa "+pessoa+" foi a "+ num +"� a passar pela porta.");
		}

}
