package poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cardList;

    public void addCardsToList(List<Card> cards){
        this.cardList.addAll(cards);
    }

    public Player(String name) {
        this.name = name;
        this.cardList = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

}
