package view;
import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class main {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for (int pessoa = 1; pessoa <= 4; pessoa++) {
			Thread corredor = new ThreadController(semaforo, pessoa);
			corredor.start();
		}
	}

}
