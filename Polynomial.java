import java.lang.Math;

public class Polynomial {
    
    static int add = 0;
    static int multi = 0;

    // public static double evalPoly(double[] coefs, int x) { // This is the most basic simple way of solving this, fast implementation, slow runtime
    //     double result = 0;
    //     add = 0;
    //     multi = 0;
    //     for (int i = coefs.length - 1; i >= 0; i--) {
    //         result += (coefs[i] * Math.pow(x, i)); ++add; ++multi;
    //     }
    //     return result;
    // }

    // public static double evalPoly(double[] coefs, int x) { // This is better than the first one, not the best tho
    //     add = 0;
    //     multi = 0;
    //     double result = 0;
    //     double xPower = Math.pow(x, coefs.length - 1);
    //     for (int i = coefs.length - 1; i >= 0; i--) {
    //         result += (coefs[i] * xPower); ++add; ++multi;
    //         xPower /= x; ++multi;
    //     }
    //     return result;
    // }

    public static double evalPoly(double[] coefs, int x) { // Same amt of adds and multis, but got rid of Math.pow()
        add = 0;
        multi = 0;
        double result = 0;
        double xPower = 1;
        for (int i = 0; i < coefs.length; i++) {
            result += (coefs[i] * xPower); ++add; ++multi;
            xPower *= x; ++multi;
        }
        return result;
    }

    public static double hornersMethod(double[] coefs, int x) { // Uses factorization, halves the amount of multiplication
        //counters
        add = 0;
        multi = 0;

        int n = coefs.length;
        double result = coefs[n-1];

        for (int i = n-2; i >= 0; i--) {
            result *= x; ++add;
            result += coefs[i]; ++multi;
        }
        return result;
    }

    public static void main(String args[]) {
        double[] arrayOfCoefs = {0,1,2,3,4};
        double output = evalPoly(arrayOfCoefs, 2);
        System.out.println("Generic Polynomial Formula: " + output);
        System.out.println("Additions: " + add);
        System.out.println("Multiplcations: " + multi);

        double hornerOutput = hornersMethod(arrayOfCoefs, 2);
        System.out.println("Horner's Method: " + hornerOutput);
        System.out.println("Additions: " + add);
        System.out.println("Multiplcations: " + multi);
    }
}
