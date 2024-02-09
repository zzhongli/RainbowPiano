module app.rainbowpiano {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens app.rainbowpiano to javafx.fxml;
    exports app.rainbowpiano;
    exports app.rainbowpiano.Model;
    opens app.rainbowpiano.Model to javafx.fxml;
}