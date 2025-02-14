/*
 1. Bubble Sort - Sort Student Marks
Problem Statement:
A school maintains student marks in an array. Implement Bubble Sort to sort the student marks in ascending order.
Hint:
Traverse through the array multiple times.
Compare adjacent elements and swap if needed.
Repeat the process until no swaps are required.

 */
import java.util.*;

class BubbleSort{
	
	void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String []args){
		
		BubbleSort bs = new BubbleSort();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the no. of Students : ");
		int n = sc.nextInt();
		if(n==0){
			System.out.println("No Students in array.");
		}
		else{
			int[] studentMarks = new int[n];
			for(int i=0;i<n;i++){
				System.out.println("Enter the marks of Student "+(i+1)+" : ");
				studentMarks[i]=sc.nextInt();
			}
			bs.bubbleSort(studentMarks);
			
			System.out.print("Student marks in ascending order : ");
			
			for(int i=0;i<n;i++){
				System.out.print(studentMarks[i]+" ");
			}
		}
	}
}