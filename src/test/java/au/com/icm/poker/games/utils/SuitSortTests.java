package au.com.icm.poker.games.utils;


import au.com.icm.poker.games.Card;
import au.com.icm.poker.games.SuitTypes;
import org.junit.Test;

import java.util.Arrays;

public class SuitSortTests {

    @Test
    public void testSuitSortShouldSortCardsByItsSuit() {
        Card[] cards = {Card.build("6C"), Card.build("5H"), Card.build("AS"), Card.build("4H"), Card.build("7S")};

        SuitSort comparator = new SuitSort();
        Arrays.sort(cards, comparator);
        assert cards[0].getSuit() == SuitTypes.SPADES;
        assert cards[1].getSuit() == SuitTypes.SPADES;
        assert cards[2].getSuit() == SuitTypes.CLUBS;
        assert cards[3].getSuit() == SuitTypes.HEARTS;
        assert cards[4].getSuit() == SuitTypes.HEARTS;
    }
}
