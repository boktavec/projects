import functionality.Databases;
import functionality.Movies;
import functionality.Ticket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import static functionality.BookTicket.bookTicket;

public class Main {

    public static Databases movieTheater = new Databases();
    static ArrayList<Integer> movieSeats = new ArrayList();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        setSeatCapacity(24);

        Movies topGun = new Movies("top gun", "9:00PM", "5/5/2023","Regal", 12.00, movieSeats);
        Movies spiderMan = new Movies("spiderman 2", "5:00PM", "5/3/2023","iMax", 14.00, movieSeats);
        Movies catchMeIfYouCan = new Movies("catch me if you can", "1:00PM", "4/31/2023","Movie Tavern", 21.00, movieSeats);
        Movies fireproof = new Movies("Fireproof", "10:00AM", "5/7/2023","Dollar Theater", 11.00, movieSeats);


        movieTheater.moviesShowing.put(topGun.getMovieName(), topGun);
        movieTheater.moviesShowing.put(spiderMan.getMovieName(), spiderMan);
        movieTheater.moviesShowing.put(catchMeIfYouCan.getMovieName(), catchMeIfYouCan);
        movieTheater.moviesShowing.put(fireproof.getMovieName(), fireproof);

        bookTicket("brian", "last", "fireproof", 12);
        bookTicket("john", "self", "catch me if you can", 22);


        while (true) {
            System.out.println("\nWhat would you like to do? \n1. View movie showings\n2. Buy a ticket\n3. Show my tickets\n4. Exit");
            int response = scanner.nextInt();
            scanner.nextLine();

            if(response == 1) {
                Iterator<Map.Entry<String, Movies>> iterator = movieTheater.moviesShowing.entrySet().iterator();

                while(iterator.hasNext()) {
                    Map.Entry<String, Movies> entry = iterator.next();
                    Movies movie = entry.getValue();
                    System.out.printf("---------------------\nMovie Title: %s\nStart time: %s\nDate: %s\nTheater: %s\nPrice: %.2f\nSeats available: %s\n", movie.getMovieName().toUpperCase(), movie.getMovieTime(), movie.getMovieDate(), movie.getMovieTheater().toUpperCase(), movie.getMoviePrice(), movie.getMovieSeats());

                }

            }

            if(response == 2) {
                System.out.println("what is your first name?");
                String fName = scanner.nextLine();
                System.out.println("what is your last name?");
                String lName = scanner.nextLine();
                System.out.println("What movie do you want to watch?\n\n1. Top Gun\n2. Spiderman 2\n3. Catch Me If You Can\n4. Fireproof");
                int movie = scanner.nextInt();
                System.out.println(movieSeats);
                System.out.println("Where do you want to sit?");
                int seat = scanner.nextInt();
                if(movie == 1){
                    bookTicket(fName, lName, "top gun", seat);
                }
                if(movie == 2){
                    bookTicket(fName, lName, "spiderman 2", seat);
                }
                if(movie == 3){
                    bookTicket(fName, lName, "catch me if you can", seat);
                }
                if(movie == 4){
                    bookTicket(fName, lName, "fireproof", seat);
                }

            }
            if(response == 3) {
                Iterator<Map.Entry<String, Ticket>> iterator = movieTheater.ticketsBooked.entrySet().iterator();

                while(iterator.hasNext()) {
                    Map.Entry<String, Ticket> entry = iterator.next();
                    Ticket ticket = entry.getValue();
                    System.out.printf("---------------------\nFirst name: %s\nLast name: %s\nMovie: %s\nDate: %s\nTime: %s\nTheater: %s\nPrice: %.2f\nSeat: %d\n", ticket.getFirstName().toUpperCase(), ticket.getLastName().toUpperCase(), ticket.getMovieName().toUpperCase(), ticket.getMovieDate(), ticket.getMovieTime(), ticket.getMovieTheater().toUpperCase(), ticket.getMoviePrice(), ticket.getSeatSelection());

                }
            }
            if(response == 4){
                System.out.println("Enjoy your movie!!!");
                return;
            }

        }



    }

    public static void setSeatCapacity(int capacity) {
        for(int i=0; i<capacity; i++){
            movieSeats.add(i+1);
        }
    }
}
