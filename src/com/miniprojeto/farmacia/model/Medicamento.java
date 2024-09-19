package com.miniprojeto.farmacia.model;

/**
 * Classe que representa os medicamentos.
 * Ela possui as informações como nome, quantidade e valor dos medicamentos.
 * Possui também uma maneira de reescrever os medicamentos que forem adicionados na Main.
 */
public class Medicamento {
    private String nome;
    private int quantidade;
    private double valor;

    public Medicamento(String nome, int quantidade, double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return nome + ", Quantidade: " + quantidade + ", Valor: " + valor;
    }
}
