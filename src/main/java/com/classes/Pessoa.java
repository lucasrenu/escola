package com.classes;

public class Pessoa {

    private String cpf;
    private String nome;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf) {
        setNome(nome);
        setCPF(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null){
            this.nome = nome;
        }
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        if(cpf != null && cpf.length() == 11){
            this.cpf = cpf;
        }
    }

    @Override
    public String toString() {
        return "-----------------\nInformações Usuário\nNome: " + nome + "\nCpf: " + cpf;
    }




}