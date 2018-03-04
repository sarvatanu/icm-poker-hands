package au.com.icm.poker.games;


import org.junit.Test;

public class HandRankFinderTests {

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsFlush() {
        Card[] cards = {
                Card.build("QD"),
                Card.build("6D"),
                Card.build("7D"),
                Card.build("TD"),
                Card.build("7D")
        };

        boolean isFlush = HandRankFinder.isFlush(cards);

        assert isFlush;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsStright() {
        Card[] cards = {
                Card.build("2D"),
                Card.build("4D"),
                Card.build("5S"),
                Card.build("6H"),
                Card.build("3D")
        };

        boolean isStraight = HandRankFinder.isStraight(cards);

        assert isStraight;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsStrightWithAce() {
        Card[] cards = {
                Card.build("11D"),
                Card.build("10D"),
                Card.build("13S"),
                Card.build("12H"),
                Card.build("AD")
        };

        boolean isStraight = HandRankFinder.isStraight(cards);

        assert isStraight;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsNotStrightWithAce() {
        Card[] cards = {
                Card.build("9D"),
                Card.build("10D"),
                Card.build("13S"),
                Card.build("12H"),
                Card.build("AD")
        };

        boolean isStraight = HandRankFinder.isStraight(cards);

        assert !isStraight;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsNotStright() {
        Card[] cards = {
                Card.build("QD"),
                Card.build("6D"),
                Card.build("7D"),
                Card.build("TD"),
                Card.build("7D")
        };

        boolean isStraight = HandRankFinder.isStraight(cards);

        assert !isStraight;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsFullHouseWithFirstThreeAreSameKind() {
        Card[] cards = {
                Card.build("3D"),
                Card.build("6D"),
                Card.build("3D"),
                Card.build("6D"),
                Card.build("3D")
        };

        boolean isFullHouse = HandRankFinder.isFullHouse(cards);

        assert isFullHouse;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsFullHouseWithLastThreeAreSameKind() {
        Card[] cards = {
                Card.build("6D"),
                Card.build("6D"),
                Card.build("3D"),
                Card.build("6D"),
                Card.build("3D")
        };

        boolean isFullHouse = HandRankFinder.isFullHouse(cards);

        assert isFullHouse;
    }

    @Test
    public void testHandRankFinderShouldReturnFalseIfPairIsNotPresent() {
        Card[] cards = {
                Card.build("6D"),
                Card.build("6D"),
                Card.build("2D"),
                Card.build("6D"),
                Card.build("3D")
        };

        boolean isFullHouse = HandRankFinder.isFullHouse(cards);

        assert !isFullHouse;
    }


    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsRoyalFlush() {
        Card[] cards = {
                Card.build("11D"),
                Card.build("10D"),
                Card.build("12D"),
                Card.build("14D"),
                Card.build("13D")
        };

        boolean isRoyalFlush = HandRankFinder.isRoyalFlush(cards);

        assert isRoyalFlush;
    }

    @Test
    public void testHandRankFinderShouldReturnFalseIfHandIsNotRoyalFlush() {
        Card[] cards = {
                Card.build("11D"),
                Card.build("10D"),
                Card.build("12D"),
                Card.build("14D"),
                Card.build("13S")
        };

        boolean isRoyalFlush = HandRankFinder.isRoyalFlush(cards);

        assert !isRoyalFlush;
    }

    @Test
    public void testHandRankFinderShouldReturnFalseIfHandIsNotRoyalFlushWhenCardRankIsLessThan10() {
        Card[] cards = {
                Card.build("11D"),
                Card.build("1D"),
                Card.build("2D"),
                Card.build("4D"),
                Card.build("13D")
        };

        boolean isRoyalFlush = HandRankFinder.isRoyalFlush(cards);

        assert !isRoyalFlush;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsFourOfKindsWithFirstFourCards() {
        Card[] cards = {
                Card.build("11D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("13D")
        };

        boolean isFourOfAKind = HandRankFinder.isFourOfAKind(cards);

        assert isFourOfAKind;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsFourOfKindsWithLastFourCards() {
        Card[] cards = {
                Card.build("10D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("11D")
        };

        boolean isFourOfAKind = HandRankFinder.isFourOfAKind(cards);

        assert isFourOfAKind;
    }

    @Test
    public void testHandRankFinderShouldReturnFalseIfHandIsNotFourOfKinds() {
        Card[] cards = {
                Card.build("10D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("12D")
        };

        boolean isFourOfAKind = HandRankFinder.isFourOfAKind(cards);

        assert !isFourOfAKind;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfThreeCardsOfSameRank() {
        Card[] cards = {
                Card.build("10D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("12D")
        };

        Card[] cards1 = {
                Card.build("11D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("2D"),
                Card.build("12D")
        };

        Card[] cards2 = {
                Card.build("6D"),
                Card.build("5D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("11D")
        };

        boolean isThreeOfAKind = HandRankFinder.isThreeOfAKind(cards);

        assert isThreeOfAKind;

        isThreeOfAKind = HandRankFinder.isThreeOfAKind(cards1);

        assert isThreeOfAKind;

        isThreeOfAKind = HandRankFinder.isThreeOfAKind(cards2);

        assert isThreeOfAKind;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsTwoPair() {
        Card[] cards = {
                Card.build("10D"),
                Card.build("10D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("12D")
        };

        Card[] cards1 = {
                Card.build("11D"),
                Card.build("11D"),
                Card.build("10D"),
                Card.build("12D"),
                Card.build("12D")
        };

        Card[] cards2 = {
                Card.build("6D"),
                Card.build("10D"),
                Card.build("10D"),
                Card.build("11D"),
                Card.build("11D")
        };

        boolean isTwoPair = HandRankFinder.isTwoPair(cards);

        assert isTwoPair;

        isTwoPair = HandRankFinder.isTwoPair(cards1);

        assert isTwoPair;

        isTwoPair = HandRankFinder.isTwoPair(cards2);

        assert isTwoPair;
    }

    @Test
    public void testHandRankFinderShouldReturnTrueIfHandIsPair() {
        Card[] cards = {
                Card.build("10D"),
                Card.build("10D"),
                Card.build("12D"),
                Card.build("13D"),
                Card.build("14D")
        };

        Card[] cards1 = {
                Card.build("2D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("12D"),
                Card.build("13D")
        };

        Card[] cards2 = {
                Card.build("6D"),
                Card.build("10D"),
                Card.build("11D"),
                Card.build("11D"),
                Card.build("13D")
        };


        Card[] cards3 = {
                Card.build("6D"),
                Card.build("10D"),
                Card.build("9D"),
                Card.build("11D"),
                Card.build("11D")
        };

        boolean isPair = HandRankFinder.isPair(cards);

        assert isPair;

        isPair = HandRankFinder.isPair(cards1);

        assert isPair;

        isPair = HandRankFinder.isPair(cards2);

        assert isPair;

        isPair = HandRankFinder.isPair(cards3);

        assert isPair;
    }
}
