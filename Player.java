import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<String> holdingCards;

    public Player(String name) {
        this.name = name;
        this.holdingCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getHoldingCards() {
        return holdingCards;
    }

    public void addHoldingCard(String card) {
        holdingCards.add(card);
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', holdingCards=" + holdingCards + '}';
    }
}
