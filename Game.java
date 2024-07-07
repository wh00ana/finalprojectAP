import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends Player {
    private List<Player> players;
    private String[] characters = {"Emma", "Liam", "Jack", "Sophia", "Emily", "Ella"};
    private String[] places = {
        "Under the Bed", "Secret Drawer", "Behind the Picture", 
        "Inside the Box", "Under the Table", "On the Closet"
    };
    private String[] rooms = {
        "Living Room", "Piano Room", "Green Room", "Office", 
        "Billiard Room", "Bedroom", "Dining Room", "Library", "Kitchen"
    };

    private String[] answer; // Array to store the answer [room, character, place]

    public Game(String name) {
        super(name); // Calling the constructor of the Player class
        players = new ArrayList<>();
        answer = new String[3];
        
        // Randomly choose room, character, and place using Dice class
        String answerRoom = rooms[Dice.roll(0, rooms.length)];
        String answerCharacter = characters[Dice.roll(0, characters.length)];
        String answerPlace = places[Dice.roll(0, places.length)];
        answer[0] = answerRoom;
        answer[1] = answerCharacter;
        answer[2] = answerPlace;
    }

    // Method to add a player to the game
    public void addPlayer(Player player) {
        players.add(player);
    }

    public ArrayList<String> remainCards() {
        // Create modified versions of characters and places excluding the answers
        List<String> modifiedCharacters = new ArrayList<>();
        List<String> modifiedPlaces = new ArrayList<>();
        List<String> modifiedRooms = new ArrayList<>();

        for (String character : characters) {
            if (!character.equals(answer[1])) {
                modifiedCharacters.add(character);
            }
        }

        for (String place : places) {
            if (!place.equals(answer[2])) {
                modifiedPlaces.add(place);
            }
        }
        for (String room : rooms) {
            if (!room.equals(answer[0])) {
                modifiedRooms.add(room);
            }
        }
        return bor(modifiedCharacters, modifiedPlaces, modifiedRooms);
    }

    // Method to start the game (example implementation)
    public void startGame() {
        ArrayList<String> allCards = remainCards();
        // Set players' cards
        dast_dadan(allCards);
        // Let first player choose room
        // Use choose room from Entering class
        // Check other players' cards
        // Guess button
        // Check guess
        // Ending

        for (Player player : players) {
            System.out.println(player.getName() + "'s cards: " + player.getHoldingCards());
        }
    }

    // bor mizani, :D
    private ArrayList<String> bor(List<String> characterCards, List<String> placeCards, List<String> roomCards) {
        ArrayList<String> allCards = new ArrayList<>();
        allCards.addAll(characterCards);
        allCards.addAll(placeCards);
        allCards.addAll(roomCards);
        return allCards;
    }
    //dast midim :D
    public void dast_dadan(ArrayList<String> allCards) {
        int cardsPerPlayer = allCards.size() / players.size();
        for (Player player : players) {
            for (int i = cardsPerPlayer; i > 0; i--) {
                int cardIndex = Dice.roll(0, allCards.size());
                player.addHoldingCard(allCards.get(cardIndex));
                allCards.remove(cardIndex);
            }
        }
    }

    // Getters for answers (for testing )
    public String getAnswerRoom() {
        return answer[0];
    }

    public String getAnswerCharacter() {
        return answer[1];
    }

    public String getAnswerPlace() {
        return answer[2];
    }

    // Players questioning others after entering a room
    private void announceQuestion(Player turnPlayer, List<Player> playersList) {
        Scanner scanner = new Scanner(System.in);
        List<String> turnPlayerCards = turnPlayer.getHoldingCards();

        System.out.print("🃜🃚🃖" + " ");
        for (String card : turnPlayerCards) {
            System.out.print(card + " ");
        }

        System.err.println("🃁🂭🂺");
        System.out.println("Enter your question about room:");
        String roomQuestion = scanner.nextLine();

        System.out.println("Enter your question about character:");
        String characterQuestion = scanner.nextLine();

        System.out.println("Enter your question about place:");
        String placeQuestion = scanner.nextLine();

        askOthers(roomQuestion, characterQuestion, placeQuestion);
    }

    // Check if any player has the questioned cards
    public String askOthers(String roomQuestion, String characterQuestion, String placeQuestion) {
        List<String> playerMeAnswers = new ArrayList<>();

        for (Player player : players) {
            if (player.getHoldingCards().contains(roomQuestion)) {
                playerMeAnswers.add(roomQuestion);
            }
            if (player.getHoldingCards().contains(characterQuestion)) {
                playerMeAnswers.add(characterQuestion);
            }
            if (player.getHoldingCards().contains(placeQuestion)) {
                playerMeAnswers.add(placeQuestion);
            }

            if (!playerMeAnswers.isEmpty()) {
                int randomIndex = Dice.roll(0, playerMeAnswers.size());
                return playerMeAnswers.get(randomIndex);
            }
        }

        return "No one knows anything about your question regarding this room.";
    }
}
