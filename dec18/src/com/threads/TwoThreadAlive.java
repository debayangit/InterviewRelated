package com.threads;

public class TwoThreadAlive extends Thread {
	public void run() {
		for (int i = 0; i < 500000; i++) {
			if(i%10000==0)
			printMsg();
		}
	}
	public void printMsg() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("name = " + name);
	}
	public static void main(String[] args) throws InterruptedException {
		TwoThreadAlive tt = new TwoThreadAlive();
		tt.setName("Thread");
		System.out.println("before start(), tt.isAlive() = " + tt.isAlive());
		tt.start();
		Thread ttt= new Thread(new MyRunnable());
		ttt.start();
		
		tt.join();
		System.out.println("just after start(), tt.isAlive() = " + tt.isAlive());

		for (int i = 0; i < 500000; i++) {
			
			if(i%10000==0)
				tt.printMsg();
			//ttt.join();
		}
		System.out.println("The end of main(), tt.isAlive()=" + tt.isAlive());
	}
}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(i<500000) {
			if(i%10000==0)
				System.out.println(Thread.currentThread().getName()+" = count ="+i);
			i++;
		}
	}
	
}