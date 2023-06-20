package Ex4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressCheck {
    public static void main(String[] args) {
        String regex = "(?<streetNumber>\\d{1,5})\\s+(?<streetName>.*),\\s*(?<city>.*),\\s*(?<state>[A-Z]{2})\\s*(?<zip>\\d{5})";

//        String regex2 = "(?<streetNumber>\\d{1,5})\\s(?<streetName>[\\w.,\\s]*)\\s(?<city>\\w{1,2}),\\s(?<state>\\w{2})\\s(?<zip>\\d{5})\n";
        String address = "1234 Compton Street, Locus Grove, GA 30123";

        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(address);

        mat.find();
        System.out.println(mat.group("streetNumber"));


//        System.out.println(address.matches(regex));
    }
}
