package com.practice;

public class DEADLOCK {

	String str1 = "Java ";
    String str2 = "UNIX ";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
            	System.out.println("thread1");
                synchronized(str1){
                	System.out.println("thread1."+str1);
                    synchronized(str2){
                        System.out.println(str1 + str2);
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
            	System.out.println("thread2");
                synchronized(str2){
                	System.out.println("thread2."+str2);
                    synchronized(str1){
                        System.out.println(str2 + str1);
                    }
                }
            }
        }
    };
     
    public static void main(String a[]){
    	DEADLOCK mdl = new DEADLOCK();
        mdl.trd1.start();
        mdl.trd2.start();
    }

}
