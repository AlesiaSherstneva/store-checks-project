package by.myshop.models.cards;

import java.util.Objects;

public class CardImpl implements Card {
    int id;
    long number;

    @Override
    public long getNumber() {
        return number;
    }

    public static class Builder {
        private final CardImpl newCard;

        public Builder() {
            newCard = new CardImpl();
        }

        public Builder withId(int id) {
            newCard.id = id;
            return this;
        }

        public Builder withNumber(long number) {
            newCard.number = number;
            return this;
        }

        public CardImpl build() {
            return newCard;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardImpl card)) return false;
        return id == card.id && number == card.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }
}