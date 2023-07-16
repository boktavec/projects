package LibrarySystem;

public record Borrower(String borrowDate, String returnDate, String borrowersName) {
    @Override
    public String toString() {
        return "Borrower{" +
                "borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", borrowersName='" + borrowersName + '\'' +
                '}';
    }
}

