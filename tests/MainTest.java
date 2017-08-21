import org.junit.Test;
import org.junit.Assert;

public class MainTest {

    @Test
    public void testarValoresDoProduto() {
        int quantidade = 5;
        float preco = 10;

        Produto produto = new Produto("p", quantidade, preco);

        Assert.assertEquals(quantidade, produto.getQuant());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarValoresDoProdutoComQuantidadeInvalida() {
        int quantidade = -1;
        float preco = 10;

        Produto produto = new Produto("p", quantidade, preco);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarValoresDoProdutoComPrecoInvalido() {
        int quantidade = 1;
        float preco = -1;

        Produto produto = new Produto("p", quantidade, preco);
    }

    @Test
    public void testarQtd() {
        Loja loja = new Loja();

        loja.addProduto(new Produto("p", 1, 10));
        loja.addProduto(new Produto("p1", 2, 20));
        loja.addProduto(new Produto("p2", 3, 30));

        Assert.assertEquals(loja.Quantidade(), 3);
    }

    @Test
    public void testarQtdLojaVazia() {
        Loja loja = new Loja();

        Assert.assertEquals(loja.Quantidade(), 0);
    }

    @Test
    public void testarRemocao() {
        Loja loja = new Loja();

        loja.addProduto(new Produto("p", 1, 10));
        loja.addProduto(new Produto("p1", 2, 20));
        loja.addProduto(new Produto("p2", 3, 30));
        Assert.assertEquals(loja.Quantidade(), 3);

        loja.removerProduto("p");
        Assert.assertEquals(loja.Quantidade(), 2);

        loja.removerProduto("p1");
        Assert.assertEquals(loja.Quantidade(), 1);
    }

    @Test
    public void testarRemocaoComLojaVazia() {
        Loja loja = new Loja();

        Assert.assertEquals(false, loja.removerProduto("p1"));
    }

    @Test
    public void testarRemocaoComProdutoAdicionadoERemovido() {
        Loja loja = new Loja();

        loja.addProduto(new Produto("p", 1, 1));

        Assert.assertEquals(true, loja.removerProduto("p"));
        Assert.assertEquals(false, loja.removerProduto("p"));
    }

    @Test
    public void testarBusca() {
        Loja loja = new Loja();

        loja.addProduto(new Produto("p", 1, 10));

        Assert.assertEquals(true, loja.Busca("p"));
        Assert.assertEquals(false, loja.Busca("naoExiste"));
    }

    @Test
    public void testarBuscaComLojaVazia() {
        Loja loja = new Loja();

        Assert.assertEquals(false, loja.Busca("p"));
    }

    @Test
    public void testarBuscaComProdutoRemovido() {
        Loja loja = new Loja();

        loja.addProduto(new Produto("p", 1, 1));
        loja.removerProduto("p");

        Assert.assertEquals(false, loja.Busca("p"));
    }

    @Test
    public void testarAdd() {
        Loja loja = new Loja();

        loja.addProduto(new Produto("p", 1, 10));

        Assert.assertEquals(1, loja.Quantidade());
        Assert.assertEquals(true, loja.Busca("p"));
    }
}