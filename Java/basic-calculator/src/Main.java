import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        double sum;

        while (true) {
            System.out.println("What calculation would you like to do?\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exit the application\n\nYour selection is: ");
            int selection = scanner.nextInt();
            scanner.nextLine();

            if(selection == 1) {
                System.out.println("\nYou selected: Addition\n Please enter your two numbers with a space between them:");
                x = scanner.nextInt();
                y = scanner.nextInt();
                sum = add(x, y);
                System.out.println("The answer is: " + sum);
            }
            if(selection == 2) {
                System.out.println("\nYou selected: Subtraction\n Please enter your two numbers with a space between them:");
                x = scanner.nextInt();
                y = scanner.nextInt();
                sum = subtract(x, y);
                System.out.println("The answer is: " + sum);
            };
            if(selection == 3) {
                System.out.println("\nYou selected: Multiplication\n Please enter your two numbers with a space between them:");
                x = scanner.nextInt();
                y = scanner.nextInt();
                sum = multiply(x, y);
                System.out.println("The answer is: " + sum);
            }
            if(selection == 4) {
                System.out.println("\nYou selected: Division\n Please enter your two numbers with a space between them:");
                x = scanner.nextInt();
                y = scanner.nextInt();
                sum = divide(x, y);
                System.out.println("The answer is: " + sum);
            }
            if(selection == 5) {
                System.out.println("Goodbye!");
                break;
            }
        }

    }

    public static int add(int x, int y) {
        int sum;

        sum = x + y;

        return sum;
    }

    public static int subtract(int x, int y) {
        int sum;

        sum = x-y;

        return sum;
    }

    public static int multiply(int x, int y) {
        int sum;

        sum = x*y;

        return sum;
    }

    public static double divide(int x, int y) {
        double sum;

        sum = (double) x/y;

        return sum;
    }


}
