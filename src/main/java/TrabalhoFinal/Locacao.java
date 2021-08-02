/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinal;

import java.util.Calendar;

/**
 *
 * @author Rafael
 */
public class Locacao {
    private int dias;
    private double valor;
    private Calendar data;
    private Cliente cliente;

    public Locacao(int dias, double valor, Calendar data, Cliente cliente) {
        this.dias = dias;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }
    

    public double getValor(){
        return valor;
    }
    
    public Calendar getData(){
        return data;
    }
 
    public Cliente getCliente(){
        return cliente;
    }
    
    public int getDias() {
        return this.dias;
    }
}