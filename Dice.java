import java.util.Random;

public class Dice {

    public static Random rn = new Random();

    public static int roll(int sides) {
        return rn.nextInt(sides) + 1; // [1...6]
    }
    public static void OneDie() {
        int[] rolls = {0, 0, 0, 0, 0, 0};
        int sidesOfDice = 6;
        int N = 600;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            ++rolls[roll(sidesOfDice) - 1];
        }
        for (int i = 1; i <= sidesOfDice; i++) {  
            System.out.println("The dice has rolled \"" + i + "\" " + rolls[i-1] + " times.");
            System.out.println(i + " --> " + (double)rolls[i-1] / N);
            sum += (double)rolls[i-1] / N;
        }
        System.out.println("The sum of the probabilities is: " + sum);
    }

    public static void TwoDice() {
        int dice[] = {0,0};
        int probs[] = new int[13]; //Ignore index 0
        long N = 120000;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < dice.length; j++) {
                dice[j] = roll(6);
            }
            ++probs[dice[0] + dice[1]];
        }
        double sum = 0;
        for (int i = 0; i < probs.length; ++i) {
            System.out.println(i + "\t" + (double)probs[i]/N);
            sum += probs[i]/N;
        }
        System.out.println(sum);
    }

    public static void main(String args[]) {
        TwoDice(); // 0 and 1 should have no rolls
    }
}
