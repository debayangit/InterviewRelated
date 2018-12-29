package com.practice;

import java.util.HashMap;
import java.util.Map;

public class EqualsHashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stubprintCreditCardGood()
		printCreditCardGood();
		printCreditCardBad();
		

	}

	public static void printCreditCardBad() {
		Map<CreditCardBad, String> m = new HashMap<CreditCardBad, String>();
		m.put(new CreditCardBad(100), "4111111111111111");
		System.out.println(m.get(new CreditCardBad(100))); 

	}

	public static void printCreditCardGood() {

		Map<CreditCardGood, String> m = new HashMap<CreditCardGood, String>();
		m.put(new CreditCardGood(100), "4111111111111111");
		System.out.println(m.get(new CreditCardGood(100)));

	}


}



class CreditCardBad {
	private final int number;

	public CreditCardBad(int number) {
		this.number = number;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof CreditCardBad)) {
			return false;
		}
		CreditCardBad cc = (CreditCardBad)o;
		return cc.number == number;
	}
}

class CreditCardGood {
	private final int number;

	public CreditCardGood(int number) {
		this.number = number;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof CreditCardGood)) {
			return false;
		}
		CreditCardGood cc = (CreditCardGood)o;
		return cc.number == number;
	}

	public int hashCode() {
		int result = 17;
		result = 31 * result + number;
		return result;
	}
}


