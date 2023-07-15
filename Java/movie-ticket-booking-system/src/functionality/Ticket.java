package functionality;

public class Ticket {
    private String firstName, lastName, movieName, movieDate, movieTime, movieTheater;
    private double moviePrice;
    private int seatSelection;

    public Ticket(String firstName, String lastName, String movieName, String movieDate, String movieTime, String movieTheater, double moviePrice, int seatSelection) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
        this.movieTheater = movieTheater;
        this.moviePrice = moviePrice;
        this.seatSelection = seatSelection;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getMovieName() {
        return movieName;
    }

    public String getMovieDate() {
        return movieDate;
    }


    public String getMovieTime() {
        return movieTime;
    }


    public String getMovieTheater() {
        return movieTheater;
    }

    public double getMoviePrice() {
        return moviePrice;
    }


    public int getSeatSelection() {
        return seatSelection;
    }


    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieDate='" + movieDate + '\'' +
                ", movieTime='" + movieTime + '\'' +
                ", movieTheater='" + movieTheater + '\'' +
                ", moviePrice=" + moviePrice +
                ", seatSelection=" + seatSelection +
                '}';
    }
}
