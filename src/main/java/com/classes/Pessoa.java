package com.classes;

public class Pessoa {
    
    private String cpf;
    private String nome;
    
    public Pessoa() {
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getcpf() {
        return cpf;
    }

    public void cpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "-----------------\nInformações Usuário\nNome: " + nome + "\nCpf: " + cpf;
    }
    
    

    
}