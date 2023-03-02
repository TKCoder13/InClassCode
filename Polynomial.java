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

    public static double evalPoly(double[] coefs, int x) {
        add = 0;
        multi = 0;
        double result = 0;
        double xPower = Math.pow(x, coefs.length - 1);
        for (int i = coefs.length - 1; i >= 0; i--) {
            result += (coefs[i] * xPower); ++add; ++multi;
            xPower /= x; ++multi;
        }
        return result;
    }
    public static void main(String args[]) {
        double[] arrayOfCoefs = {0,1,2,3,4};
        double output = evalPoly(arrayOfCoefs, 1);
        System.out.println(output);
        System.out.println(add);
        System.out.println(multi);
        
    }
}
