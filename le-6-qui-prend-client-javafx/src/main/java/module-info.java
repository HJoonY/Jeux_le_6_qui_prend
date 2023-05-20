module fr.an.game.le6quiprend.clientjavafx {

    requires javafx.graphics;
    requires javafx.controls;
    requires retrofit2;
    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires okhttp3;
    requires retrofit2.converter.jackson;

    requires static lombok;

    // module 'clientjavafx' dependends on module 'common'
    requires fr.an.game.le6quiprend.common;

    exports fr.an.game.le6quiprend.clientjavafx;
    exports fr.an.game.le6quiprend.clientjavafx.ui;
    exports fr.an.game.le6quiprend.clientjavafx.ui.card;
}