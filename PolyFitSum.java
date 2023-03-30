import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PolyFitSum {
    
    public static double[][] matMult(double[][] A, double[][] B) throws IllegalArgumentException {
        if (A[0].length != B.length) throw new IllegalArgumentException("Mismatched Arrays");

        double[][] result = new double[A.length][B[0].length];
        //try catch statement to ensure that the lengths of the array are valid arguments
        // look at diagram on Marker I
        try {
            for (int i = 0; i < A.length; i++) { // pick a row
                for (int j = 0; j < B[0].length; j++) { // pick a col
                    for (int k = 0; k < B.length; k++) {
                        result[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            
            return result;

        } catch (Exception e){
            throw new IllegalArgumentException("Missmatched Arrays");
        }
    }

    public static double[][] invert(double[][] A) throws IllegalArgumentException {
        if (A.length != A[0].length) {
            throw new IllegalArgumentException("Matrix is not Invertible");
        }

        double[][] I = new double[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == j) I[i][j] = 1.0;
            }
        }

        for (int i = 0; i < A.length; i++) {
            int pivotLoc = i;
            double pivot = A[pivotLoc][i];
            try {
                while (Math.abs(A[pivotLoc][i]) < 0.0000000001) { // prevents FloatingPointException
                    ++pivotLoc;
                }
                pivot = A[pivotLoc][i];
                swapRows(A, i, pivotLoc);
                swapRows(I, i, pivotLoc);
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] /= pivot;
                    I[i][j] /= pivot;
                }
                
                for (int ii = 0; ii < A.length; ii++) {
                    if (i == ii) continue;
                    double multiplier = A[ii][i];
                    for (int j = 0; j < A[0].length; j++) {
                        A[ii][j] -= multiplier * A[i][j];
                        I[ii][j] -= multiplier * A[i][j];
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Singular Matrix");
            }
        }

        return I;
    }

    private static int getSize(File file) throws FileNotFoundException {
        int count = 0;
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            count++;
            s.next();
        }
        return count;
    }

    private static void swapRows(double[][] A, int r0, int r1) {
        for (int j = 0; j < A[0].length; j++) {
            double temp = A[r0][j];
            A[r0][j] = A[r1][j];
            A[r1][j] = temp;
        }
    }

    public static void printMatrix(double[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.printf("%7.2f", A[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        
        File f = new File("C:\\CLU\\2022-2023\\2023 Spring Semester\\CSC 310 - Algorithms\\In Class Code\\NoisyLinearData.csv");
        double[][] Q = new double[2][2];
        double[][] U = new double[2][1];
        int N = getSize(f);
        Q[0][0] = N;

        Scanner s = new Scanner(f);
        double[][] io = new double[N][N];
        int count = 0;

        while (s.hasNext()) {
            
            String str = s.nextLine();
            String[] vals = s.nextLine().split(",");
            double x = Double.parseDouble();
            double y = Double.parseDouble();
            double[] valsD = new double[vals.length];
            for(int i = 0; i < valsD.length; i++) {
                valsD[i] = Double.parseDouble(vals[i]);
            }
        	// create Q
            Q[0][0]++;
            Q[0][1] += x;
            Q[1][0] += x;
            Q[1][1] += x*x;
            // create U
            U[0][0] += y;
            U[1][0] += x*y;
        }
    }
}
