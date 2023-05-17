package fr.an.game.le6quiprend.clientjavafx.ui;

import fr.an.game.le6quiprend.clientjavafx.model.GameModel;
import fr.an.game.le6quiprend.clientjavafx.util.concurrent.CallbacksBuilder;
import fr.an.game.le6quiprend.common.restapi.dto.TestEchoRequestDTO;
import fr.an.game.le6quiprend.common.restapi.dto.TestEchoResponseDTO;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameView {

    private GameModel model;

    private BorderPane component;

    //---------------------------------------------------------------------------------------------

    public GameView(GameModel model, boolean showTestEchoComponent) {
        this.model = model;
        this.component = new BorderPane();

        HBox buttonToolbars = new HBox();

        if (showTestEchoComponent) {
            TestEchoServerComponent testEchoServerComponent = new TestEchoServerComponent(model);
            buttonToolbars.getChildren().add(testEchoServerComponent.getComponent());
        }

        component.setCenter(new Label("TODO ... GameView for Le-6-qui-prend"));
        component.setBottom(buttonToolbars);
    }

    //---------------------------------------------------------------------------------------------

    public Node getComponent() {
        return component;
    }

}
