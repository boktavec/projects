package Find;

import Contact.Contact;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static Find.ListAlphabeticalAZ.getFirstInitialPosition;

public class ListAlphabeticalZA {
    public static ArrayList<Contact> alphabeticalListZA(ArrayList<Contact> contactList) {

        ArrayList<Contact> zToA = new ArrayList();
        TreeMap<Integer, Contact> treeMap = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < contactList.size(); i++) {

            String firstName = contactList.get(i).getFirstName();

            Integer namePosition = getFirstInitialPosition(firstName);
            treeMap.put(namePosition, contactList.get(i));

        }

        for (Map.Entry<Integer, Contact> entry : treeMap.entrySet()) {
            Contact contact = entry.getValue();
            zToA.add(contact);
        }

        return zToA;
    }
}
