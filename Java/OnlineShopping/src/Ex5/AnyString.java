package Ex5;

import java.util.Arrays;

public class AnyString {
    public static void Whatever(String... words) {
        System.out.println(Arrays.toString(words));

    }

    public static void main(String[] args) {
        Whatever("how old are you", "keep up");
    }
}
