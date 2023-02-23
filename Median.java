import java.lang.Math;

public class Median {

    public static void main(String args[]) {
        int avg = 0;
        int N = 1000000;
        int best = 10;
        int worst = 0;
        for (int i = 0; i < N; i++) {
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);
            int z = (int)(Math.random()*10);
            int m = Median.findMedian(x,y,z);
            avg += comps;
            if (comps < best) best = comps;
            if (comps > worst) worst = comps;
        }
        System.out.println("Average Time: " + (avg / (double)N));
        System.out.println("Best Time: " + best);
        System.out.println("Worst Time: " + worst);
    } // end of main

    static int comps = 0;
    public static int findMedian (int x, int y, int z)
    {
        
        // if (x < y)
        // {
        //     if (y < z)
        //     {
        //         return y; // (x y z)
        //     } 
        //     else if (x < z)
        //     {
        //         return z; // (x z y)
        //     } 
        //     else
        //     {
        //         return x; // (z x y)
        //     }
        // } 
        // else 
        // {
        //     if (x < z) {
        //         return x; // (y x z)
        //     } 
        //     else if (y < z)
        //     {
        //         return z; // (y z x)
        //     }
        //     else
        //     {
        //         return y; // (z y x)
        //     }
        // }
        
        /*int comps = 0;
            These are for counting the amount of computations that are necessary for ever time this is used.
        comps++;*/
        comps++;
        if (x < y)
        {
            comps++;
            if (y < z)
            {
                return y; // (x y z)
            } 
            else 
            {
                comps++;
                if (x < z)
                {
                   return z; // (x z y) 
                }
                else
                {
                    return x; // (z x y)
                }
            } 
        } 
        else 
        {
            comps++;
            if (x < z) {
                return x; // (y x z)
            } 
            else 
            {
                comps++;
                if (y < z){
                    return z; // (y z x)
                }
                else
                {
                    return y; // (z y x)
                }
            }
            
        }
    }

}
