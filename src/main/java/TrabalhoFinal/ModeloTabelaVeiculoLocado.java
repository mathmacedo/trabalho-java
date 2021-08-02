/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoFinal;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mathe
 */
public class ModeloTabelaVeiculoLocado extends AbstractTableModel{
    private String[] colunas = new String[]{"Nome do cliente", "Placa", "Marca", "Modelo", "Ano", "Data de locação", "Preço da diaria", "Qtdade dias locados", "Valor locação"};
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
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = df.format(veiculo.getLocacao().getData().getTime());
        
        NumberFormat valorFormatado = new DecimalFormat("#0.00");
        String valorLocacaoDiario = "R$ " + valorFormatado.format(veiculo.getValorDiariaLocacao());
        String valorLocacao = "R$ " + valorFormatado.format(veiculo.getLocacao().getValor());
        
        switch (columnIndex) {
            case 0: return veiculo.getLocacao().getCliente().getNome();//if column 1 (name)
            case 1: return veiculo.getPlaca();//if column 2
            case 2: return veiculo.getMarca();
            case 3: return modelo;
            case 4: return veiculo.getAno() ;
            case 5: return dataFormatada;
            case 6: return valorLocacaoDiario;
            case 7: return veiculo.getLocacao().getDias();
            case 8: return valorLocacao;
            default : return null;
        }
    }
    
    public void atualizarTabela(List<Veiculo> lista){
        this.lista = new ArrayList();
        this.lista.addAll(lista);
        this.fireTableDataChanged();
    }
    
    public int removeVeiculoLocado(Veiculo veiculo) {
        int linha = this.lista.indexOf(veiculo);
        this.lista.remove(veiculo);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return linha;
    }
}
