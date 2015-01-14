package forkjoin.prime;

import java.math.BigInteger;
import java.util.Calendar;

import forkjoin.Utils;

public class SerializeThread {
	
	public static void main(String[] args) {
		
	}

	public boolean isprime(BigInteger n) {
		boolean isPrime = true;
	
		for (BigInteger i = Utils.two; i.compareTo(TestPrime.sqrt) <= 0; i = i.add(BigInteger.ONE)) {
			if (n.mod(i).equals(BigInteger.ZERO)) {
				isPrime = false;
			}
		}
		return isPrime;
	}

}
