package au.com.icm.poker.games.utils;


import au.com.icm.poker.games.Card;
import org.junit.Test;

import java.util.Arrays;

public class CardSortTests {

    @Test
    public void testCardSortShouldSortTheCardsByItsRank() {
        Card[] cards = {Card.build("6C"), Card.build("5H"), Card.build("AS"), Card.build("4H"), Card.build("7S")};

        CardSort comparator = new CardSort();
        Arrays.sort(cards, comparator);
        assert cards[0].getRank() == 4;
        assert cards[1].getRank() == 5;
        assert cards[2].getRank() == 6;
        assert cards[3].getRank() == 7;
        assert cards[4].getRank() == 14;
    }
}
