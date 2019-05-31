package poker;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
public class PokerTest {

    public PokerGame pokerGame;
    public Player playerOne, playerTwo;


    @BeforeEach
    public void setUp(){
        pokerGame = new PokerGame();
        playerOne = new Player("JON");
        playerTwo = new Player("SERGIO");
        pokerGame.createGame(playerOne, playerTwo);

    }


    @Test
    public void givenCreateGamePokerGameIsCreated(){

        Assert.assertEquals(pokerGame.getPlayerOne().getCardList().size(), 0);
        Assert.assertEquals(pokerGame.getPlayerTwo().getCardList().size(), 0);
        Assert.assertEquals(pokerGame.getTableGame().getCardList().size(),0);
        Assert.assertEquals(pokerGame.getCardList().size(), 52);
    }

    @Test
    public void givenInitGameCardsAreDistributed(){

        pokerGame.playInitialRound();
        Assert.assertEquals(pokerGame.getPlayerOne().getCardList().size(), 2);
        Assert.assertEquals(pokerGame.getPlayerTwo().getCardList().size(), 2);
        Assert.assertEquals(pokerGame.getTableGame().getCardList().size(),3);
        Assert.assertEquals(pokerGame.getCardList().size(), 45);
        Assert.assertFalse(pokerGame.getCardList().contains(pokerGame.getPlayerOne()
                .getCardList()));
        Assert.assertFalse(pokerGame.getCardList().contains(pokerGame.getPlayerTwo()
                .getCardList()));
        Assert.assertFalse(pokerGame.getCardList().contains(pokerGame.getTableGame()
                .getCardList()));
    }

    @Test
    public void givenPlayerOneHasPokerPlayerOneWins(){

        Card hearts_5 = new Card(5,Suit.HEARTS);
        Card clubs_5 = new Card(5,Suit.CLUBS);
        Card spades_5 = new Card(5,Suit.SPADES);
        Card diamonds_5 = new Card(5,Suit.DIAMONDS);
        Card spades_3 = new Card(3,Suit.SPADES);
        Card diamonds_6 = new Card(6,Suit.DIAMONDS);
        Card diamonds_7 = new Card(7,Suit.DIAMONDS);
        Card clubs_10 = new Card(10,Suit.CLUBS);
        Card hearts_8 = new Card(8,Suit.HEARTS);

        List<Card> playerOneCards = new ArrayList<Card>(2);
        playerOneCards.add(hearts_5);
        playerOneCards.add(clubs_5);

        List<Card> tableGameCards = new ArrayList<Card>(5);
        tableGameCards.add(spades_5);
        tableGameCards.add(diamonds_5);
        tableGameCards.add(spades_3);
        tableGameCards.add(diamonds_6);
        tableGameCards.add(diamonds_7);

        List<Card> playerTwoCards = new ArrayList<Card>(2);
        playerTwoCards.add(clubs_10);
        playerTwoCards.add(hearts_8);

        pokerGame.getPlayerOne().setCardList(playerOneCards);
        pokerGame.getPlayerTwo().setCardList(playerTwoCards);
        pokerGame.getTableGame().setCardList(tableGameCards);

        Player winnerPlayer = pokerGame.decideWinner();
        Assert.assertEquals(winnerPlayer, playerOne);
        Assert.assertNotEquals(winnerPlayer, playerTwo);



    }

}
