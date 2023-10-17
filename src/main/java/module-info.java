module es.ieslosmontecillos.pathtransitoinexmple {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.pathtransitoinexmple to javafx.fxml;
    exports es.ieslosmontecillos.pathtransitoinexmple;
}