package au.com.icm.poker.games;


import java.util.Arrays;

public final class Card {

    private final static SuitTypes[] APPLICABLE_SUITS = {SuitTypes.DIAMONDS, SuitTypes.SPADES, SuitTypes.CLUBS, SuitTypes.HEARTS};

    private final Integer rank;
    private final SuitTypes suit;

    private Card(String card) throws IllegalArgumentException {
        suit = SuitTypes.fromCode(Character.toString(card.charAt(card.length() - 1)));
        String str = card.substring(0, card.length() - 1);

        if (Character.isDigit(str.charAt(0))) {
            rank = Integer.parseInt(str);
        } else {
            switch (str.charAt(0)) {
                case 'T':
                    rank = 10;
                    break;
                case 'J':
                    rank = 11;
                    break;
                case 'Q':
                    rank = 12;
                    break;
                case 'K':
                    rank = 13;
                    break;
                case 'A':
                    rank = 14;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Card " + card);
            }
        }

        if (!Arrays.stream(APPLICABLE_SUITS).anyMatch(suit::equals)) {
            throw new IllegalArgumentException("Invalid Card " + card);
        }

        if (rank > 14) {
            throw new IllegalArgumentException("Invalid Card " + card);
        }
    }

    public static Card build(String card) {
        return new Card(card);
    }

    public Integer getRank() {
        return rank;
    }

    public SuitTypes getSuit() {
        return suit;
    }
}
