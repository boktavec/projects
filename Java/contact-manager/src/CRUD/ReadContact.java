package CRUD;

import Contact.Contact;

import java.util.ArrayList;

import static CRUD.DeleteContact.getIndex;

public class ReadContact {
    public static String viewContact(ArrayList<Contact> contactList, String firstName, String lastName) {

        int indexOfContact = getIndex(contactList, firstName, lastName);
        Contact person = contactList.get(indexOfContact);
        String fName = person.getFirstName().toUpperCase();
        String lName = person.getLastName().toUpperCase();
        String number = person.getPhoneNumber().toUpperCase();

        String response = String.format("Contact info:\nFirst name: %s\nLast name: %s\nPhone number: %s\n\n", fName, lName, number);

        return response;
    }

}
