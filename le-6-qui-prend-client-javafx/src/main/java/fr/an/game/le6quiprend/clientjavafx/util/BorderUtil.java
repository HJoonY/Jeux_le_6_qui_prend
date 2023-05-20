package fr.an.game.le6quiprend.clientjavafx.util;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderUtil {

    /**
     * create a default black border of 1 pixel.
     * example, for debugging width-height of component
     */
    public static Border createDefaultBorder() {
        return new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
                BorderWidths.DEFAULT // 1 pixel
        ));
    }
}
