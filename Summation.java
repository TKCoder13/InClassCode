import java.lang.Math;

public class Summation {
    public static void main(String args[]) {
    long A = 5;
    int N = 6;
    int sum1 = 0;
    for (int i = 0; i <= N; ++i) { // summation
        sum1 += Math.pow(A,i);
    }
    long sum2 = (long)((Math.pow(A,(N+1))-1)/(A-1)); // closed form
    System.out.println(sum1);
    System.out.println(sum2);
    }
}
