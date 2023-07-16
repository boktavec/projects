import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Integer randomNumber = random.nextInt(10);

        System.out.println("Guess a number between 0 and 10.");
        int guess = scanner.nextInt();

        String response = NumberCheck(randomNumber, guess);
        System.out.println(response);

    }

    public static String NumberCheck(int correct, int guess) {
        if(correct == guess) {
            return "You guessed correct!";
        }

        return "That is wrong, the correct answer was " + correct;
    }

}
