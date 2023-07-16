import LibrarySystem.Book;
import LibrarySystem.Borrower;
import LibrarySystem.CatalogManager;

import java.util.ArrayList;
import java.util.Iterator;

import static LibrarySystem.utils.*;

public class Main {
    public static void main(String[] args) {

        CatalogManager catalog = new CatalogManager();

        Book hungerGames = new Book("Suzanne Collins", "The Hunger Games");
        Book catchingFire = new Book("Suzanne Collins", "Catching Fire");
        Book mockingJay = new Book("Suzanne Collins", "Mockingjay");
        Book bible = new Book("Jesus", "bible");
        Book percyJacksonLightningTheir = new Book("Ricky Riordan", "Percy Jackson and the Lightning Thief");

        Borrower borrower = new Borrower("5/5/2021", "6/5/2021", "Jack Daniels");
        Borrower borrower1 = new Borrower("7/5/2021", "8/5/2021", "Jamie Stuart");
        Borrower borrower2 = new Borrower("3/4/2019", "5/1/2019", "Tim Taylor");
        Borrower borrower3 = new Borrower("4/12/2013", "5/1/2014", "Bo Jackson");
        Borrower borrower4 = new Borrower("3/4/2012", "5/1/2012", "Billy Bob");

        hungerGames.updateBorrowHistory(borrower);
        catchingFire.updateBorrowHistory(borrower1);
        mockingJay.updateBorrowHistory(borrower2);
        bible.updateBorrowHistory(borrower3);
        percyJacksonLightningTheir.updateBorrowHistory(borrower);
        percyJacksonLightningTheir.updateBorrowHistory(borrower4);


        catalog.catalogSystem.put("hunger-games", hungerGames);
        catalog.catalogSystem.put("catching-fire", catchingFire);
        catalog.catalogSystem.put("mockingjay", mockingJay);
        catalog.catalogSystem.put("bible", bible);
        catalog.catalogSystem.put("percy-jackson-lightning-thief", bible);


        ArrayList<String> historyEntries = getBookHistory(catalog.catalogSystem.get("hunger games").getBorrowHistory());

        System.out.println("Rental history for The Hunger Games");
        Iterator<String> iterator = historyEntries.iterator();
        while(iterator.hasNext()) {
            String entry = iterator.next();
            System.out.println(entry);
        }
    }


}
