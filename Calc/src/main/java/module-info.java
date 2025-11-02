module org.example.calc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.calc to javafx.fxml;
    exports org.example.calc;
}