package Ex11;

public class Friends {
    public static String[] friends = {"Brian", "Amelia", "Emmett"};

    public String[] getFriends() {
        return Friends.friends;
    }

    public static void main(String[] args) {
        Friends friend1 = new Friends();
        Friends friend2 = new Friends();
        Friends friend3 = new Friends();

        System.out.println(friend1.getFriends()[0]);
        System.out.println(friend1.getFriends()[1]);
        System.out.println(friend1.getFriends()[2]);

        System.out.println(friend2.getFriends()[0]);
        System.out.println(friend2.getFriends()[1]);
        System.out.println(friend2.getFriends()[2]);

        System.out.println(friend3.getFriends()[0]);
        System.out.println(friend3.getFriends()[1]);
        System.out.println(friend3.getFriends()[2]);
    }

}
