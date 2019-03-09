package com.jpmc.algo;

public class Recursion1 {

	public static void main(String[] args) {
		print(6);

	}
	
	public static void print(int i) {
		if(i==0) {
			return;
		}else {
			print(i-1);
			System.out.println(i);
		}
	}

}
