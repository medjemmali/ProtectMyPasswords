module com.protectmypasswords.module {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires com.jfoenix;


    exports protectmypasswords.controller;
    opens protectmypasswords.controller to javafx.fxml;
    exports protectmypasswords.vue;
    opens protectmypasswords.vue to javafx.fxml;
    opens protectmypasswords.module to javafx.base;
}