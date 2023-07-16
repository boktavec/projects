package util;

import java.util.ArrayList;

public class Hangman {

    private String hangman, word, guesses;
    private Integer guessedRight, guessedWrong;

    private ArrayList<Character> lettersGuessed;


    public Hangman() {

    }

    public Hangman(String hangman, String word, String guesses, Integer guessedRight, Integer guessedWrong, ArrayList<Character> lettersGuessed) {
        this.hangman = hangman;
        this.word = word;
        this.guesses = guesses;
        this.guessedRight = guessedRight;
        this.guessedWrong = guessedWrong;
        this.lettersGuessed = lettersGuessed;
    }

    public ArrayList<Character> getLettersGuessed() {
        return lettersGuessed;
    }

    public void setLettersGuessed(ArrayList<Character> lettersGuessed) {
        this.lettersGuessed = lettersGuessed;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setGuessedRight(Integer guessedRight) {
        this.guessedRight = guessedRight;
    }

    public Integer getGuessedWrong() {
        return guessedWrong;
    }

    public void setGuessedWrong(Integer guessedWrong) {
        this.guessedWrong = guessedWrong;
    }

    public void updateWrongCount() {
        this.guessedWrong = this.guessedWrong+1;
    }

    public void updateRightCount() {
        this.guessedRight = this.guessedRight+1;
    }

    @Override
    public String toString() {
        return "util.Hangman{" +
                "hangman='" + hangman + '\'' +
                ", word='" + word + '\'' +
                ", guesses='" + guesses + '\'' +
                ", lettersGuessed=" + lettersGuessed +
                '}';
    }
}
