package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuController {
    @FXML
    private Label lblMSG;

    private String menbros = "Lucas Renu & Sávio Rodrigues.";

    @FXML
    private void switchToSecondary() throws IOException {
        //App.setRoot("secondary");
        lblMSG.setText(menbros);
        System.out.println("\t---- Trabalho de POO ----\n"+"\t"+menbros);
    }
}
