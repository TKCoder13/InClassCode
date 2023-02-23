public class LinearSearch {
    static int count = 0;
    public static int sortedLinearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            ++count;
            if (a[i] == target) {
                return i;
            }
            // although this should cut the comparisons in half, this on average brings the num of comparisons up. Therefore it is not a good idea.
            /* 
             ++count;
             if (a[i] > target) 
                return -1;
            */
        }
        return -1;
    }



    public static void main(String args[]) {
        int N = 101;
        int avg = 0;
        //create the data
        int[] a = new int[N];
        
        for (int i = 0; i < a.length; i++) { // This is creating a Sorted List
            a[i] = i;
        }
        //"Monte Carlo" Simulation
        for (int i = 0; i < a.length; i++) {
            count = 0;
            int loc = sortedLinearSearch(a, a[i]);
            avg += count;
        }
        count = 0;
        int loc = sortedLinearSearch(a, -1);
        avg += count;
        System.out.println(avg/(double)N);

    }
}
