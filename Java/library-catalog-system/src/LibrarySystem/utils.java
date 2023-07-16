package LibrarySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class utils {
    public static ArrayList<String> getAuthorCollection(HashMap<String, Book> catalog, String author) {
        ArrayList<String> bookNames = new ArrayList<>();
        for(Map.Entry<String, Book> entry : catalog.entrySet()) {
            Book bookInSystem = entry.getValue();
            String authorInSystem = bookInSystem.getAuthorName();
            author = author.toUpperCase();

            if(author.equals(authorInSystem)) {
                bookNames.add(bookInSystem.getBookName());
            }

        }

        return bookNames;
    }

    public static ArrayList<String> getAuthors(HashMap<String, Book> catalog) {
        ArrayList<String> listOfAuthors = new ArrayList<>();

        for(Map.Entry<String, Book> entry : catalog.entrySet()) {
            Book bookInSystem = entry.getValue();
            String authorInSystem = bookInSystem.getAuthorName();
            authorInSystem = authorInSystem.toUpperCase();

            if(!listOfAuthors.contains(authorInSystem)){
                listOfAuthors.add(authorInSystem);
            }


        }
        return listOfAuthors;
    }

    public static ArrayList<String> getBooks(HashMap<String, Book> catalog) {
        ArrayList<String> listOfBooks = new ArrayList<>();

        for(Map.Entry<String, Book> entry : catalog.entrySet()) {
            Book bookInSystem = entry.getValue();
            String bookInCatalog = bookInSystem.getBookName();
            bookInCatalog = bookInCatalog.toUpperCase();

            if(!listOfBooks.contains(bookInCatalog)){
                listOfBooks.add(bookInCatalog);
            }


        }
        return listOfBooks;
    }

    public static ArrayList<String> getBookHistory(ArrayList<Borrower> bookHistory) {
        ArrayList<String> listOfHistory = new ArrayList<>();

        Iterator<Borrower> iterator = bookHistory.iterator();

        while(iterator.hasNext()) {
            Borrower history = iterator.next();
            String historyString = String.format("\nRenter's name: %s\nRented: %s\nReturned: %s", history.borrowersName(), history.borrowDate(), history.returnDate());
            listOfHistory.add(historyString);

        }
        return listOfHistory;
    }
}
