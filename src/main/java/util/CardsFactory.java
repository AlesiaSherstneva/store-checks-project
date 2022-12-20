package util;

import models.cards.Card;
import models.cards.CardImpl;

import java.util.ArrayList;
import java.util.List;

public class CardsFactory {
    public static List<Card> getAllCards() {
        long[] cardNumbers = {1234, 1235, 1765, 1426, 2341, 5432, 1634, 2541, 1723, 2112};
        List<Card> cardList = new ArrayList<>();

        for(int i = 0; i < cardNumbers.length; i++) {
            Card card = new CardImpl.Builder()
                    .withId(i + 1)
                    .withNumber(cardNumbers[i])
                    .build();
            cardList.add(card);
        }
        return cardList;
    }
}