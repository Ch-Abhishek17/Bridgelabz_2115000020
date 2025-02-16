/*
 Problem:
Write a program that uses StringBuilder to remove all duplicate characters from a given string while maintaining the original order.
Approach:
Initialize an empty StringBuilder and a HashSet to keep track of characters.
Iterate over each character in the string:
If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
Return the StringBuilder as a string without duplicates.
 */
import java.util.*;

class RemoveDuplicates{
	
	public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
		
		HashSet<Character> hs = new HashSet<>();

		for(char ch : input.toCharArray()){
			if(!hs.contains(ch)){
				hs.add(ch);
				sb.append(ch);
			}
		}
		
		return sb.toString();
        
    }
	
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the String : ");
		String input = sc.nextLine();
		
		System.out.println("String After Remove Duplicates : "+removeDuplicates(input));
		
	}
}