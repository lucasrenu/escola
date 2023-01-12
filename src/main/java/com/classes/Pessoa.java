package com.classes;

public class Pessoa {
    private int id;
    private String cpf;
    private String nome;

    public Pessoa() {}

    public Pessoa(int id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Pessoa(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null){
            this.nome = nome;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf != null && cpf.length() == 11){
            this.cpf = cpf;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "-----------------\nInformações Usuário\nNome: " + nome + "\nCpf: " + cpf;
    }
}