package fr.an.game.le6quiprend.common;


public class Card {

    public final int value;
    public final int penalty;

    /*pp*/ Card(int value, int penalty) {
        this.value = value;
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "Card-" + value;
    }
}
