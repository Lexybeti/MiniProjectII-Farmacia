package com.miniprojeto.farmacia.controller;

import com.miniprojeto.farmacia.model.Funcionario;
import com.miniprojeto.farmacia.model.Medicamento;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe que representa a farmácia.
 * Ela possui uma lista de medicamentos e de funcionários,
 * além de gerenciar o lucro da farmácia e realizar as vendas.
 */
public class Farmacia {
    private double lucro;
    private List<Medicamento> medicamentos;
    private List<Funcionario> funcionarios;


    /**
     * Construtor da classe Farmacia.
     * Inicializa as listas de medicamentos e funcionários e define o lucro como 0.
     */
    public Farmacia() {
        this.lucro = 0;
        this.medicamentos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    //Método para adicionar um medicamento à lista de medicamentos da farmácia.
    public void adicionarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

     //Método para adicionar um funcionário à lista de funcionário da farmácia.
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    /**
     * Método privado para encontrar um funcionário pelo nome.
     * Retorna o funcionário se ele for encontrado, ou null caso contrário.
     */
    private Funcionario encontrarFuncionario(String nomeFuncionario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nomeFuncionario)) {
                return funcionario;
            }
        }
        return null; // Retorna null se o funcionário não for encontrado
    }

    /**
     * Método privado para encontrar um medicamento pelo nome.
     * Retorna o medicamento se ele for encontrado, ou null caso contrário.
     */
    private Medicamento encontrarMedicamento(String nomeMedicamento) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNome().equalsIgnoreCase(nomeMedicamento)) {
                return medicamento;
            }
        }
        return null; // Retorna null se o medicamento não for encontrado
    }

    /**
     * Método que realiza a venda de um medicamento.
     * Verifica se o funcionário e o medicamento existem, atualiza o estoque e o bônus do funcionário,
     * e aumenta o lucro da farmácia. Se o funcionário realizar 3 vendas, ele ganha um bônus de R$100.
     */
    public void venderMedicamento(String nomeFuncionario, String nomeMedicamento, int quantidadeVendida) {
        Funcionario funcionario = encontrarFuncionario(nomeFuncionario);
        Medicamento medicamento = encontrarMedicamento(nomeMedicamento);

        if (funcionario == null) {
            System.out.println("Funcionário " + nomeFuncionario + " não encontrado.");
            return;
        }

        if (medicamento == null) {
            System.out.println("Medicamento " + nomeMedicamento + " não encontrado.");
            return;
        }

        if (medicamento.getQuantidade() >= quantidadeVendida) {
            // Atualiza estoque e lucro
            medicamento.setQuantidade(medicamento.getQuantidade() - quantidadeVendida);
            lucro += quantidadeVendida * medicamento.getValor();

            // A cada venda, acrescenta 10 de bônus
            funcionario.setBonus(funcionario.getBonus() + 10);

            // Verifica se o funcionário atingiu 30 pontos de bônus (3 vendas)
            if (funcionario.getBonus() >= 30) {
                funcionario.setSalarioExtra(funcionario.getSalarioExtra() + 100);
                funcionario.setBonus(0); // Reseta o bônus após o aumento
                System.out.println(funcionario.getNome() + " realizou 3 vendas e ganhou R$100 de salário extra!");
            }

            System.out.println("Venda realizada: " + quantidadeVendida + " unidades de " + medicamento.getNome() +
                    " pelo funcionário " + funcionario.getNome());
        } else {
            System.out.println("Estoque insuficiente para " + medicamento.getNome());
        }
    }

    public double getLucro() {
        return lucro;
    }

    // Método para listar todos os medicamentos
    public void listarMedicamentos() {
        System.out.println("Medicamentos disponíveis:");
        for (Medicamento medicamento : medicamentos) {
            System.out.println(medicamento);
        }
    }

    // Método para listar todos os funcionários
    public void listarFuncionarios() {
        System.out.println("Funcionários disponíveis:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
    }

    /**
     * Método que limpa o lucro da farmácia e os bônus de todos os funcionários.
     * O lucro é resetado para 0 e o bônus de cada funcionário também.
     */
    public void limparLucroEBonus() {
        this.lucro = 0;  // Zera o lucro da farmácia

        // Percorre a lista de funcionários e zera o bônus de cada um
        for (Funcionario funcionario : funcionarios) {
            funcionario.setBonus(0);  // Zera o bônus do funcionário
            System.out.println("Bônus do funcionário " + funcionario.getNome() + " foi zerado.");
        }

        System.out.println("Lucro da farmácia foi zerado.");
    }

    //OBS: Testei inúmeras formas de lista até mesmo na classe Main, essa foi a que se encaixou melhor.

    @Override
    public String toString() {
        return "Farmacia com lucro de: " + lucro + "\nMedicamentos: " + medicamentos + "\nFuncionários: " + funcionarios;
    }
}
