import Contact.Contact;

import java.util.ArrayList;
import java.util.Scanner;

import static CRUD.CreateContact.createContact;
import static CRUD.DeleteContact.deleteContact;
import static CRUD.UpdateContact.updateContact;
import static CRUD.ReadContact.viewContact;
import static Find.ListAlphabeticalAZ.alphabeticalListAZ;
import static Find.ListAlphabeticalZA.alphabeticalListZA;

public class Main {
    public static void main(String[] args) {

        ArrayList<Contact> contactList = new ArrayList<>();

        Contact contact1 = createContact("brian", "oktavec", "6784723222");
        Contact contact2 = createContact("taylor", "jones", "4045361796");
        Contact contact3 = createContact("jack", "harol", "4053261796");
        Contact contact4 = createContact("william", "wake", "4045342136");
        Contact contact5 = createContact("peter", "piper", "7124361796");

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\nWhat would  you like to do?\n1. Search for contact\n2. Update contact\n3. Delete contact\n4. Add contact\n5. View contacts\n6. View in alphabetical order A-Z\n7. View in alphabetical order Z-A\n8. Exit");
            int response = scanner.nextInt();
            scanner.nextLine();

            if(response == 1) {
                System.out.println("What is the first name");
                String fName = scanner.nextLine().toLowerCase();
                System.out.println("What is the last name?");
                String lName = scanner.nextLine().toLowerCase();
                System.out.println(viewContact(contactList, fName, lName));
            }
            if(response == 2) {
                System.out.println("What is the first name of the contact to update?");
                String fName = scanner.nextLine().toLowerCase();
                System.out.println("What is the last name of the contact to update?");
                String lName = scanner.nextLine().toLowerCase();
                System.out.println("What is the new first name of the contact");
                String fNewName = scanner.nextLine().toLowerCase();
                System.out.println("What is the new last name of the contact");
                String lNewName = scanner.nextLine().toLowerCase();
                System.out.println("What is the new number of the contact");
                String newNumber = scanner.nextLine();
                updateContact(contactList, fName, lName, fNewName, lNewName,newNumber);
                System.out.println("\nContact has been updated");
            }
            if(response == 3) {
                System.out.println("What is the first name of the contact you want to delete?");
                String fName = scanner.nextLine().toLowerCase();
                System.out.println("What is the last name of the contact you want to delete?");
                String lName = scanner.nextLine().toLowerCase();
                deleteContact(contactList, fName, lName);
                System.out.println("\nContact has been deleted");
            }
            if(response == 4) {
                System.out.println("What is the first name of the contact you want ot add?");
                String fName = scanner.nextLine().toLowerCase();
                System.out.println("What is the last name of the contact you want ot add?");
                String lName = scanner.nextLine().toLowerCase();
                System.out.println("What is the number of the contact you want ot add?");
                String number = scanner.nextLine();
                Contact contact = createContact(fName, lName, number);
                contactList.add(contact);
                System.out.println("\nContact has been added");
            }
            if(response == 5) {
                System.out.println("Your contacts:\n");

                for(int i=0; i<contactList.size(); i++) {
                    Contact person = contactList.get(i);
                    String fName = person.getFirstName().toUpperCase();
                    String lName = person.getLastName().toUpperCase();
                    String number = person.getPhoneNumber().toUpperCase();

                    System.out.printf("\nFirst name: %s\nLast name: %s\nPhone number: %s\n\n", fName, lName, number);
                }
            }
            if(response == 6) {
                System.out.println("Your contacts - A to Z:\n\n");
                contactList = alphabeticalListAZ(contactList);

                for(int i=0; i<contactList.size(); i++) {
                    Contact person = contactList.get(i);
                    String fName = person.getFirstName().toUpperCase();
                    String lName = person.getLastName().toUpperCase();
                    String number = person.getPhoneNumber().toUpperCase();

                    System.out.printf("\nFirst name: %s\nLast name: %s\nPhone number: %s\n\n", fName, lName, number);
                }
            }
            if(response == 7) {
                System.out.println("Your contacts - A to Z:\n\n");
                contactList = alphabeticalListZA(contactList);

                for(int i=0; i<contactList.size(); i++) {
                    Contact person = contactList.get(i);
                    String fName = person.getFirstName().toUpperCase();
                    String lName = person.getLastName().toUpperCase();
                    String number = person.getPhoneNumber().toUpperCase();

                    System.out.printf("\nFirst name: %s\nLast name: %s\nPhone number: %s\n\n", fName, lName, number);
                }
            }
            if(response == 8) {
                System.out.println("\n\nHave a nice day!");
                break;
            }

        }


    }
}
