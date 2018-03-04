package au.com.icm.poker.games;


import au.com.icm.poker.games.utils.CardSort;
import au.com.icm.poker.games.utils.SuitSort;

import java.util.Arrays;


/**
 * This class determines the type of Poker Hand and the Poker Hand assigned weigtage value.
 * The logic is referenced from http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/10/pokerValue.html and used
 * for this coding exercise.
 */
public class HandRankFinder {

    private final static SuitSort suitComparator = new SuitSort();
    private final static CardSort cardComparator = new CardSort();

    public static boolean isRoyalFlush(Card[] cards) {
        Arrays.sort(cards, cardComparator);
        boolean isStraightWithAce = cards[0].getRank() == 10 &&
                cards[1].getRank() == 11 &&
                cards[2].getRank() == 12 &&
                cards[3].getRank() == 13 &&
                cards[4].getRank() == 14;

        return isFlush(cards) && isStraightWithAce;
    }

    public static boolean isStraightFlush(Card[] cards) {
        return isFlush(cards) && isStraight(cards);
    }

    public static boolean isFourOfAKind(Card[] cards) {
        Arrays.sort(cards, cardComparator);
        boolean check1 = cards[0].getRank() == cards[1].getRank() &&
                cards[0].getRank() == cards[2].getRank() &&
                cards[0].getRank() == cards[3].getRank();

        boolean check2 = cards[1].getRank() == cards[2].getRank() &&
                cards[1].getRank() == cards[3].getRank() &&
                cards[1].getRank() == cards[4].getRank();

        return (check1 || check2);
    }

    public static boolean isFullHouse(Card[] cards) {
        Arrays.sort(cards, cardComparator);

        boolean check1 = cards[0].getRank() == cards[1].getRank() &&
                cards[0].getRank() == cards[2].getRank() &&
                cards[3].getRank() == cards[4].getRank();

        boolean check2 = cards[0].getRank() == cards[1].getRank() &&
                cards[2].getRank() == cards[3].getRank() &&
                cards[2].getRank() == cards[4].getRank();

        return (check1 || check2);
    }

    public static boolean isFlush(Card[] cards) {
        Arrays.sort(cards, suitComparator);
        return (cards[0].getSuit() == cards[4].getSuit());
    }

    public static boolean isStraight(Card[] cards) {
        Arrays.sort(cards, cardComparator);
        if (cards[4].getRank() == 14) {

            boolean check1 = cards[0].getRank() == 10 && cards[1].getRank() == 11 &&
                    cards[2].getRank() == 12 && cards[3].getRank() == 13;

            boolean check2 = cards[0].getRank() == 2 && cards[1].getRank() == 3 &&
                    cards[2].getRank() == 4 && cards[3].getRank() == 5;

            return (check1 || check2);
        } else {
            for (int i = 1; i < cards.length; i++) {
                if (cards[i].getRank() != cards[i - 1].getRank() + 1) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isThreeOfAKind(Card[] cards) {

        if (isFourOfAKind(cards) || isFullHouse(cards))
            return (false);

        Arrays.sort(cards, cardComparator);

        boolean check1 = cards[0].getRank() == cards[1].getRank() &&
                cards[1].getRank() == cards[2].getRank();

        boolean check2 = cards[1].getRank() == cards[2].getRank() &&
                cards[2].getRank() == cards[3].getRank();

        boolean check3 = cards[2].getRank() == cards[3].getRank() &&
                cards[3].getRank() == cards[4].getRank();

        return (check1 || check2 || check3);
    }

    public static boolean isTwoPair(Card[] cards) {

        if (isFourOfAKind(cards) || isFullHouse(cards) || isThreeOfAKind(cards))
            return (false);

        Arrays.sort(cards, cardComparator);

        boolean check1 = cards[0].getRank() == cards[1].getRank() &&
                cards[2].getRank() == cards[3].getRank();

        boolean check2 = cards[0].getRank() == cards[1].getRank() &&
                cards[3].getRank() == cards[4].getRank();

        boolean check3 = cards[1].getRank() == cards[2].getRank() &&
                cards[3].getRank() == cards[4].getRank();

        return (check1 || check2 || check3);
    }

    public static boolean isPair(Card[] cards) {

        if (isFourOfAKind(cards) || isFullHouse(cards) || isThreeOfAKind(cards) || isTwoPair(cards))
            return (false);

        Arrays.sort(cards, cardComparator);

        boolean check1 = cards[0].getRank() == cards[1].getRank();
        boolean check2 = cards[1].getRank() == cards[2].getRank();
        boolean check3 = cards[2].getRank() == cards[3].getRank();
        boolean check4 = cards[3].getRank() == cards[4].getRank();

        return (check1 || check2 || check3 || check4);
    }


    public static int valueStraightFlush(Card[] cards) {
        return HandRankType.STRAIGHT_FLUSH.getRank() + valueHighCard(cards);
    }

    public static int valueFlush(Card[] cards) {
        return HandRankType.FLUSH.getRank() + valueHighCard(cards);
    }

    public static int valueStraight(Card[] cards) {
        return HandRankType.STRAIGHT.getRank() + valueHighCard(cards);
    }

    public static int valueFourOfAKind(Card[] cards) {
        Arrays.sort(cards, cardComparator);

        return HandRankType.FOUR_OF_A_KIND.getRank() + cards[2].getRank();
    }

    public static int valueFullHouse(Card[] cards) {
        Arrays.sort(cards, cardComparator);

        return HandRankType.FULL_HOUSE.getRank() + cards[2].getRank();
    }

    public static int valueSet(Card[] cards) {
        Arrays.sort(cards, cardComparator);

        return HandRankType.THREE_OF_A_KIND.getRank() + cards[2].getRank();
    }

    public static int valueTwoPairs(Card[] cards) {
        int val = 0;

        Arrays.sort(cards, cardComparator);

        if (cards[0].getRank() == cards[1].getRank() &&
                cards[2].getRank() == cards[3].getRank())
            val = 14 * 14 * cards[2].getRank() + 14 * cards[0].getRank() + cards[4].getRank();
        else if (cards[0].getRank() == cards[1].getRank() &&
                cards[3].getRank() == cards[4].getRank())
            val = 14 * 14 * cards[3].getRank() + 14 * cards[0].getRank() + cards[2].getRank();
        else
            val = 14 * 14 * cards[3].getRank() + 14 * cards[1].getRank() + cards[0].getRank();

        return HandRankType.TWO_PAIRS.getRank() + val;
    }


    public static int valueOnePair(Card[] cards) {
        int val = 0;

        Arrays.sort(cards, cardComparator);

        if (cards[0].getRank() == cards[1].getRank())
            val = 14 * 14 * 14 * cards[0].getRank() +
                    +cards[2].getRank() + 14 * cards[3].getRank() + 14 * 14 * cards[4].getRank();
        else if (cards[1].getRank() == cards[2].getRank())
            val = 14 * 14 * 14 * cards[1].getRank() +
                    +cards[0].getRank() + 14 * cards[3].getRank() + 14 * 14 * cards[4].getRank();
        else if (cards[2].getRank() == cards[3].getRank())
            val = 14 * 14 * 14 * cards[2].getRank() +
                    +cards[0].getRank() + 14 * cards[1].getRank() + 14 * 14 * cards[4].getRank();
        else
            val = 14 * 14 * 14 * cards[3].getRank() +
                    +cards[0].getRank() + 14 * cards[1].getRank() + 14 * 14 * cards[2].getRank();

        return HandRankType.PAIR.getRank() + val;
    }

    public static int valueHighCard(Card[] cards) {
        int val;

        Arrays.sort(cards, cardComparator);

        val = cards[0].getRank() + 14 * cards[1].getRank() + 14 * 14 * cards[2].getRank()
                + 14 * 14 * 14 * cards[3].getRank() + 14 * 14 * 14 * 14 * cards[4].getRank();

        return val;
    }
}
