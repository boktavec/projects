package functionality;

import java.util.ArrayList;

import static functionality.SelectSeat.seatSelected;

public class Movies {
    private String movieName, movieTime, movieDate, movieTheater;
    private double moviePrice;

    private ArrayList<Integer> movieSeats;

    public Movies(String movieName, String movieTime, String movieDate, String movieTheater, double moviePrice, ArrayList<Integer> movieSeats) {
        this.movieName = movieName.toLowerCase();
        this.movieTime = movieTime;
        this.movieDate = movieDate;
        this.movieTheater = movieTheater.toUpperCase();
        this.moviePrice = moviePrice;
        this.movieSeats = movieSeats;


    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public String getMovieTheater() {
        return movieTheater;
    }

    public double getMoviePrice() {
        return moviePrice;
    }
    public ArrayList<Integer> getMovieSeats() {
        return movieSeats;
    }


    @Override
    public String toString() {
        return "{" +
                "movieName='" + movieName + '\'' +
                ", movieTime='" + movieTime + '\'' +
                ", movieDate='" + movieDate + '\'' +
                ", movieTheater='" + movieTheater + '\'' +
                ", moviePrice=" + moviePrice +
                ", movieSeats=" + movieSeats +
                '}';
    }

    public void bookSeat(int seatSelection) {
        ArrayList<Integer> seatsLeft = seatSelected(this.movieSeats, seatSelection);
        this.movieSeats = seatsLeft;

    }

}
