import java.util.Scanner;
public class Leap_Year{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
	System.out.println("Enter year >=1582: ");
	int year=sc.nextInt();
	if(year<1582){
		System.out.println("Please Enter a year >= 1582");
	}
	else if((year%4==0 && year%100!=0)|| (year%400 == 0)){
		System.out.printf("Year %d is a Leap Year",year);
	}
	else{
		System.out.printf("Year %d is not a leap year",year);
	}
	sc.close();
	}	
}
