import java.util.Random;
import java.util.Scanner;

public class Main {
    static String answer, winner;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter: rock, paper or scissors");
        answer = scanner.next();

        int choice = random.nextInt(3);

        switch (choice) {
            case 0:
                winner = rock(answer.toLowerCase());
                System.out.println(winner);
                break;
            case 1:
                winner = paper(answer.toLowerCase());
                System.out.println(winner);
                break;
            case 2:
                winner = scissors(answer.toLowerCase());
                System.out.println(winner);
                break;
            default:
                System.out.println("Please try again");
        }

    }

    public static String rock(String x) {
        if(x.equals("rock")) {
            return "You both chose rock, play again!";
        }
        if(x.equals("scissors")) {
            return "The computer chose rock, you lost!";
        }
        if(x.equals("paper")) {
            return "The computer chose rock, you won!";
        }
        return "Input was invalid, please try again";
    }

    public static String paper(String x) {
        if(x.equals("paper")) {
            return "You both chose paper, play again!";
        }
        if(x.equals("rock")) {
            return "The computer chose paper, you lost!";
        }
        if(x.equals("scissors")) {
            return "The computer chose paper, you won!";
        }

        return "Input was invalid, please try again";
    }

    public static String scissors(String x) {
        if(x.equals("scissors")) {
            return "You both chose scissors, play again!";
        }
        if(x.equals("paper")) {
            return "The computer chose scissors, you lost!";
        }
        if(x.equals("rock")) {
            return "The computer chose scissor, you won!";
        }
        return "Input was invalid, please try again";
    }

}
