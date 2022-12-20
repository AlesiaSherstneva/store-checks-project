package util;

import models.cards.CardImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardsFactoryTest {
    CardImpl cardInList;
    CardImpl cardNotInList;

    @BeforeEach
    void setUp() {
        cardInList = new CardImpl.Builder()
                .withId(1)
                .withNumber(1234)
                .build();
        cardNotInList = new CardImpl.Builder()
                .withId(15)
                .withNumber(1515)
                .build();
    }

    @Test
    void getAllCards() {
        assertTrue(CardsFactory.getAllCards().contains(cardInList));
        assertFalse(CardsFactory.getAllCards().contains(cardNotInList));
    }
}