package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.classes.Professor;
import com.utils.ProfessorDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class BaseController implements Initializable{
    // TELA DE CADASTRO
    private ProfessorDAO dao = new ProfessorDAO();

    @FXML
    private Alert alert;

    @FXML
    private TableView<Professor> tblProfessores;

    @FXML
    private TableColumn<Professor, String> colCpf;

    @FXML
    private TableColumn<Professor, Integer> colId;

    @FXML
    private TableColumn<Professor, String> colNome;

    @FXML private TextField txCpf;

    @FXML private TextField txEspecializacao;

    @FXML private TextField txNome;

    @FXML private TextField txSalario;

    @FXML private TextField txTitulacao;

    @FXML
    void cadastrar() {
        Professor prof = new Professor();
        if(dao.selectByCPF(txCpf.getText()) == null){
            if(txCpf.getText() != null && !txCpf.getText().trim().isEmpty() &&  txEspecializacao.getText() != null && !txEspecializacao.getText().trim().isEmpty() && txNome.getText() != null && !txNome.getText().trim().isEmpty() && txSalario.getText() != null && !txSalario.getText().trim().isEmpty() && txTitulacao.getText() != null && !txTitulacao.getText().trim().isEmpty()){
                prof.setCpf(txCpf.getText());
                prof.setEspecializacao(txEspecializacao.getText());
                prof.setNome(txNome.getText());
                prof.setSalario(Double.parseDouble(txSalario.getText()));
                prof.setTitulacao(txTitulacao.getText());
                txCpf.setText("");
                txEspecializacao.setText("");
                txNome.setText("");
                txTitulacao.setText("");
                txSalario.setText("");
                dao.insert(prof);
                initialize(null, null);
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("CAMPOS INVÁLIDOS");
                alert.setHeaderText("Não foi possível efetuar o cadastro!");
                alert.setContentText("Certifique-se de que todos os campos estão preenchidos.");
                alert.show();
            }
        } else {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("CPF já cadastrado");
            alert.setHeaderText("Não foi possível efetuar o cadastro!");
            alert.setContentText("O CPF informado já está cadastrado na base de dados!");
            alert.show();
        }
    }

    // TELA DE ATUALIZAÇÃO
    private int idProfessor;

    @FXML
    private TextField txtIdPesquisar;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtEspecializacao;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;

    @FXML
    private TextField txtTitulacao;

    @FXML
    private Button btnAtualizar;

    @FXML
    void atualizarCadastro() {
        ProfessorDAO dao = new ProfessorDAO();
        //TODO: Fazer validação dos campos;
        System.out.println(tbPane.getSelectionModel().getSelectedItem().getId());
        Professor prof = new Professor();
        prof.setId(idProfessor);
        prof.setCpf(txtCpf.getText());
        prof.setNome(txtNome.getText());
        prof.setTitulacao(txtTitulacao.getText());
        prof.setEspecializacao(txtEspecializacao.getText());
        prof.setSalario(Double.parseDouble(txtSalario.getText()));

        if(dao.update(prof)){
            System.out.println("Atualização bem sucedida!");
            txtCpf.setText("");
            txtNome.setText("");
            txtSalario.setText("");
            txtTitulacao.setText("");
            txtEspecializacao.setText("");
            enableDesable(true);
        } else {
            System.out.println("Erro na atualização!");
        }

    }

    @FXML
    void selecionarProfessor(){
        ProfessorDAO dao = new ProfessorDAO();
        Professor prof;
        try {
            int id = Integer.parseInt(txtIdPesquisar.getText());
            prof = dao.select(id);
            if(prof != null){
                idProfessor = Integer.parseInt(txtIdPesquisar.getText());
                txtCpf.setText(prof.getCpf());
                txtNome.setText(prof.getNome());
                txtTitulacao.setText(prof.getTitulacao());
                txtSalario.setText(""+prof.getSalario());
                txtEspecializacao.setText(prof.getEspecializacao());
                enableDesable(false);
            } else {

            }
        } catch (NumberFormatException n){
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ID INVÁLIDO!");
            alert.setHeaderText("Não foi possível Encontrar professor com ID informado!");
            alert.setContentText("Certifique-se de que o ID informado encontra-se cadastrado no sistema e que o campo esteja corretamente preenchido.");
            alert.show();
        }
        txtIdPesquisar.setText("");
    }

    private void enableDesable(boolean status) {
        txtCpf.setDisable(status);
        txtNome.setDisable(status);
        txtSalario.setDisable(status);
        txtTitulacao.setDisable(status);
        txtEspecializacao.setDisable(status);
        btnAtualizar.setDisable(status);
    }

    // TELA DE DELEÇÃO
    @FXML private TextField cpfProfessor;

    @FXML
    void deletar() {
        ProfessorDAO dao = new ProfessorDAO();
        int id = 0;
        try {
            id = Integer.parseInt(cpfProfessor.getText());
        } catch (NumberFormatException e) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("ID INVÁLIDO!");
            alert.setHeaderText("ID não corresponde a um professor!");
            alert.setContentText("Certifique-se de que o ID informado encontra-se cadastrado no sistema e que o campo esteja corretamente preenchido.");
            alert.show();
        }
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("DELEÇÃO!");
        alert.setHeaderText("Deseja realmente deletar o professor? ");
        alert.setContentText("Todos os dados serão apagados sem opção de recuperação.");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            if(!dao.delete(id)){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("ID INVÁLIDO!");
                alert.setHeaderText("ID não corresponde a um professor!");
                alert.setContentText("Certifique-se de que o ID informado encontra-se cadastrado no sistema e que o campo esteja corretamente preenchido.");
                alert.show();
            }
        }
        reList();
    }

    @FXML
    void reList(){
        initialize(null, null);
    }

    @FXML
    private TabPane tbPane;

    // TELA DE LISTAGEM
    @FXML
    private TextField txCpfprofessor;

    @FXML
    private TableColumn<Professor, String> cpfCol;

    @FXML
    private TableColumn<Professor, String> colEspecializacao;

    @FXML
    private TableColumn<Professor, Integer> idCol;

    @FXML
    private TableColumn<Professor, String> nomeCol;

    @FXML
    private TableView<Professor> profsListagemTb;

    @FXML
    private TableColumn<Professor, Double> colSalario;

    @FXML
    private TableColumn<Professor, String> colTitulacao;



    // TELA PESQUISA

    @FXML
    private Button btPesquisa;

    @FXML
    private HBox hbDados;

    @FXML
    private Label labelProf;

    @FXML
    private Label lblCpf;

    @FXML
    private Label lblEspecializacao;

    @FXML
    private Label lblId;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblSalario;

    @FXML
    private Label lblTitulacao;

    @FXML
    private Label txPesquisa;


    @FXML
    void pesquisarPorCpf() {
        ProfessorDAO prf = new ProfessorDAO();
        // TODO: Válidando entrada de dados, tela de pesquisa por cpf;
        Professor prof = prf.selectByCPF(txCpfprofessor.getText());

        if ( prof != null ){
            hbDados.setVisible(true);
            lblCpf.setText(prof.getCpf());
            lblId.setText(""+prof.getId());
            lblNome.setText(prof.getNome());
            lblSalario.setText(""+prof.getSalario());
            lblTitulacao.setText(prof.getTitulacao());
            lblEspecializacao.setText(prof.getEspecializacao());
            txCpfprofessor.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<Professor, Integer>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<Professor, String>("nome"));
        colCpf.setCellValueFactory(new PropertyValueFactory<Professor, String>("cpf"));
        String tabAtual = tbPane.getSelectionModel().getSelectedItem().getId();

        if(tabAtual.equals("cadastro"))
            tblProfessores.setItems(carregarProfessores());

        if(tabAtual.equals("listagem")){
            colSalario.setCellValueFactory(new PropertyValueFactory<Professor, Double>("salario"));
            idCol.setCellValueFactory(new PropertyValueFactory<Professor, Integer>("id"));
            nomeCol.setCellValueFactory(new PropertyValueFactory<Professor, String>("nome"));
            cpfCol.setCellValueFactory(new PropertyValueFactory<Professor, String>("cpf"));
            colTitulacao.setCellValueFactory(new PropertyValueFactory<Professor, String>("titulacao"));
            colEspecializacao.setCellValueFactory(new PropertyValueFactory<Professor, String>("especializacao"));

            profsListagemTb.setItems(carregarProfessores());
        }
    }

    private ObservableList carregarProfessores() {
        List<Professor> profs = dao.select();
        return FXCollections.observableArrayList(profs);
    }
}
