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
public class Van extends Veiculo {
    private  ModeloVan modelo;
  

    public Van(ModeloVan modelo, Marca marca, Estado estado, Categoria categoria, Locacao locacao, double valorDeCompra, String placa, int ano) {
        super(marca, estado, categoria, locacao, valorDeCompra, placa, ano);
        this.modelo = modelo;
       
    }

   
    public ModeloVan getModelo(){
        return this.modelo;
    }

    @Override
    public double getValorDiariaLocacao() {
        double valorDiaria = 0;

        switch (this.getCategoria().toString()) {
        case "POPULAR":
        valorDiaria = 200.00;
        break;
        case "INTERMEDIARIO":
        valorDiaria = 400.00;
        break;
        default:
        valorDiaria = 600.00;
        break;
        }

        return valorDiaria;
    }
    
 
  
}