package Ex9;

public class Manager {
    private static String name = "Jason";

    public static String managerFound() {
        return name;
    }

    public static void accessVault(int accountNumber, int deposit) {
        System.out.printf("Account number: %d%n", accountNumber);
        BankVault.hasAccess(1234, deposit);

    }
}
