package util;

public class GuessWord {

    private static int indexOfLetter;

    public static String guessLetter(Hangman game, String word, char letter, String guessed) {

        String guess = guessed;

        for(int i=0; i<word.length(); i++) {
            if(letter == word.charAt(i)){
                indexOfLetter = i;
                guess = alreadyGuessed(letter, guess, indexOfLetter);
                game.updateRightCount();

            }
        }

        return guess;
    }

    private static String alreadyGuessed(char letter, String guessed, int index) {
        char[] guessedToChar = guessed.toCharArray();
        guessedToChar[index] = letter;
        String newGuessed = new String(guessedToChar);

        return newGuessed;
    }

    public static String howManyToGuess(String word) {
        String guessed = "";

        for(int i=0; i<word.length(); i++) {
            guessed = String.format(guessed+"_");
        }
        return guessed;
    }

    public static String guessedWrong(int wrongGuesses){
        String hangMan = "";

        if(wrongGuesses == 1) {
            hangMan = "  O";
            return hangMan;
        }

        if(wrongGuesses == 2) {
            hangMan = "  O\n  |";
            return hangMan;
        }

        if(wrongGuesses == 3) {
            hangMan = "  O\n /|";
            return hangMan;
        }

        if(wrongGuesses == 4) {
            hangMan = "  O\n /|\\";
            return hangMan;
        }

        if(wrongGuesses == 5) {
            hangMan = "  O\n /|\\ \n /";
            return hangMan;
        }

        if(wrongGuesses == 6) {
            hangMan = "  O\n /|\\ \n / \\ \n";
            return hangMan;
        }

        return hangMan;

    }




}
