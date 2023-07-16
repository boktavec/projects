package LibrarySystem;

import java.util.ArrayList;

public class Book {
    private String authorName, bookName;
    private ArrayList<Borrower> borrowHistory;

    ArrayList<Borrower> history = new ArrayList<>();


    public Book(String authorName, String bookName) {
        this.authorName = authorName.toUpperCase();
        this.bookName = bookName.toUpperCase();
        this.borrowHistory = history;
    }


    public void updateBorrowHistory(Borrower checkout) {
        this.borrowHistory.add(checkout);

    }

    public ArrayList<Borrower> getBorrowHistory() {
        return borrowHistory;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "{" +
                "authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", borrowHistory=" + borrowHistory +
                '}';
    }
}
