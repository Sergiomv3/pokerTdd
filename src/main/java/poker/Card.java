package poker;

public class Card {
    private int num;
    private Suit suit;

    public Card(int num, Suit suit) {
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}
