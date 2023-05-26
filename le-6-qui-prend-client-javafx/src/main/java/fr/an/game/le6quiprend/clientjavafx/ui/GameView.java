package fr.an.game.le6quiprend.clientjavafx.ui;

import fr.an.game.le6quiprend.clientjavafx.model.GameModel;
import fr.an.game.le6quiprend.clientjavafx.ui.card.CardView;
import fr.an.game.le6quiprend.common.Card;
import fr.an.game.le6quiprend.common.Cards;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameView {

    private GameModel model;

    private BorderPane component;
    private Pane centerArea;

    int cardWidth = 65;
    int cardHeight = 115;

    Insets cardInsets = new Insets(2);

    int currEndRow = 7;
    int currEndCol = 4;

    Label endLabel;

    //---------------------------------------------------------------------------------------------

    public GameView(GameModel model, boolean showTestEchoComponent) {
        this.model = model;
        this.component = new BorderPane();

        HBox buttonToolbars = new HBox();

        if (showTestEchoComponent) {
            TestEchoServerComponent testEchoServerComponent = new TestEchoServerComponent(model);
            buttonToolbars.getChildren().add(testEchoServerComponent.getComponent());
        }

        centerArea = new Pane();
// Test pour git
        // TEMP FOR TEST ..
        // display all cards...
        // Help text on position 0:
        VBox helpComponent = new VBox(
                new Label("on cards.."),
                new Label("when click"),
                new Label("=> toggle"),
                new Label(""),
                new Label("when right-click"),
                new Label(" or Ctrl/Shift"),
                new Label("=> move to end"));
        centerArea.getChildren().add(helpComponent);
        nodeSetLayoutAt(helpComponent, cardPosForRowCol(0, 0));

        int row = 0;
        int col = 1;
        for(Card card: Cards.cards) {
            if (card.value % 20 == 0) {
                row++;
                col = 0;
            }
            CardView cardView = new CardView(card, cardWidth, cardHeight);
            Pane cardComponent = cardView.getComponent();
            // assign position..

            nodeSetLayoutAt(cardComponent, cardPosForRowCol(row, col));

            cardComponent.setOnMouseClicked(e -> onMouseClickCard(e, cardView));

            centerArea.getChildren().add(cardComponent);
            col++;
        }

        endLabel = new Label("move card to here..");
        centerArea.getChildren().add(endLabel);
        currEndRow = row; currEndCol = col;
        nodeSetLayoutAt(endLabel, cardPosForRowCol(currEndRow, currEndCol));

        component.setCenter(centerArea);

        component.setBottom(buttonToolbars);
    }

    private void onMouseClickCard(MouseEvent e, CardView cardView) {
        if (e.isSecondaryButtonDown() || e.isShiftDown() || e.isControlDown()) {
            // TODO ... animate move card to end..
            System.out.println("onMouseClickCard..RightButton => move card " + cardView + " to end");

            Pane cardComponent = cardView.getComponent();
            Point2D fromPt = new Point2D(cardComponent.getLayoutX(), cardComponent.getLayoutY());

            Point2D toPt = cardPosForRowCol(currEndRow, currEndCol);
            currEndCol++;
            nodeSetLayoutAt(endLabel, cardPosForRowCol(currEndRow, currEndCol));

            // remove then add cardView, so that it is on top of all others
            centerArea.getChildren().remove(cardComponent);
            centerArea.getChildren().add(cardComponent);

            // animate move card to end
            Point2D translate = toPt.subtract(fromPt);
            TranslateTransition translateTransition = new TranslateTransition();
            translateTransition.setNode(cardComponent);
            translateTransition.setDuration(Duration.millis(500));
            translateTransition.setToX(translate.getX());
            translateTransition.setToY(translate.getY());
            translateTransition.play();

        } else {
            System.out.println("onMouseClickCard => toggle card " + cardView);
            cardView.toggleCard();
        }
    }

    protected static void nodeSetLayoutAt(Node node, Point2D pt) {
        node.setLayoutX(pt.getX());
        node.setLayoutY(pt.getY());
    }
    protected Point2D cardPosForRowCol(int row, int col) {
        return new Point2D(10 + col * (cardInsets.getLeft() + cardWidth + cardInsets.getRight())
                , 10 + row * (cardInsets.getTop() + cardHeight + cardInsets.getBottom()));
    }


    //---------------------------------------------------------------------------------------------

    public Node getComponent() {
        return component;
    }

}
