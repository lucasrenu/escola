package com.classes;

public class Professor extends Pessoa{

    private double salario;
    private String titulacao;
    private String especializacao;

    public Professor() {
    }

    public Professor(int id, String nome, String cpf, double salario, String titulacao, String especializacao) {
        super(id, cpf, nome);
        this.salario = salario;
        this.titulacao = titulacao;
        this.especializacao = especializacao;
    }

    public Professor(String nome, String cpf, double salario, String titulacao, String especializacao) {
        super(nome, cpf);
        setSalario(salario);
        setTitulacao(titulacao);
        setEspecializacao(especializacao);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario >= 0){
            this.salario = salario;
        }
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        if(titulacao != null){
            this.titulacao = titulacao;
        }
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        if(especializacao != null){
            this.especializacao = especializacao;
        }
    }

    @Override
    public String toString() {
        return "Professor \nsalario:" + salario + "\ntitulacao: " + titulacao + "\nespecializacao:" + especializacao;
    }


}
