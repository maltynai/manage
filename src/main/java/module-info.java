module com.example.manage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.manage to javafx.fxml;
    exports com.example.manage;
}