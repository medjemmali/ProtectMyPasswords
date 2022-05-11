module com.protectmypasswords.module {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    exports protectmypasswords.controller;
    opens protectmypasswords.controller to javafx.fxml;
    exports protectmypasswords.vue;
    opens protectmypasswords.vue to javafx.fxml;
}