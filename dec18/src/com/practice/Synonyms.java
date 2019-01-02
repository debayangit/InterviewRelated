package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Synonyms {
	static Set<List<String>> sysnonymSet;
	
	public static void main(String args[]) {
		storeSyns("w1","v1","z1","x1");
		storeSyns("w2","v2","z2","x2");
		
		retrieveAllSyns("z2");
		retrieveAllSyns("x1");
		
	}
	
	public static void storeSyns(String w1, String ...v) {
		List<String> synList= new ArrayList<>();
		synList.add(w1);
		synList.addAll(Arrays.asList(v));
		if(sysnonymSet==null) {
			sysnonymSet = new HashSet<List<String>>();			
		}
		
		sysnonymSet.add(synList);
	}
	
	public static void retrieveAllSyns(String word) {
		Iterator<List<String>> it= sysnonymSet.iterator();
		
		while(it.hasNext()) {
			List<String> synList= it.next();
			if(synList.contains(word)) {
				System.out.println(synList);
			}
		}
	}
	

}
