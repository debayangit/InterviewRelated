package com.geeksforgeeks.linklists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiddleElement {
	public static void main(String args[]) {
		List<Integer> interList= new ArrayList<Integer>();
		
		for(int i=1;i<6;i++) {
			interList.add(i);
			getMiddle(interList);
		}
		
		
		
	}

	private static void getMiddle(List<Integer> interList) {
		Iterator <Integer> itr= interList.iterator();
		Iterator <Integer> itrSlow= interList.iterator();

		
		
		while(itr.hasNext()) {
			itr.next();
			if(itr.hasNext()){
				itr.next();
				itrSlow.next();
			}
		}
		System.out.println("List :::"+interList);
		System.out.println(itrSlow.next());
	}

}
