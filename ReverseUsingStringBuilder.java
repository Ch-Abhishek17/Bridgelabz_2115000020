/*
 * Problem:
Write a program that uses StringBuilder to reverse a given string. For example, if the input is "hello", the output should be "olleh".
Approach:
Create a new StringBuilder object.
Append the string to the StringBuilder.
Use the reverse() method of StringBuilder to reverse the string.
Convert the StringBuilder back to a string and return it.
 */
import java.util.*;

class ReverseUsingStringBuilder{
	
	public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
	
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the String : ");
		String input = sc.nextLine(); // Taking the input as String
		
		System.out.println("Reverse String : "+reverseString(input));
	}
}