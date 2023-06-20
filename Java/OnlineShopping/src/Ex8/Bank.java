package Ex8;

public class Bank {

    public static void hasAccess(int password) {
        vaultAccessed();
    }

    private static void vaultAccessed() {
        System.out.println("Vault has been accessed");
    }

}
