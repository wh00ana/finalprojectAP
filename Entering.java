// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Entering {
    public String[] rooms = {
        "Living Room", "Piano Room", "Green Room", "Office", 
        "Billiard Room", "Bedroom", "Dining Room", "Library", "Kitchen"
    };
    String currentRoom = null;

    public void enterRoom() {
        int diceRoll = Dice.roll(1, 7); // Assuming dice has 1-6
        System.err.println("You throw a dice and this is the result: " + diceRoll);

        if (diceRoll % 2 == 0) {
            System.out.println("You can enter even rooms:");
            for (int i = 1; i < rooms.length; i += 2) {
                System.out.print((i + 1) + " " + rooms[i] + " ");
            }
            chooseRoom(2);
        } else {
            System.out.println("You can enter odd rooms:");
            for (int i = 0; i < rooms.length; i += 2) {
                System.out.print((i + 1) + " " + rooms[i] + " ");
            }
            chooseRoom(1);
        }
    }

    private void chooseRoom(int n) {
        Scanner scanner = new Scanner(System.in);
        List<String> allowedRooms = new ArrayList<>();
        for (String room : rooms) {
            allowedRooms.add(room);
        }

        if (currentRoom != null) {
            switch (currentRoom) {
                case "Living Room":
                    allowedRooms.remove("Living Room");
                    allowedRooms.remove("Piano Room");
                    allowedRooms.remove("Kitchen");
                    break;
                case "Kitchen":
                    allowedRooms.remove("Kitchen");
                    allowedRooms.remove("Living Room");
                    allowedRooms.remove("Dining Room");
                    break;
                case "Piano Room":
                    allowedRooms.remove("Piano Room");
                    allowedRooms.remove("Living Room");
                    allowedRooms.remove("Green Room");
                    break;
                case "Green Room":
                    allowedRooms.remove("Green Room");
                    allowedRooms.remove("Piano Room");
                    allowedRooms.remove("Office");
                    break;
                case "Office":
                    allowedRooms.remove("Office");
                    allowedRooms.remove("Green Room");
                    allowedRooms.remove("Billiard Room");
                    break;
                case "Billiard Room":
                    allowedRooms.remove("Billiard Room");
                    allowedRooms.remove("Office");
                    allowedRooms.remove("Bedroom");
                    break;
                case "Bedroom":
                    allowedRooms.remove("Bedroom");
                    allowedRooms.remove("Billiard Room");
                    allowedRooms.remove("Dining Room");
                    break;
                case "Dining Room":
                    allowedRooms.remove("Dining Room");
                    allowedRooms.remove("Bedroom");
                    allowedRooms.remove("Library");
                    break;
                case "Library":
                    allowedRooms.remove("Library");
                    allowedRooms.remove("Dining Room");
                    allowedRooms.remove("Kitchen");
                    break;
            }
        }

        if (n == 1) {
            allowedRooms.remove("Green Room");
            allowedRooms.remove("Billiard Room");
            allowedRooms.remove("Dining Room");
            allowedRooms.remove("Kitchen");
        } else if (n == 2) {
            allowedRooms.remove("Piano Room");
            allowedRooms.remove("Office");
            allowedRooms.remove("Bedroom");
            allowedRooms.remove("Library");
        }

        System.out.println("\nHere are your options based on the game rules (you can't go to nearby rooms):");
        for (String room : allowedRooms) {
            System.out.println(room);
        }

        System.out.print("Choose a room: ");
        String chosenRoom = scanner.nextLine();
        while (!allowedRooms.contains(chosenRoom)) {
            System.out.println("Invalid room. Choose again: ");
            chosenRoom = scanner.nextLine();
        }

        currentRoom = chosenRoom;
        System.out.println("You entered the " + currentRoom);
    }
}
