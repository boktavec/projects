package functionality;

import java.util.ArrayList;

public class SelectSeat {

    public static ArrayList<Integer> seatSelected(ArrayList<Integer> openSeats, Integer seatSelected) {

        for (int i = 0; i < openSeats.size(); i++) {
            if (openSeats.get(i) == seatSelected) {
                openSeats.remove(seatSelected);
                return openSeats;
            }
        }

        return openSeats;
    };

}
