package TrabalhoFinal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author nicol
 */
public class ModeloTabelaCliente extends AbstractTableModel {

   private String[] colunas= new String[]{"Nome", "Sobrenome", "CPF","RG", "Endereco"};
   private List<Cliente> lista = new ArrayList();

 

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
        Cliente cliente = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNome();//if column 1 (name)
            case 1: return cliente.getSobreNome();//if column 2 
            case 2: return cliente.getCpf();
            case 3: return cliente.getRg() ;
            case 4: return cliente.getEndereco() ;
            default : return null;
        }
    }

    public void adicionaCliente(List<Cliente> listaClientes) {
        this.lista = listaClientes;
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
        System.out.println(this.lista.size());
    }
    
    public int removeCliente(Cliente cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return linha;
    }
/* inserido extra pela ni - tentando fazer edição do cliente
    public boolean atualizarCliente(Cliente cliente){
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.add(cliente);// não sei usar o lista.add
        this.fireTableRowsUpdated(linha,linha);
        return result;
    }*/
   
   
    public void atualizarTabela(List<Cliente> lista){
        System.out.println(lista);
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

    public Cliente getCliente(int linha){
        return lista.get(linha);
    }
}
 

//verificar sobre manter cliente - editar
