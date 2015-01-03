package forkjoin.prime;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import forkjoin.Utils;

public class ParallelStreaming {
	static List<BigInteger> list = new LinkedList<>();
	private static BigInteger prime =Utils.primeNumber;// new BigInteger("3000");

	public static boolean isPrime() {		
		long count = list.parallelStream().filter(i -> prime.mod(i).equals(0)).count();		
		return count == 0;
	}

	private static void createList(BigInteger start, BigInteger end) {
		for (BigInteger i = Utils.two; i.compareTo(end) <= 0; i = i.add(BigInteger.ONE)) {
			list.add(i);
		}
		System.out.println(list.size());
	}

	public static void main(String args[]) {
		createList(Utils.two, Utils.sqrt);
		long t1 = Calendar.getInstance().getTimeInMillis();
		boolean isPrime = isPrime();
		long t2 = Calendar.getInstance().getTimeInMillis();
		System.out.println(String.format("Time = %s ms ; result = %s", (t2 - t1), isPrime));
	}
}