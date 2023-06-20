package Ex3;

public class NoSpace {
    public static String text(String text) {
        return text.strip();
    }

    public static void main(String[] args) {
        System.out.println(text("    Hey friend you are looking great today!      "));
    }
}
