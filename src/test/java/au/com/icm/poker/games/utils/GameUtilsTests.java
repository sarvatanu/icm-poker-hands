package au.com.icm.poker.games.utils;


import au.com.icm.poker.games.Game;
import au.com.icm.poker.games.SuitTypes;
import org.junit.Test;

public class GameUtilsTests {

    @Test
    public void testGameUtilsShouldParseAndCreateNumberOfGames() {
        String gamePlayed = "6C 5H AS 4H 7S 2S KD 7H 2C AC";

        Game game = GameUtils.parsePlayerCards(gamePlayed);

        assert game.getPlayer1().getCards().length == 5;
        assert game.getPlayer2().getCards().length == 5;

        assert game.getPlayer1().getCards()[0].getRank() == 6;
        assert game.getPlayer1().getCards()[0].getSuit().equals(SuitTypes.CLUBS);

        assert game.getPlayer1().getCards()[1].getRank() == 5;
        assert game.getPlayer1().getCards()[1].getSuit().equals(SuitTypes.HEARTS);

        assert game.getPlayer1().getCards()[2].getRank() == 14;
        assert game.getPlayer1().getCards()[2].getSuit().equals(SuitTypes.SPADES);

        assert game.getPlayer1().getCards()[3].getRank() == 4;
        assert game.getPlayer1().getCards()[3].getSuit().equals(SuitTypes.HEARTS);

        assert game.getPlayer1().getCards()[4].getRank() == 7;
        assert game.getPlayer1().getCards()[4].getSuit().equals(SuitTypes.SPADES);


        assert game.getPlayer2().getCards()[0].getRank() == 2;
        assert game.getPlayer2().getCards()[0].getSuit().equals(SuitTypes.SPADES);

        assert game.getPlayer2().getCards()[1].getRank() == 13;
        assert game.getPlayer2().getCards()[1].getSuit().equals(SuitTypes.DIAMONDS);

        assert game.getPlayer2().getCards()[2].getRank() == 7;
        assert game.getPlayer2().getCards()[2].getSuit().equals(SuitTypes.HEARTS);

        assert game.getPlayer2().getCards()[3].getRank() == 2;
        assert game.getPlayer2().getCards()[3].getSuit().equals(SuitTypes.CLUBS);

        assert game.getPlayer2().getCards()[4].getRank() == 14;
        assert game.getPlayer2().getCards()[4].getSuit().equals(SuitTypes.CLUBS);
    }
}
