package au.com.icm.poker.games;


import org.junit.Test;

public class HandTest {

    @Test
    public void testHandShouldBuildListOfCards() {
        String[] player1 = {"6C", "5H", "AS", "4H", "7D"};
        Hand hand = Hand.build(player1, 1);

        assert hand.getCards().length == 5;
        assert hand.getCards()[0].getRank() == 6;
        assert hand.getCards()[0].getSuit().equals(SuitTypes.CLUBS.getType());

        assert hand.getCards()[1].getRank() == 5;
        assert hand.getCards()[1].getSuit().equals(SuitTypes.HEARTS.getType());

        assert hand.getCards()[2].getRank() == 14;
        assert hand.getCards()[2].getSuit().equals(SuitTypes.SPADES.getType());

        assert hand.getCards()[3].getRank() == 4;
        assert hand.getCards()[3].getSuit().equals(SuitTypes.HEARTS.getType());

        assert hand.getCards()[4].getRank() == 7;
        assert hand.getCards()[4].getSuit().equals(SuitTypes.DIAMONDS.getType());

    }

}
