package Ex2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Capture {
    public static void main(String[] args) {
        String regex = "A(\\w{3})cada(\\w{3})";
        String words = "Abracadabra";
        String word = "Agracadagra";

        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(word);

        if (mat.matches()) {
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
        }
    }
}
