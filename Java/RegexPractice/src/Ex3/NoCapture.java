package Ex3;

public class NoCapture {
    public static void main(String[] args) {
        String regex = "c(\\w+)el";

        System.out.println("camel".matches(regex));
    }
}
