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

    opens com.rbpiano.rainbowpiano to javafx.fxml;
    exports com.rbpiano.rainbowpiano;
    exports com.rbpiano.rainbowpiano.Model;
    opens com.rbpiano.rainbowpiano.Model to javafx.fxml;
}