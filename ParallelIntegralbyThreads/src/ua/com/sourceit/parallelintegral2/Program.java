package ua.com.sourceit.parallelintegral2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.DoubleFunction;

public class Program {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		
		long t1 = System.currentTimeMillis();	
		double integral1 = Integral.singleThreadIntegral(Math::sin, 0d, Math.PI/2);		
		long t2 = System.currentTimeMillis();		
		System.out.println(integral1);		
		System.out.printf("Single thread,  ms: %d\n", t2-t1);
		
		long t3 = System.currentTimeMillis();		
		double integral2 = Integral.multiThreadIntegral(Math::sin, 0d, Math.PI/2);		
		long t4 = System.currentTimeMillis();		
		System.out.println(integral2);		
		System.out.printf("Multi thread (pool), ms: %d\n", t4-t3);
		
		long t5 = System.currentTimeMillis();		
		double integral3 = Integral.multiThreadIntegral2(Math::sin, 0d, Math.PI/2);	
		long t6 = System.currentTimeMillis();		
		System.out.println(integral3);		
		System.out.printf("Multi thread2, ms: %d\n", t6-t5);
		
		long t7 = System.currentTimeMillis();		
		double integral4 = Integral.multiThreadIntegral3(Math::sin, 0d, Math.PI/2);	
		long t8 = System.currentTimeMillis();		
		System.out.println(integral4);		
		System.out.printf("Multi thread3, ms: %d\n", t8-t7);
	
		/*
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(6);
		nums.add(-2);
		nums.add(-4);
		nums.add(3);
		
		List<Integer> nums1 = new ArrayList<>();
		for (Integer num : nums) {
			if (num > 0) {
				nums1.add(num);
			System.out.println(num);
			}
		}

		Collections.sort(nums1);
		for (Integer num : nums1) {
			System.out.println(num);
			
		}
		
		nums.stream()
		.filter(num->num>0)
		.sorted()
		.forEach(System.out::println);
		*/
}
}
