public class GuassJordan {
    
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

    public static void main(String[] args) {
        double[][] A = {{2, -4, 6}, {6, -6, 6}, {4, 2, 2}};
        printMatrix(invert(A));
    }

}
