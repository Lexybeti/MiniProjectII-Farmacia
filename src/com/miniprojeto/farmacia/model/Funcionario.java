package com.miniprojeto.farmacia.

public class Funcionario {
    private String nome;
    private int bonus;
    private double salarioBase;
    private double salarioExtra;

    public Funcionario(String nome) {
        this.nome = nome;
        this.bonus = 0;
        this.salarioBase = 1350.0;
        this.salarioExtra = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getSalarioExtra() {
        return salarioExtra;
    }

    public void setSalarioExtra(double salarioExtra) {
        this.salarioExtra = salarioExtra;
    }

    public double calcularSalarioTotal() {
        return salarioBase + salarioExtra + bonus;
    }

    @Override
    public String toString() {
        return "Funcionario: " + nome + ", Salário Base: " + salarioBase + ", Salário Extra: " + salarioExtra + ", Bônus: " + bonus;
    }
}
