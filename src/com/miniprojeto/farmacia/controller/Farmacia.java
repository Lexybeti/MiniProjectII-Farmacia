import java.util.ArrayList;
import java.util.List;

public class Farmacia {
    private double lucro;
    private List<Medicamento> medicamentos;
    private List<Funcionario> funcionarios;

    public Farmacia() {
        this.lucro = 0;
        this.medicamentos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    // Método para buscar funcionário pelo nome
    private Funcionario encontrarFuncionario(String nomeFuncionario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nomeFuncionario)) {
                return funcionario;
            }
        }
        return null; // Retorna null se o funcionário não for encontrado
    }

    // Método para buscar medicamento pelo nome
    private Medicamento encontrarMedicamento(String nomeMedicamento) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNome().equalsIgnoreCase(nomeMedicamento)) {
                return medicamento;
            }
        }
        return null; // Retorna null se o medicamento não for encontrado
    }

    // Método para realizar venda, incluindo verificação de funcionário
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

            // Atualiza bônus do funcionário
            funcionario.setBonus(funcionario.getBonus() + quantidadeVendida);

            // Verifica se o funcionário atingiu o bônus de 30
            if (funcionario.getBonus() >= 30) {
                funcionario.setSalarioExtra(funcionario.getSalarioExtra() + 100);
                funcionario.setBonus(0); // Reseta o bônus após o aumento
                System.out.println(funcionario.getNome() + " atingiu 30 pontos de bônus e ganhou R$100 de salário extra!");
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

    @Override
    public String toString() {
        return "Farmacia com lucro de: " + lucro + "\nMedicamentos: " + medicamentos + "\nFuncionários: " + funcionarios;
    }
}
