package br.com.caelum.thread;

public class Programa implements Runnable{
	
	private int id;
	
	public void setId(int id){
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("Programa " + id + " valor " +i);
		}
	}
}
