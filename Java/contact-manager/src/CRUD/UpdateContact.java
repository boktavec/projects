package CRUD;

import Contact.Contact;

import java.util.ArrayList;

import static CRUD.DeleteContact.getIndex;

public class UpdateContact {
    public static void updateContact(ArrayList<Contact> contactList, String firstName, String lastName, String newFirstName, String newLastName, String newNumber) {

        int indexOfContact = getIndex(contactList, firstName, lastName);
        Contact contactToUpdate = contactList.get(indexOfContact);

        contactToUpdate.setFirstName(newFirstName);
        contactToUpdate.setLastName(newLastName);
        contactToUpdate.setPhoneNumber(newNumber);


    }
}
