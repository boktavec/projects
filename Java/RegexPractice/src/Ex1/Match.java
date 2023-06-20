package Ex1;

public class Match {
    public static void main(String[] args) {
        String regex = "\\w{1,2}ark";

        System.out.println("park".matches(regex));

    }
}
