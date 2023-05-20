package fr.an.game.le6quiprend.common;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CardsTest {

    private static final int CHECK_cardPenalties[] = new int[/* 1 + 104*/]{
            -1, // no card 0.. invalid marker
            1, 1, 1, 1, 2, // card 1-5
            1, 1, 1, 1, // card 6-9
            3, 5, 1, 1, 1, 2, // card 10-15
            1, 1, 1, 1, // card 16-19
            3, 1, 5, 1, 1, 2, // card 20-25
            1, 1, 1, 1, // card 26-29
            3, 1, 1, 5, 1, 2, // card 30-35
            1, 1, 1, 1, // card 36-39
            3, 1, 1, 1, 5, 2, // card 40-45
            1, 1, 1, 1, // card 46-49
            3, 1, 1, 1, 1, 7, // card 50-55
            1, 1, 1, 1, // card 56-59
            3, 1, 1, 1, 1, 2, // card 60-65
            5, 1, 1, 1, // card 66-69
            3, 1, 1, 1, 1, 2, // card 70,75
            1, 5, 1, 1, // card 76-79
            3, 1, 1, 1, 1, 2, // card 80-85
            1, 1, 5, 1, // card 86-89
            3, 1, 1, 1, 1, 2, // card 90-95
            1, 1, 1, 5, // card 96-99
            3, 1, 1, 1, 1 // card 100-104
    };

    @Test
    public void testCardPenalties() {
        List<Card> cards = Cards.cards;
        for(int i = Cards.MIN_CARD_VALUE; i <= Cards.MAX_CARD_VALUE; i++) {
            int penalty = Cards.cardPenalty(i);
            Card card = cards.get(i - 1);
            Assert.assertEquals(i, card.value);
            Assert.assertEquals(penalty, card.penalty);
            Assert.assertEquals(penalty, CHECK_cardPenalties[i]);
        }
    }
}
