/* Joy Kim
26 August, 2022
CSE007 Fall 2022: Lab 1
JDK 11 
*/
// This program is intended to convert weight in pounds to weight in kilograms.
public class ConvertWeight {
    public static void main (String [] args) {
        final double kgPerPound = 0.45359237;
        double weightInPounds = 150.32;
        double weightInKilograms;

        weightInKilograms = kgPerPound * weightInPounds;
        System.out.println (weightInPounds+" is equivalent to "+weightInKilograms+" kg");

    }
}