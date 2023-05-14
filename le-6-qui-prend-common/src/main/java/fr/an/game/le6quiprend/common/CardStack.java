package fr.an.game.le6quiprend.common;

import java.util.ArrayList;
import java.util.List;

public class CardStack {

    private List<Card> cards = new ArrayList<>();
    private int sumPenalty;

    //---------------------------------------------------------------------------------------------

    public int getSumPenalty() {
        return sumPenalty;
    }

    public int getCardCount() {
        return cards.size();
    }

    public List<Card> addMayTakeIf6(Card c) {
        List<Card> res;
        if (cards.size() == 5) {
            res = new ArrayList<>(cards);
            this.cards.clear();
        } else {
            res = null;
        }
        cards.add(c);
        return res;
    }

}
