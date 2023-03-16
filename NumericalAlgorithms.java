public class NumericalAlgorithms {

    //Matrix Multiplication
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
    
    public static void main(String args[]) {
        double[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        double[][] b = {{1, 5}, {2, 6}, {3, 7}, {4, 8}};
        double[][] c = matMult(a, b);
        for(int i = 0; i < c.length; i++) {
            System.out.println("");
            for(int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }
        }
    }
}