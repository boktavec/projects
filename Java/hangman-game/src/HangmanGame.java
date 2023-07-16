import util.GuessWord;
import util.Hangman;
import util.RandomWordGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Hangman game = new Hangman();
        ArrayList<Character> guesses = new ArrayList<>();
        game.setGuessedRight(0);
        game.setGuessedWrong(0);
        game.setLettersGuessed(guesses);
;
        String possibilities;
        String wrong, letter;
        char letterChar;
        int wrongCount;

        game.setWord(RandomWordGenerator.getRandomWord());

        String wordToGuess = game.getWord();
        possibilities = GuessWord.howManyToGuess(wordToGuess);

        while (true) {
            System.out.println("What is your guess?");
            game.getLettersGuessed();
            letter = scanner.nextLine().toLowerCase();
            letterChar = letter.charAt(0);


            String guess = GuessWord.guessLetter(game, wordToGuess, letterChar, possibilities);
            if(guess.equals("-1")){
                game.updateWrongCount();
                wrongCount = game.getGuessedWrong();
                game.getLettersGuessed().add(letterChar);
                wrong = GuessWord.guessedWrong(wrongCount);
                System.out.println(wrong);

            } else {
                possibilities = guess;
                game.updateRightCount();
                game.getLettersGuessed().add(letterChar);


            }

            guesses = game.getLettersGuessed();

            System.out.println(possibilities);
            System.out.println("Letters guess:");
            System.out.println(guesses);

            if(checkGame(possibilities) == 0){
                System.out.println("YOU WON!");
                return;
            }

            if(game.getGuessedWrong() == 6 ){
                System.out.println("YOU LOST");
                return;
            }
        }



    }

    public static Integer checkGame(String guess) {
        for(int i=0; i<guess.length(); i++) {
            if(guess.charAt(i) == '_'){
                return 1;
            }
        }
        return 0;
    }

}
