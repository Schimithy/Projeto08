package controle;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Ex01 extends Thread {

	private int idPessoa;
	private Semaphore semaforo;

	public Ex01(int idPessoa, Semaphore semaforo) {

		this.semaforo = semaforo;
		this.idPessoa = idPessoa;

	}

	public void run() {

		pessoaAndando();
		// seção crítica »
		try {
			semaforo.acquire();
			cruzandoPorta();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
		// « seção crítica 
	}

	private void pessoaAndando() {
		Random rand = new Random();
		int passos = 0;
		int corredor = 200;
		int deslocamento = 0;
		int tempo = 1000;
		while (deslocamento < corredor) {
			passos = rand.nextInt(3)+4;
			deslocamento += passos;
			System.out.println("#" + idPessoa + " andou " + deslocamento + "m.");
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}

	}

	private void cruzandoPorta() {
		Random rand = new Random();
		int cruzando = rand.nextInt(2+1)*1000;
		try {
			System.out.println("#" + idPessoa + " esta atravessando a porta");
			sleep(cruzando);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
			System.out.println("#" + idPessoa + " atravessou a porta");
	}


}