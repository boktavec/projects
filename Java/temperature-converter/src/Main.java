import java.util.Scanner;

public class Main {
    static double temp, converted;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a conversion method: \n1. Celsius-to-Fahrenheit \n2. Fahrenheit-to-Celsius");
        int method = scanner.nextInt();

        switch (method) {
            case 1:
                System.out.println("Enter the Celsius temperature:");
                temp = scanner.nextDouble();
                converted = convertToF(temp);

                System.out.println("The temperate in Fahrenheit is: " + converted);
                break;
            case 2:
                System.out.println("Enter the Fahrenheit temperature:");
                temp = scanner.nextDouble();
                converted = convertToC(temp);

                System.out.println("The temperate in Celsius is: " + converted);
                break;
            default:
                System.out.println("Invalid method, please try again!");
        }

    }

    public static Double convertToC(double x) {
        double celsius = (x-32)*5/9;

        return celsius;
    }

    public static Double convertToF(double x) {
        double fahrenheit = (x*9/5)+32;

        return fahrenheit;
    }
}
