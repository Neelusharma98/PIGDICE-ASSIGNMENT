package Assignment;
import java.util.Scanner;

public class GameWithDie {
    public static void main(String[] args) {
        int targetScore = 20;
        int playerScore = 0;
        int turn = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("**********Welcome to the Game of  PIG DICE *********");

        while (true) {
            System.out.println("\nTurn " + turn + ". Current sum of score: " + playerScore);
            System.out.print("Enter 'r' to roll or 'h' to hold: ");
            String input = scanner.nextLine();

            if (input.equals("r")) {
                int roll = rollDice();
                System.out.println("You rolled a " + roll);

                if (roll == 1) {
                    playerScore = 0;
                    System.out.println("Oops! actually you got 1 after rolled the dice so your score is reset to 0.");
                   
                } 
                else {
                    playerScore += roll;
                }
            } 
            else if (input.equals("h")) {
                System.out.println("You have chosen h to hold. Your turn ends.");
                break;
            } 
            else {
                System.out.println("Invalid input Please enter r or h");
            }

            if (playerScore >= targetScore) {
                System.out.println("\n***********Congratulations*************");
                System.out.println("\nYou reacheda score of " + playerScore + " and won the Game of  Dice");
                break;
            }

            turn++;
        }

        scanner.close();
    }

    private static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}