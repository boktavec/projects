package Find;

import Contact.Contact;

import java.util.ArrayList;
import java.util.Iterator;


public class SearchList {
    public static Contact findContact(ArrayList<Contact> contactList, String firstName, String lastName) {
        Iterator<Contact> iterator = contactList.iterator();
        while(iterator.hasNext()) {
            Contact person = iterator.next();
            if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }
}
