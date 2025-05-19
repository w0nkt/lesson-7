package com.codedotorg;

import java.util.Random;

public class GameLogic {

    private boolean gameOver = false;

    /**
     * Randomly selects "rock", "paper", or "scissors" for the computer.
     * @return the computer's choice as a String.
     */
    public String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random rand = new Random();
        int index = rand.nextInt(choices.length);
        return choices[index];
    }

    /**
     * Determines the winner of a round based on user and computer choices.
     * @param predictedClass The user's predicted gesture ("rock", "paper", or "scissors").
     * @param computerChoice The computer's choice ("rock", "paper", or "scissors").
     * @return A string describing the round's outcome.
     */
    public String determineWinner(String predictedClass, String computerChoice) {
        if (predictedClass.equals(computerChoice)) {
            return getTieResult();
        }
        // User wins
        if ((predictedClass.equals("rock") && computerChoice.equals("scissors")) ||
            (predictedClass.equals("paper") && computerChoice.equals("rock")) ||
            (predictedClass.equals("scissors") && computerChoice.equals("paper"))) {
            return getUserWinnerResult();
        }
        // Computer wins
        return getComputerWinnerResult();
    }

    /**
     * Handles a tie result.
     * @return A string indicating a tie.
     */
    public String getTieResult() {
        gameOver = true;
        return "It's a tie! Play again?";
    }

    /**
     * Handles when the user wins.
     * @return A string indicating the user won.
     */
    public String getUserWinnerResult() {
        gameOver = true;
        return "You win! 🎉";
    }

    /**
     * Handles when the computer wins.
     * @return A string indicating the computer won.
     */
    public String getComputerWinnerResult() {
        gameOver = true;
        return "Computer wins! 🤖";
    }

    /**
     * Returns whether the game is over.
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Resets the game over flag for a new round.
     */
    public void resetGame() {
        gameOver = false;
    }
}
