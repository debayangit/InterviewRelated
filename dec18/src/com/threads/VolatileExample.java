package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileExample {

	 boolean  flag=true;

	public static void main(String args[]){

		VolatileExample ve= new VolatileExample();
		ExecutorService es=  Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		es.submit(()->{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ve.flag=false;
			System.out.println(Thread.currentThread().getName() +" flag:" +ve.flag);
		});

		es.submit(()->{
			while(ve.flag) {
				System.out.println("True");
			}
		});
		

		es.submit(()->{
			while(ve.flag) {
				System.out.println("True");
			}
		});

		es.submit(()->{
			while(ve.flag) {
				System.out.println("True");
			}
		});

		es.submit(()->{
			while(ve.flag) {
				System.out.println("True");
			}
		});
		

		es.submit(()->{
			while(ve.flag) {
				System.out.println("True");
			}
		});
		
		es.shutdown();
	}

}
