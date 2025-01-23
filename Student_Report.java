import java.util.Scanner;
public class Student_Report{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter marks of Physics, chemistry and Maths:");
		int physics=sc.nextInt();
		int chemistry=sc.nextInt();
		int maths=sc.nextInt();
		double average=(physics+chemistry+maths)/3;
		System.out.println("Percentage: "+average);
		if(average>=80){
			System.out.println("Grade: A");
			System.out.println("Remark: Level 4, above agency-normalized standards");
		}
		else if(average>=70){
			System.out.println("Grade: B");
			System.out.println("Remark: Level 3, at agency-normalized standards");
		}
		else if(average>=60){
			System.out.println("Grade: C");
			System.out.println("Remark: Level 2, Below but approaching agency-normalized standards");
		}
		else if(average>=50){
			System.out.println("Grade: D");
			System.out.println("Remark: Level 1, Well below agency-normalized standards");
		}
		else if(average>=40){
			System.out.println("Grade: E");
			System.out.println("Remark: Level 1, too agency-normalized standards");
		}
		else{
			System.out.println("Grade: R");
			System.out.println("Remark: Remedial standards");
		}
		sc.close();
	}
}