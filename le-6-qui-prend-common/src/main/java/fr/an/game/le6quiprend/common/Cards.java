package fr.an.game.le6quiprend.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cards {

    public static final int MIN_CARD_VALUE = 1;
    public static final int MAX_CARD_VALUE = 104;

    public static final int DEFAULT_CARDS_COUNT_PER_PLAYER = 10;

    public static final List<Card> cards = createCards();

    private static final int cardPenalties[] = new int[/* 1 + 104*/] {
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
            2, 1, 1, 5, 1, // card 85-89
            3, 1, 1, 1, 1, 2, // card 90-95
            1, 1, 1, 5, // card 96-99
            3, 1, 1, 1, 1 // card 100-104
    };

    private static List<Card> createCards() {
        List<Card> res = new ArrayList<>();
        for(int i = MIN_CARD_VALUE; i <= MAX_CARD_VALUE; i++) {
            res.add(new Card(i, cardPenalties[i]));
        }
        return Collections.unmodifiableList(res);
    }

    public static List<CardSet> distributeRandomCards(int nPlayer, Random rand) {
        return distributeRandomCards(nPlayer, rand,  DEFAULT_CARDS_COUNT_PER_PLAYER);
    }

    public static List<CardSet> distributeRandomCards(int nPlayer, Random rand, int nCards) {
        if (nPlayer < 0 || nPlayer > 10) throw new IllegalArgumentException();
        List<Card> remain = new ArrayList<>(cards);
        List<Card>[] playerCards = new List[nPlayer];
        for (int j = 0; j < nPlayer; j++) {
            playerCards[j] = new ArrayList<>(nCards);
        }
        for (int i = 0; i < nCards; i++) {
            for (int j = 0; j < nPlayer; j++) {
                int idx = rand.nextInt(remain.size());
                Card card = remain.remove(idx);
                playerCards[j].add(card);
            }
        }
        List<CardSet> res = new ArrayList<>(nPlayer);
        for (int j = 0; j < nPlayer; j++) {
            res.add(new CardSet(playerCards[j]));
        }
        return res;
    }
}
