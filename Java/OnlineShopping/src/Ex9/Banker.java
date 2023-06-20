package Ex9;


public class Banker {
    private String name;
    private int accountNumber;
    private int deposit;

    public Banker(String name, int accountNumber, int deposit) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.deposit = deposit;
    }

    public static void accessVault(int accountNumber, int deposit) {
        String manager = Manager.managerFound();
        System.out.printf("Hi, I am the manager, %s, let's deposit your money %n", manager);
        Manager.accessVault(accountNumber, deposit);
    }

    public static void main(String[] args) {
        Banker John = new Banker("John Piper", 431344123, 5000);
        String name = John.name;
        System.out.printf("Hey %s, lets find the manager and see we can get your money deposited %n", name);
        int accountNumber = John.accountNumber;
        int deposit = John.deposit;
        accessVault(accountNumber, deposit);

    }
}
