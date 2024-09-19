package com.miniprojeto.farmacia.app;

import com.miniprojeto.farmacia.controller.Farmacia;
import com.miniprojeto.farmacia.model.Funcionario;
import com.miniprojeto.farmacia.model.Medicamento;

import java.util.Scanner;

public class Main {
    public static <Farmacia> void main(String[] args) {
        // Criando a farmácia
        Farmacia farmacia = new Farmacia();

        // Adicionando medicamentos
        Medicamento paracetamol = new Medicamento("Paracetamol", 100, 2.5);
        Medicamento ibuprofeno = new Medicamento("Ibuprofeno", 50, 3.0);
        farmacia.adicionarMedicamento(paracetamol);
        farmacia.adicionarMedicamento(ibuprofeno);

        // Adicionando funcionários
        Funcionario funcionario1 = new Funcionario("João");
        Funcionario funcionario2 = new Funcionario("Maria");
        farmacia.adicionarFuncionario(funcionario1);
        farmacia.adicionarFuncionario(funcionario2);

        // Scanner para capturar entradas do usuário
        Scanner scanner = new Scanner(System.in);
        String nomeFuncionario;
        String nomeMedicamento;
        int quantidade;
        String continuar;

        // Loop de vendas
        do {
            // Listar funcionários e medicamentos
            farmacia.listarFuncionarios();
            System.out.print("Selecione o nome do funcionário: ");
            nomeFuncionario = scanner.nextLine();

            farmacia.listarMedicamentos();
            System.out.print("Selecione o nome do medicamento: ");
            nomeMedicamento = scanner.nextLine();

            System.out.print("Informe a quantidade a ser vendida: ");
            quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            // Realizar a venda
            farmacia.venderMedicamento(nomeFuncionario, nomeMedicamento, quantidade);

            // Perguntar se o usuário quer continuar
            System.out.print("Deseja realizar outra venda? (sim/não): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("sim"));

        // Exibir o lucro da farmácia e o salário dos funcionários após as vendas
        System.out.println("Lucro final: " + farmacia.getLucro());
        System.out.println("Salário total de João: R$" + funcionario1.calcularSalarioTotal());
        System.out.println("Salário total de Maria: R$" + funcionario2.calcularSalarioTotal());

        scanner.close();
    }
}
