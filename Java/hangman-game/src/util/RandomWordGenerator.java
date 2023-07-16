package util;

import java.util.Random;

public class RandomWordGenerator {

    private static String[] words = {"apple", "pear", "mango", "grape", "berry"};
    private static String randomWord;
    public static String getRandomWord() {

        Random random = new Random();

        int wordIndex = random.nextInt(words.length);

        randomWord = words[wordIndex];

        return randomWord;
    }
}
