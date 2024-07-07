import java.util.Random;

public class Dice {
    private static final Random random = new Random();

    //*between min (min) and (max) */ 
    public static int roll(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
