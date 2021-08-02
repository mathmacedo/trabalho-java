/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinal;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mathe
 */
public class ModeloTabelaVeiculoVender extends AbstractTableModel {
    private String[] colunas = new String[]{"Marca", "Placa", "Ano", "Preço para venda", "Modelo"};
    private List<Veiculo> lista = new ArrayList();



    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        //if(column==0)
        //    return false;
        //return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = lista.get(rowIndex);
        
        Automovel a = null;
        Motocicleta m = null;
        Van v = null;
        
        String modelo = null;
        
        if(veiculo instanceof Automovel) {
            a = (Automovel)veiculo;
            modelo = a.getModelo().toString();
        } else if(veiculo instanceof Motocicleta) {
            m = (Motocicleta)veiculo;
            modelo = m.getModelo().toString();
        } else {
            v = (Van)veiculo;
            modelo = v.getModelo().toString();
        }
        
        
        NumberFormat valorFormatado = new DecimalFormat("#0.00");
        String valorVenda = "R$ " + valorFormatado.format(veiculo.getValorParaVenda());
        
        switch (columnIndex) {
            case 0: return veiculo.getMarca();//if column 1 (name)
            case 1: return veiculo.getPlaca();//if column 2
            case 2: return veiculo.getAno();
            case 3: return valorVenda;
            case 4: return modelo ;
            default : return null;
        }
    }

    public void adicionaVeiculo(List<Veiculo> listaVeiculos) {
        this.lista = listaVeiculos;
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
        
        
    }

    public int removeVeiculo(Veiculo veiculo) {
        int linha = this.lista.indexOf(veiculo);
        boolean result = this.lista.remove(veiculo);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return linha;
    }

    public void atualizarTabela(List<Veiculo> lista){
        this.lista = new ArrayList();
        this.lista.addAll(lista);
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Veiculo getVeiculo(int linha){
        return lista.get(linha);
    }

    public List<Veiculo> getLista(){
        return this.lista;
    }
}
