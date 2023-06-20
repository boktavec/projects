package Ex1;

import java.util.Arrays;

public class Customer {

    private String firstName;
    private String lastName;
    private Object[] order;

    public Customer() {

    }

    public Customer(String firstName, String lastName, Object[] order) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.order = order;
    }

    public void displayHistory (String first, String last, Object[] orders) {
        firstName = first;
        lastName = last;
        order = orders;
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(Arrays.toString(orders));

    }


    public static void main(String[] args) {
        Customer john = new Customer();
        OutfitOrdered order = new OutfitOrdered();
        Object[] Outfit = OutfitOrdered.clothesSelected(1,2,3);

        john.displayHistory("john", "johnson", Outfit);
//        System.out.println(john);

    }

}
