package com.miniprojeto.farmacia.app;

import com.miniprojeto.farmacia.controller.Farmacia;
import com.miniprojeto.farmacia.model.Funcionario;
import com.miniprojeto.farmacia.model.Medicamento;

import java.util.Scanner;

/**
 * Classe principal que executa o programa da farmácia.
 * Nela são instanciados os funcionários e medicamentos, além de permitir a interação
 * do próprio funcionário para realizar vendas.
 *
 * Seguindo essa lógica, estamos vendo a visão do funcionário, selecionando seu nome na lista,
 * selecionando qual medicamento e a quantidade que o cliente está comprando,
 * fazendo o programa realizar sua busca e trazendo o resultado para o lucro da farmácia e os bonus para o funcionário.
 *
 * Queria fazer duas atualizações para esse projeto, onde poderia informar dados como CPF do cliente e
 * formas de pagamento. A segunda atualização seria adicionar listas para cada tipo de medicamento,
 * por exemplo: Amoxicilina é um medicamento controlado. Iria criar uma categoria para isso,
 * onde somente clientes com receitas válidas poderão realizar a compra.
 */
public class Main {
    public static void main(String[] args) {
        // Criando a farmácia
        Farmacia farmacia = new Farmacia();

        // Adicionando medicamentos
        Medicamento paracetamol = new Medicamento("Paracetamol", 100, 2.5);
        Medicamento ibuprofeno = new Medicamento("Ibuprofeno", 50, 3.0);
        Medicamento amoxicilina = new Medicamento("Amoxicilina", 70, 4.0);
        Medicamento dipirona = new Medicamento("Dipirona", 80, 2.8);
        farmacia.adicionarMedicamento(paracetamol);
        farmacia.adicionarMedicamento(ibuprofeno);
        farmacia.adicionarMedicamento(amoxicilina);
        farmacia.adicionarMedicamento(dipirona);

        // Adicionando funcionários
        Funcionario funcionario1 = new Funcionario("João");
        Funcionario funcionario2 = new Funcionario("Maria");
        Funcionario funcionario3 = new Funcionario("Carlos");
        Funcionario funcionario4 = new Funcionario("Ana");
        farmacia.adicionarFuncionario(funcionario1);
        farmacia.adicionarFuncionario(funcionario2);
        farmacia.adicionarFuncionario(funcionario3);
        farmacia.adicionarFuncionario(funcionario4);

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
        System.out.println("Salário total de Carlos: R$" + funcionario3.calcularSalarioTotal());
        System.out.println("Salário total de Ana: R$" + funcionario4.calcularSalarioTotal());


        // Zerando bônus e lucro para o próximo dia
        farmacia.limparLucroEBonus();

        scanner.close();
    }
}
