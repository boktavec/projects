package CRUD;
import Contact.*;


public class CreateContact {

    public static Contact createContact(String firstName, String lastName, String phoneNumber) {

        Contact contact = new Contact(firstName, lastName, phoneNumber);
        return contact;
    }

}
