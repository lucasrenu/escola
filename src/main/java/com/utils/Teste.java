package com.utils;

import java.util.List;

import com.classes.Professor;

public class Teste {
    public static void main(String[] args) {
        ProfessorDAO doa = new ProfessorDAO();
        Professor prof = new Professor("Lucas", "09876543210", 18000, "Doutorado", "Computação");
        Professor profs = new Professor("Sávio", "09876543212", 12000, "Mestrado", "Computação");
        Professor prof2 = new Professor("Matheus", "40028922111", 6200, "Graduado", "Inglês");
        //doa.delete("09876543210");
        //doa.insert(prof);

        List<Professor> prfs = doa.select();

        for (Professor professor : prfs) {
            System.out.printf("\nProfessor:\n"+
            "\nCPF: " + professor.getCPF()+
            "\nNome: " + professor.getNome()+
            "\nTitulação: " + professor.getTitulacao());
        }
    }
}
