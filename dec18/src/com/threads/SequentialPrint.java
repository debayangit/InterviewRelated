package com.threads;

public class SequentialPrint {
	
	int commonInt=0;
	Object key= new Object();
	
	public static void main (String args[]) {
		SequentialPrint sp= new SequentialPrint();
		Thread t1= new Thread() {
			public void run() {
				//
				sp.increament();
			}
		};
		Thread t2= new Thread() {
			public void run() {
				//
				sp.increament();
			}
		};
		Thread t3= new Thread() {
			public void run() {
				//
				sp.increament();
			}
		};
		Thread t4= new Thread() {
			public void run() {
				//
				sp.increament();
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
	}
	
	public void increament() {
		
		while(commonInt<9) {
			synchronized (key) {
				key.notifyAll();
				commonInt++;
				System.out.println(Thread.currentThread().getName()+":"+commonInt);
				try {
					key.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(commonInt==9) {
					key.notifyAll();
					break;
				}
			}
			
		}
		
	}

}
