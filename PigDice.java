package com.techlab.pigdice;
import java.util.Scanner;

public class PigDice {
   
        private int targetScore;
        private int playerScore;
        private int turn;
        
        public PigDice() {
            this.targetScore = 20;
            this.playerScore = 0;
            this.turn = 1;
        }

        public void displayCurrentScore() {
            System.out.println("\nTurn " + turn + " sum of score after this turn: " + playerScore);
        }

        public void displayEndScore() {
            System.out.println("\nEnd in turn " + turn + " and sum of score: " + playerScore);
        }

        public void displayWinningMessage() {
            System.out.println("\n*********** Congratulations! *************");
            System.out.println("\nYou reached a score of " + playerScore + " and won the Game of Pig Dice.");
        }

        public void resetPlayerScore() {
            playerScore = 0;
            System.out.println("!!!Sorry After rolled the die you get 1, so your score is reset to 0.");
        }

        public void updatePlayerScore(int roll) {
            playerScore += roll;
        }

        public void incrementTurn() {
            turn++;
        }

        public boolean isWinningScoreReached() {
            return playerScore >= targetScore;
        }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame(scanner);

            System.out.print("Do you want to play again? if yes then press Y: ");
            String playAgainInput = scanner.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("y");
        } while (playAgain);

        System.out.println("*****Thank you for playing*******");
    }

    private static void playGame(Scanner scanner) {
    	PigDice gameState = new PigDice();

        System.out.println("**********Welcome to the Game of PIG DICE *********");
        

       while (true) {
            gameState.displayCurrentScore();
            System.out.print("Enter 'r' to roll or 'h' to hold: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("r")) {
                int roll = rollDice();
                System.out.println("You rolled " + roll);

                if (roll == 1) {
                    gameState.resetPlayerScore();
                } else {
                    gameState.updatePlayerScore(roll);
                }
            } else if (input.equalsIgnoreCase("h")) {
                System.out.println("You have chosen 'h' to hold. Your turn ends.");
                gameState.displayEndScore();
                break;
            } else {
                System.out.println("Invalid input. Please enter 'r' or 'h'.");
            }

            if (gameState.isWinningScoreReached()) {
                gameState.displayWinningMessage();
                break;
            }

            gameState.incrementTurn();
           }
        }
    

    private static int rollDice() {
        return (int) (Math.random() * 6) + 1;
        }
}



     
