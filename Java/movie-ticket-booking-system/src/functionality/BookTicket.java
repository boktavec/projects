package functionality;
public class BookTicket {

    private static Databases boughtTickets = new Databases();

    private static String fName, lName, mName, mDate, mTime, mTheater;
    private static double mPrice;

    public static void bookTicket(String firstName, String lastName, String movieName, int seatSelection) {
        Movies movie = boughtTickets.moviesShowing.get(movieName);

        fName = firstName.toLowerCase();
        lName = lastName.toLowerCase();
        mName = movie.getMovieName().toLowerCase();
        mDate = movie.getMovieDate();
        mTime = movie.getMovieTime();
        mTheater = movie.getMovieTheater().toLowerCase();
        mPrice = movie.getMoviePrice();

        Ticket ticket = new Ticket(fName, lName, mName, mDate, mTime, mTheater, mPrice, seatSelection);

        String name = String.format(firstName + " " + lastName);

        boughtTickets.ticketsBooked.put(name, ticket);

        boughtTickets.moviesShowing.get(movieName).bookSeat(seatSelection);

    }
}
