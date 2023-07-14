package CRUD;

import Contact.*;

import java.util.ArrayList;

public class DeleteContact {
    public static ArrayList<Contact> deleteContact(ArrayList<Contact> contacts, String firstName, String lastName) {

        int index = getIndex(contacts, firstName, lastName);

        contacts.remove(index);

        return contacts;


    };

    public static int getIndex(ArrayList<Contact> contacts, String firstName, String lastName) {
        int index=-1;

        for(int i=0; i< contacts.size(); i++) {
            if(contacts.get(i).getFirstName().equals(firstName) && contacts.get(i).getLastName().equals(lastName)) {
                index = i;
                return index;
            }
        }
        return index;
    }
}
