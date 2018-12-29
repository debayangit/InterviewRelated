package com.practice;

import java.util.HashMap;
import java.util.HashSet;

public class TypesOfClassLoaders {
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO:
		//https://www.youtube.com/watch?v=txkOG9FdsyQ
		typesOfClassLoader();
		LoadClassDynamiccally();
		LoadClassDynamiccallyHashMap();

	}

	private static void typesOfClassLoader() {
		System.out.println("null denotes bootstarp "+HashSet.class.getClassLoader());//Bootstrap Loader parent of all loads content of ##rt.jar
		System.out.println(Employee.class.getClassLoader());//App or system Loader beta of all
		System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());//Ext Load father of app loader, beta of bootstrap
	}
	
	private static void LoadClassDynamiccally() throws ClassNotFoundException {
		//option 1
		Class e =Class.forName("com.practice.Employee");
		System.out.println(e.getName());
		
		//option 2
		ClassLoader cl= ClassLoader.getSystemClassLoader();
		try {
			Employee ee= (Employee) cl.loadClass("com.practice.Employee").newInstance();
			System.out.println(ee.getClass().getName());
			System.out.println(ee.getClass().getClassLoader());
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	private static void LoadClassDynamiccallyHashMap() throws ClassNotFoundException {
		//option 1
		Class e =Class.forName("java.util.HashMap");
		System.out.println(e.getName());
		
		System.out.println(e.getClassLoader());
		
		ClassLoader cl= ClassLoader.getSystemClassLoader();
		try {
			HashMap ee= (HashMap) cl.loadClass("java.util.HashMap").newInstance();
			System.out.println("SYSTEM LOADER AUTOMATICALLY CALLS ITS PARENTS -->EXT AND THEN BOOTSTAP");
			System.out.println(ee.getClass().getClassLoader());
		}catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

class Employee{
	int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int iid) {
		id=iid;
	}
}