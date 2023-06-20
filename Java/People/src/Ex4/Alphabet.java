package Ex4;

public class Alphabet {
    public static String whatever(String text) {
        String blank = text.strip();
        int lastLetter = text.lastIndexOf(blank);
        String lastLetterUpper = blank.substring(lastLetter-1).toUpperCase();
        return blank.substring(0, lastLetter-1).concat(lastLetterUpper);

    }

    public static void main(String[] args) {
        System.out.println(whatever("        alphabet      "));
    }
}
