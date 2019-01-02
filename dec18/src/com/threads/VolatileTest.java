package com.threads;

public class VolatileTest {
	
	volatile int vol=0;
	static final int VALUE=1000000;

	public static void main(String[] args)  throws Exception{
		VolatileTest vt= new VolatileTest();
		// TODO Auto-generated method stub
		Thread t1= new Thread() {
			public void run() {
				int i=0;
				while(i<VALUE) {
					vt.incrementVol();
					i++;
				}
			}
		};
		Thread t2= new Thread() {
			public void run() {
				int i=0;
				while(i<VALUE) {
					vt.incrementVol();
					i++;
				}
			}
		};
		Thread t3= new Thread() {
			public void run() {
				int i=0;
				while(i<VALUE) {
					vt.incrementVol();
					i++;
				}
			}
		};
		t1.start();t2.start();t3.start();
		t1.join();t2.join();t3.join();
		
		System.out.println("main :"+vt.get());


	}
	
	public void incrementVol() {
		vol++;
		/*if(vol%1000==0) {
			System.out.println(Thread.currentThread()+":"+vol);
		}*/
		
	}
	
	public int get() {
		return vol;
	}

}
