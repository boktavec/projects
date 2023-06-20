package Ex9;

public class BankVault {
    public static void hasAccess(int password, int deposit) {
        vaultAccessed();
        depositMoney(deposit);
    }

    private static void vaultAccessed() {
        System.out.println("Vault has been accessed");
    }

    private static void depositMoney(int deposit) {
        System.out.printf("%d dollars has been deposited into the vault", deposit);
    }
}
