package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PokerGame {

    private Player playerOne, playerTwo;
    private TableGame tableGame;
    private List<Card> cardList;

    public PokerGame() {
    }

    public void createGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.tableGame = new TableGame();
        this.cardList = generateCardList();
    }

    private List<Card> generateCardList() {
        List<Card> cardList = new ArrayList<Card>(52);
        //2(0)...AS(12)
        for (int i = 0; i < 13 ; i++) {
            cardList.add(new Card(i, Suit.SPADES));
            cardList.add(new Card(i, Suit.DIAMONDS));
            cardList.add(new Card(i, Suit.CLUBS));
            cardList.add(new Card(i, Suit.HEARTS));
        }
        return cardList;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public TableGame getTableGame() {
        return tableGame;
    }

    public void setTableGame(TableGame tableGame) {
        this.tableGame = tableGame;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void playInitialRound() {
        this.playerOne.addCardsToList(getRandomCardsFromCardList(2));
        this.playerTwo.addCardsToList(getRandomCardsFromCardList(2));
        this.tableGame.addCardsToList(getRandomCardsFromCardList(3));
    }

    public List<Card> getRandomCardsFromCardList(int numCards) {
        List<Card> randomCards = new ArrayList<Card>(numCards);
        for (int i = 0; i < numCards ; i++) {

            Random rand = new Random();
            Card card = cardList.get(rand.nextInt(cardList.size()));
            cardList.remove(card);
            randomCards.add(card);
            System.out.println(card.getSuit() + " " + card.getNum());

        }
            return randomCards;
    }

    public Player decideWinner() {
        //CARTA + ALTA, PAREJA, DOBLE PAREJA, ESC COLOR, TRIO, POKER.
        // 1               2          3          4        5      6
        getPlayValue(this.playerOne);
        return null;
    }

    private int getPlayValue(Player player) {
        List<Card> playerCardList = player.getCardList();
        Card cardOne = playerCardList.get(0);
        Card cardTwo = playerCardList.get(1);

        int count = 0;
        if(cardOne.getNum() == cardTwo.getNum()){
            for (Card card:this.tableGame.getCardList()) {
                if (card.getNum() == cardOne.getNum()){
                    count++;
                }else{

                }
            }
            if (count == 2){
                return 6;//poker
            }else if (count == 1){
                return 5;//trio
            }else{
                return 2;//pareja
            }
        }

        return 0;
    }
}
