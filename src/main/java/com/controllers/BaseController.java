package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.classes.Professor;
import com.utils.ProfessorDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class BaseController implements Initializable{
    @FXML
    void mudarTelaDeletar() throws IOException {
        App.setRoot("teladeletar");
    }

    @FXML
    void mudarTelaPesquisa() throws IOException {
        App.setRoot("telapesquisa");
    }

    @FXML
    void mudarTelaUpgrade() throws IOException {
        App.setRoot("update");
    }

    @FXML
    void mudarParaCadastro() throws IOException {
        App.setRoot("telacadastro");
    }


// NOVO MODELO

    // TELA DE CADASTRO
    private ProfessorDAO dao = new ProfessorDAO();

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

    @FXML void cadastrar() {
        Professor prof = new Professor();
        if(txCpf.getText() != null && !txCpf.getText().trim().isEmpty() &&  txEspecializacao.getText() != null && !txEspecializacao.getText().trim().isEmpty() && txNome.getText() != null && !txNome.getText().trim().isEmpty() && txSalario.getText() != null && !txSalario.getText().trim().isEmpty() && txTitulacao.getText() != null && !txTitulacao.getText().trim().isEmpty()){
            prof.setCpf(txCpf.getText());
            prof.setEspecializacao(txEspecializacao.getText());
            prof.setNome(txNome.getText());
            prof.setSalario(Double.parseDouble(txSalario.getText()));
            prof.setTitulacao(txTitulacao.getText());
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

    // @FXML
    // void mudarParaCadastro() throws IOException {
    //     App.setRoot("telacadastro");
    // }

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
            desabilitarAtualizacao();
        } else {
            System.out.println("Erro na atualização!");
        }

    }

    @FXML
    void selecionarProfessor(){
        ProfessorDAO dao = new ProfessorDAO();
        Professor prof;
        int id = Integer.parseInt(txtIdPesquisar.getText());
        prof = dao.select(id);
        habilitarAtualizacao();

        if(prof != null){
            idProfessor = Integer.parseInt(txtIdPesquisar.getText());
            txtCpf.setText(prof.getCpf());
            txtNome.setText(prof.getNome());
            txtTitulacao.setText(prof.getTitulacao());
            txtSalario.setText(""+prof.getSalario());
            txtEspecializacao.setText(prof.getEspecializacao());
        }
        txtIdPesquisar.setText("");
    }

    private void desabilitarAtualizacao() {
        txtCpf.setDisable(true);
        txtNome.setDisable(true);
        txtSalario.setDisable(true);
        txtTitulacao.setDisable(true);
        txtEspecializacao.setDisable(true);
        btnAtualizar.setDisable(true);
    }

    private void habilitarAtualizacao() {
        txtCpf.setDisable(false);
        txtNome.setDisable(false);
        txtSalario.setDisable(false);
        txtTitulacao.setDisable(false);
        txtEspecializacao.setDisable(false);
        btnAtualizar.setDisable(false);
    }

    // TELA DE DELEÇÃO
    @FXML private TextField cpfProfessor;

    @FXML void deletar() {
        ProfessorDAO professor = new ProfessorDAO();
        professor.delete(Integer.parseInt(cpfProfessor.getText()));
    }

    @FXML
    void goCadastro(){
        initialize(null, null);
    }

    @FXML
    void goListagem(){
        initialize(null, null);
    }

    @FXML
    private TabPane tbPane;

    // TELA DE LISTAGEM / PESQUISA
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

    @FXML
    void pesquisarPorCpf() {
        ProfessorDAO prf = new ProfessorDAO();
        //TODO: Válidando entrada de dados, tela de pesquisa por cpf;
        // Professor prof = prf.selectByCPF(txCpfprofessor.getText());

        // if ( prof != null ){
        //     hbDados.setVisible(true);
        //     lblCpf.setText(prof.getCpf());
        //     lblId.setText(""+prof.getId());
        //     lblNome.setText(prof.getNome());
        //     lblSalario.setText(""+prof.getSalario());
        //     lblTitulacao.setText(prof.getTitulacao());
        //     lblEspecializacao.setText(prof.getEspecializacao());
        //     txCpfprofessor.setText("");
        // }
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
        // else if (tabAtual.equals("listagem")){
        // }
    }

    private ObservableList carregarProfessores() {
        List<Professor> profs = dao.select();
        return FXCollections.observableArrayList(profs);
    }
}
