package poker;

import java.util.ArrayList;
import java.util.List;

public class TableGame {
    private List<Card> cardList;

    public TableGame() {
        this.cardList = new ArrayList<Card>();
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void addCardsToList(List<Card> cards){
        this.cardList.addAll(cards);
    }}
