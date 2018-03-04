package au.com.icm.poker.games;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CardTests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCardShouldHaveCorrectRank() {
        Card card = Card.build("TD");
        assert card.getRank() == 10;
        assert card.getSuit().equals(SuitTypes.DIAMONDS);
    }

    @Test
    public void testCardsShoouldRaiseErrorWhenRankIsGreaterThank14() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid Card");
        Card card = Card.build("15D");
    }

    @Test
    public void testCardsShoouldRaiseErrorForInvalidSuild4() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid Card");
        Card card = Card.build("7G");
    }

    @Test
    public void testCardShouldHaveCorrectRankForSingleDigitRank() {
        Card card = Card.build("7S");
        assert card.getRank() == 7;
        assert card.getSuit().equals(SuitTypes.SPADES);
    }

    @Test
    public void testCardsShoouldRaiseErrorForInvalidRank() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid Card");
        Card card = Card.build("BC");
    }

    @Test
    public void testCardShouldHaveCorrectRankForJack() {
        Card card = Card.build("JS");
        assert card.getRank() == 11;
        assert card.getSuit().equals(SuitTypes.SPADES);
        ;
    }

    @Test
    public void testCardShouldHaveCorrectRankForQueen() {
        Card card = Card.build("QD");
        assert card.getRank() == 12;
        assert card.getSuit().equals(SuitTypes.DIAMONDS);
        ;
    }

    @Test
    public void testCardShouldHaveCorrectRankForKing() {
        Card card = Card.build("KH");
        assert card.getRank() == 13;
        assert card.getSuit().equals(SuitTypes.HEARTS);
        ;
    }

    @Test
    public void testCardShouldHaveCorrectRankForAce() {
        Card card = Card.build("AC");
        assert card.getRank() == 14;
        assert card.getSuit().equals(SuitTypes.CLUBS);
        ;
    }
}
