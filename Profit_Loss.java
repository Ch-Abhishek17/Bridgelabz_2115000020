/*
 * Create a program to calculate the profit and loss in number and
 *  percentage based on the cost price of INR 129 and the selling price of INR 191. 
Hint => 
Use a single print statement to display multiline text and variables.
Profit = selling price - cost price
Profit Percentage = profit / cost price * 100
I/P => NONE
O/P => 
The Cost Price is INR ___ and Selling Price is INR ___
The Profit is INR ___ and the Profit Percentage is ___

 */
public class Profit_Loss {
    public static void main(String[] args) {
        //cp-cost price, sp-selling price
        int cp=129;
        int sp=191;
        double percentage=0;
        if(sp>=cp){
            int profit=sp-cp;
            percentage=(profit*100)/cp;
            System.out.println("The Cost Price is INR "+cp+ " and Selling Price is INR "+sp+"\nThe Profit is INR "+profit+ " and the Profit Percentage is "+ percentage);
        }
        else{
            int loss=cp-sp;
            percentage=(loss*100)/cp;
            System.out.println("The Cost Price is INR "+cp+ " and Selling Price is INR "+sp+"\nThe Loss is INR "+loss+ " and the Loss Percentage is "+ percentage);

        }

    }
}
