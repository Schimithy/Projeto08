package interacao;

import java.util.concurrent.Semaphore;
import controle.Ex01;

public class Main_Ex01 {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int id = 0; id<4; id++) {
			Thread tCorredor = new Ex01(id, semaforo);
			tCorredor.start();
		}
		
	}

}