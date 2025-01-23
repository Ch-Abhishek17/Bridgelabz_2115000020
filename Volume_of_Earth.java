/*
 * Write a Program to compute the volume of Earth in km^3 and miles^3
Hint => Volume of a Sphere is (4/3) * pi * r^3 and radius of earth is 6378 km
O/P => The volume of earth in cubic kilometers is ____ and cubic miles is ____
 */
import java.lang.Math;
public class Volume_of_Earth {
    public static void main(String[] args) {
        final double pi=3.14;
        int r=6378; //radius of Earth
        //volume of Earth in Cubic Kms
        double volume=(4/3)*pi*Math.pow(r,3);
        double mVolume=volume/1.61; //volume in cubic miles
        System.out.println("The volume of earth in cubic kilometers is "+volume+" and cubic miles is "+mVolume);
    }
}
