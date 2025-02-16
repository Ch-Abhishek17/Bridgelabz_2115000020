/*
 * Problem:
Write a program that compares the performance of StringBuffer and StringBuilder for concatenating strings. For large datasets (e.g., concatenating 1 million strings), compare the execution time of both classes.
Approach:
Initialize two StringBuffer and StringBuilder objects.
Perform string concatenation in both objects, appending 1 million strings (e.g., "hello").
Measure the time taken to complete the concatenation using System.nanoTime() for both StringBuffer and StringBuilder.
Output the time taken by both classes for comparison.

 */
import java.util.*;

class CompareStringBuilderStringBuffer{
	public static void main(String []args){
	
		int iteration = 1000000;
		String str = "hello";
		
		
		StringBuffer stringBuffer = new StringBuffer();
		long startTime = System.nanoTime();
		for(int i=0;i<iteration;i++){
			stringBuffer.append(str);
		}
		long endTime = System.nanoTime();
		long stringBufferTime = endTime-startTime;
		System.out.println("Total Time taken by StringBuffer is "+stringBufferTime+"ns.");
		
		StringBuilder stringBuilder = new StringBuilder();
		startTime = System.nanoTime();
		for(int i=0;i<iteration;i++){
			stringBuilder.append(str);
		}
		endTime = System.nanoTime();
		long stringBuilderTime = endTime-startTime;
		System.out.println("Total Time taken by StringBuilder is "+stringBuilderTime+"ns.");
		
		System.out.println("StringBuilder is "+(double) stringBufferTime / stringBuilderTime +" times faster than StringBuffer.");
		
	}
}