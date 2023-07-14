package Find;
import Contact.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ListAlphabeticalAZ {
    public static ArrayList<Contact> alphabeticalListAZ(ArrayList<Contact> contactList) {

        ArrayList<Contact> aToZ = new ArrayList();
        TreeMap<Integer, Contact> treeMap = new TreeMap<>();

        for(int i=0; i<contactList.size(); i++) {

            String firstName = contactList.get(i).getFirstName();

            Integer namePosition = getFirstInitialPosition(firstName);
            treeMap.put(namePosition, contactList.get(i));

        }

        for(Map.Entry<Integer, Contact> entry : treeMap.entrySet()) {
            Contact contact = entry.getValue();
            aToZ.add(contact);
        }

        return aToZ;
    }

    public static int getFirstInitialPosition(String fName) {
        char fInitial = fName.charAt(0);
        fInitial = Character.toLowerCase(fInitial);

        int ranking = fInitial - 'a'+1;


        return ranking;
    }

}
