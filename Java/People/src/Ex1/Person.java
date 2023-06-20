package Ex1;

public class Person {
    private String firstName;
    private String lastName;

    public Person () {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
    }

    public static void main(String[] args) {
        Person john = new Person("john", "appleseed");
        String fullName = john.firstName.concat(john.lastName);

        System.out.println(fullName);
    }

}
