public class Produto {

    protected String nome;

    protected int quant;

    protected float preco;

    public static int ID = 1;

    public Produto(String nome, int quantidade, float preco) {
        super();
        this.setName(nome);
        this.setQuant(quantidade);
        this.setPreco(preco);
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quantidade) {
        if (quantidade >= 0) {
            this.quant = quantidade;
        } else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public String toString() {
        return "Nome do Produto =" + nome + "\nquantidade=" + quant + "\npreco=" + preco + "]";
    }


}
