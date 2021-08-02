package TrabalhoFinal;
import java.util.Calendar;
/**
 *
 * @author Rafael
 */
public abstract class Veiculo implements VeiculoI {
    Marca marca;
    Estado estado;
    Categoria categoria;
    Locacao locacao;
    double valorDeCompra; // pq estamos usando valorDeCompra e não valorParaVenda como o método lá em baixo?
    String placa;
    int ano;
    public Veiculo(Marca marca, Estado estado, Categoria categoria, Locacao locacao, double valorDeCompra, String placa, int ano) {
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.locacao = locacao;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    @Override
    public Marca getMarca() {
        return marca;
    }

    @Override
    public Estado getEstado() { 
        return estado; 
   }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public Locacao getLocacao() {
        return locacao;
    }

    public double getValorDeCompra() {  // CRIAMOS ESTE METODO PRA USAR NO MODELOTABELA VEICULO E TB NO METODO GET VALOR PARA VENDA
        return valorDeCompra;
    }

    @Override
    public String getPlaca(){
        return this.placa;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        this.estado = Estado.LOCADO;
        Locacao novaLocacao = new Locacao(dias, this.getValorDiariaLocacao() * dias, data, cliente);
        this.locacao = novaLocacao;
    }

    @Override
    public void vender(){
        this.estado = Estado.VENDIDO;
    }

    @Override
    public void devolver(){
        this.estado = Estado.DISPONIVEL;
    }

    @Override
    public double getValorParaVenda() {
        double valorVenda = this.valorDeCompra - (((2021 - ano) * 0.15) * valorDeCompra);
        double percentageCompra10PerCent = (this.valorDeCompra - (this.valorDeCompra * 0.9));

        if (valorVenda < percentageCompra10PerCent || valorVenda < 0) {
            valorVenda = this.valorDeCompra * 0.1;
        }

        return valorVenda;
    }
    
    @Override
    public abstract double getValorDiariaLocacao();
  
}