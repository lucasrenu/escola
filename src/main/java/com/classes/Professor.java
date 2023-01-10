package com.classes;

public class Professor extends Pessoa{

    private double salario;
    private String titulacao;
    private String formacao;
    private double impostos;
    private double qtdAula;
    private double HoraAula;
    private double totalAtt;
    private double attCorrigidas;

    public Professor() {
    }

    public Professor(String nome, String cpf, double salario, String titulacao, String formacao, double impostos,
            double qtdAula, double horaAula, double totalAtt, double attCorrigidas) {
        super(nome, cpf);
        this.salario = salario;
        this.titulacao = titulacao;
        this.formacao = formacao;
        this.impostos = impostos;
        this.qtdAula = qtdAula;
        this.HoraAula = horaAula;
        this.totalAtt = totalAtt;
        this.attCorrigidas = attCorrigidas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public double getImpostos() {
        return impostos;
    }

    public void setImpostos(double impostos) {
        this.impostos = impostos;
    }

    public double getQtdAula() {
        return qtdAula;
    }

    public void setQtdAula(double qtdAula) {
        this.qtdAula = qtdAula;
    }

    public double getHoraAula() {
        return HoraAula;
    }

    public void setHoraAula(double horaAula) {
        HoraAula = horaAula;
    }

    public double getTotalAtt() {
        return totalAtt;
    }

    public void setTotalAtt(double totalAtt) {
        this.totalAtt = totalAtt;
    }

    public double getAttCorrigidas() {
        return attCorrigidas;
    }

    public void setAttCorrigidas(double attCorrigidas) {
        this.attCorrigidas = attCorrigidas;
    }

    @Override
    public String toString() {
        return "Professor \nSalário = " + salario + " Titulacao = " + titulacao + "\n Formacao = " + formacao + "\t impostos = "
                + impostos + "\n qtdAula = " + qtdAula + "\t HoraAula = " + HoraAula + "\n totalAtt = "  + totalAtt
                + "\t attCorrigidas = " + attCorrigidas;
    }

    
    public double CalcularSalario(){
        return salario - impostos;
    }

    public double horasAulaSemanal(){
        return qtdAula * HoraAula;
    }

    public double attFaltamCorrigir(){
        return totalAtt - attCorrigidas;
    }
   
    

    
}
