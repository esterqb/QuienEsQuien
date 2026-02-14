module com.quienesquien.quienesquien {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.quienesquien.quienesquien to javafx.fxml;
    exports com.quienesquien.quienesquien;
}