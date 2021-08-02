/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinal;

/**
 *
 * @author Rafael
 */
public class Automovel extends Veiculo{
    private ModeloAutomovel modelo;
    
    public Automovel(ModeloAutomovel modelo, Marca marca, Estado estado, Categoria categoria, Locacao locacao, double valorDeCompra, String placa, int ano) {
        super(marca, estado, categoria, locacao, valorDeCompra, placa, ano);
        this.modelo = modelo;
  
    }
    
    
    @Override
    public double getValorDiariaLocacao() {
        double valorDiaria = 0;

        switch (this.getCategoria().toString()) {
            case "POPULAR":
                valorDiaria = 100.00;
            break;
            case "INTERMEDIARIO":
                valorDiaria = 300.00;
            break;
            default:
                valorDiaria = 450.00;
            break;
        }

        return valorDiaria;
    };
    
    public ModeloAutomovel getModelo(){
        return this.modelo;
    }
   
 
}
