// Menu.java
import java.util.Scanner;

public class Menu {
    private Game game;

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Murderer Among Us =====");
            System.out.println("1. Start Game");
            System.out.println("2. How to Play");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.err.println("Starting the game...");
                    startGame();
                    break;
                case 2:
                    showHowToPlay();
                    break;
                case 3:
                    System.out.println("Exiting the game. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private void startGame() {
        game = new Game("new game");
        
    }

    private void showHowToPlay() {
        System.out.println("===== How to Play =====");
        System.out.println("The game simulates a mystery where players must guess who stole a diamond, from which room, and where.");
        System.out.println("Each player will take turns rolling a dice, moving to a room, and questioning others.");
        System.out.println("The game continues until a player makes a correct guess or all players are out.");
        System.out.println("Fill in more details as needed.");
    }
}

