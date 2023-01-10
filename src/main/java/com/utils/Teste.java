package com.utils;

import com.classes.Professor;

public class Teste {
    public static void main(String[] args) {
        ProfessorDAO doa = new ProfessorDAO();
        Professor prof = new Professor("Lucas", "09876543210", 18000, "Doutorado", "Computação");
        Professor profs = new Professor("Sávio", "09876543212", 12000, "Mestrado", "Computação");

        doa.insert(profs);
    }
}
