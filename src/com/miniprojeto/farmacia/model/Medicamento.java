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
        return "Medicamento: " + nome + ", Quantidade: " + quantidade + ", Valor: " + valor;
    }
}
