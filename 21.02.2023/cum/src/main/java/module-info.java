module com.example.cum {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens com.example.cum to javafx.fxml;
    exports com.example.cum;
}