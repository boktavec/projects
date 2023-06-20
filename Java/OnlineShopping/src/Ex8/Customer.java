package Ex8;

public class Customer {
    private String name;
    private int accountNumber;


    public Customer() {

    }

    public Customer(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public static void accessVault(int accountNumber) {
        System.out.println("Account Manager found");
        BankManager.accessVault(accountNumber);
    }

    public static void main(String[] args) {
        Customer John = new Customer("John Piper", 431344123);
        int accountNumber = John.accountNumber;
        accessVault(accountNumber);

    }

}
