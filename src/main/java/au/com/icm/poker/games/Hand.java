package au.com.icm.poker.games;


import java.util.ArrayList;
import java.util.List;

public final class Hand {
    private final Integer playerId;

    private Integer pokerHandValue;
    private List<Card> cards = new ArrayList<>();

    private Hand(String[] inputCards, Integer playerId) {
        for (int i = 0; i < inputCards.length; i++) {
            cards.add(Card.build(inputCards[i]));
        }
        this.playerId = playerId;
        determineHandRank(getCards());
    }

    public static Hand build(String[] inputCards, Integer playerId) {
        return new Hand(inputCards, playerId);
    }

    public Card[] getCards() {
        Card[] cardArray = new Card[cards.size()];
        return cards.toArray(cardArray);
    }

    private void determineHandRank(Card[] cards) {

        if (HandRankFinder.isStraightFlush(cards)) {
            pokerHandValue = HandRankFinder.valueStraightFlush(cards);
        } else if (HandRankFinder.isFourOfAKind(cards)) {
            pokerHandValue = HandRankFinder.valueFourOfAKind(cards);
        } else if (HandRankFinder.isFullHouse(cards)) {
            pokerHandValue = HandRankFinder.valueFullHouse(cards);
        } else if (HandRankFinder.isFlush(cards)) {
            pokerHandValue = HandRankFinder.valueFlush(cards);
        } else if (HandRankFinder.isStraight(cards)) {
            pokerHandValue = HandRankFinder.valueStraight(cards);
        } else if (HandRankFinder.isThreeOfAKind(cards)) {
            pokerHandValue = HandRankFinder.valueSet(cards);
        } else if (HandRankFinder.isTwoPair(cards)) {
            pokerHandValue = HandRankFinder.valueTwoPairs(cards);
        } else if (HandRankFinder.isPair(cards)) {
            pokerHandValue = HandRankFinder.valueOnePair(cards);
        } else {
            pokerHandValue = HandRankFinder.valueHighCard(cards);
        }
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public Integer getPokerHandValue() {
        return pokerHandValue;
    }
}
