package fr.an.game.le6quiprend.clientjavafx.ui;

import fr.an.game.le6quiprend.clientjavafx.model.GameModel;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class GameView {

    private GameModel model;
    private BorderPane component;

    //---------------------------------------------------------------------------------------------

    public GameView(GameModel model) {
        this.model = model;
        this.component = new BorderPane();
        component.setCenter(new Label("TODO ... GameView for Le-6-qui-prend"));
    }

    //---------------------------------------------------------------------------------------------

    public Node getComponent() {
        return component;
    }

}
