package com.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.classes.Professor;
import com.utils.ProfessorDAO;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;

public class CadastroController extends BaseController implements Initializable{

    private ProfessorDAO dao = new ProfessorDAO();

    @FXML
    private TableView<Professor> tblProfessores;

    @FXML
    private TableColumn<Professor, String> clCpf;

    @FXML
    private TableColumn<Professor, Integer> clId;

    @FXML
    private TableColumn<Professor, String> clName;

    @FXML private TextField txCpf;

    @FXML private TextField txEspecializacao;

    @FXML private TextField txNome;

    @FXML private TextField txSalario;

    @FXML private TextField txTitulacao;

    @FXML private Label msg;

    @FXML void cadastrar() {
        Professor prof = new Professor();
        if(txCpf.getText() != null && !txCpf.getText().trim().isEmpty() &&  txEspecializacao.getText() != null && !txEspecializacao.getText().trim().isEmpty() && txNome.getText() != null && !txNome.getText().trim().isEmpty() && txSalario.getText() != null && !txSalario.getText().trim().isEmpty() && txTitulacao.getText() != null && !txTitulacao.getText().trim().isEmpty()){
            prof.setCpf(txCpf.getText());
            prof.setEspecializacao(txEspecializacao.getText());
            prof.setNome(txNome.getText());
            prof.setSalario(Double.parseDouble(txSalario.getText()));
            prof.setTitulacao(txTitulacao.getText());
        }
        
        // !nome.trim().isEmpty()
        txCpf.setText("");
        txEspecializacao.setText("");
        txNome.setText("");
        txTitulacao.setText("");
        txSalario.setText("");
        dao.insert(prof);
        initialize(null, null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clId.setCellValueFactory(new PropertyValueFactory<Professor, Integer>("id"));
        clName.setCellValueFactory(new PropertyValueFactory<Professor, String>("nome"));
        clCpf.setCellValueFactory(new PropertyValueFactory<Professor, String>("cpf"));
        tblProfessores.setItems(carregarProfessores());
    }

    private ObservableList carregarProfessores() {
        List<Professor> profs = dao.select();
        return FXCollections.observableArrayList(profs);
    }
}
