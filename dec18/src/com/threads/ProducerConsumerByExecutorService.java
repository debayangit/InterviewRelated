package com.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerByExecutorService {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBlockingQueue<Double> mq = new MyBlockingQueue<>();
		ExecutorService es= Executors.newFixedThreadPool(2);
		es.execute(() -> {
			while(true) {
				double d= (int)(Math.random()*10);
				System.out.println("Producer -- "+d);
				mq.put(d);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		es.execute(() -> {
			while(true) {
				double d= Math.random();
				System.out.println("Counsumer -- "+mq.take());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}






	

}

////
	class MyBlockingQueue<E>{
		Queue<E> queue; 
		private final int  MAX_VAL=10;
		private ReentrantLock lock= new ReentrantLock(true);
		private Condition full= lock.newCondition();
		private Condition empty= lock.newCondition();
		


		MyBlockingQueue(){
			queue = new LinkedList<E>();
		}

		public void put(E e) {
			lock.lock();
			try {
				while(queue.size()==MAX_VAL) {
					System.out.println("---Queue full---");
					full.await();
				}
				queue.add(e);
				empty.signalAll();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
		
		public E take() {
			lock.lock();
			try {
				while(queue.size()==0) {
					System.out.println("---Queue empty---");
					empty.await();
				}
				E e1=queue.remove();
				full.signalAll();
				return e1;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			return null;
		}





	}
