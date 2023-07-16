import java.util.Scanner;

public class Main {

    static String name = "Tyler James";
    static double balance = 1000.00;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, " + name + " what would you like to do? \n 1. View account\n 2. Deposit\n 3. Withdraw\n 4. Change the name of the account\n");
        int response = scanner.nextInt();

        switch (response) {
            case 1:
                String bankResponse = accountOverview();
                System.out.println(bankResponse);
                break;
            case 2:
                System.out.println("How much do you want to deposit into your account?");
                double amount = scanner.nextInt();
                deposit(amount);
                System.out.println("Your new balance is: " + balance);
                break;
            case 3:
                System.out.println("How much would you like to withdraw from your account?");
                amount = scanner.nextInt();
                double withdrawal = withdraw(amount);
                if(withdrawal == -1) {
                    System.out.println("Insufficient funds, please try again!");
                    break;
                }
                System.out.println("Your new balance is: " + withdrawal);
                break;
            case 4:
                System.out.println("What is the new first name of the account holder?");
                String newFirst = scanner.next();
                System.out.println("What is the new last name of the account holder?");
                String newLast = scanner.next();
                changeName(newFirst, newLast);
                System.out.println("The account owner's name is now: " + name);
                break;
            default:
                System.out.println("ERROR\nPlease try again!");
        }


    }

    public static void deposit(double amount) {
        balance = balance + amount;
    }

    public static double withdraw(double amount) {
        if (amount > balance) {
            return -1;
        }

        double newBalance = balance - amount;
        return newBalance;
    }


    public static void changeName(String first, String last) {
        name = first + " " + last;

    }

    public static String accountOverview() {
        return "Account owner: " + name + "\nBalance: " + balance;
    }
}
