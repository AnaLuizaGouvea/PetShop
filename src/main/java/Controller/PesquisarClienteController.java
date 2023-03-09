/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Clientes;
import model.Cliente;
import view.TelaPesquisarCliente;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author nalug
 */
public class PesquisarClienteController {
    TelaPesquisarCliente view;
    private Clientes clientes;

    public PesquisarClienteController() {
        
        view = new TelaPesquisarCliente();
        
        this.clientes = Clientes.getInstancia();
        
             
        view.getBtnPesquisar().addActionListener((ActionEvent e)->{
            pesquisar();
            
        }); 
        
        loadTable();
        view.setVisible(true);
    }
    //METODOS
    
    public void pesquisar(){
        String cpf = view.getTxtCpf().getText();
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"CPF", "Nome do Cliente", "Nome do Animal"}, 0);

        for (Cliente c : clientes.getClientes()){
            if(c.getCpf().equals(cpf)){
               JOptionPane.showMessageDialog(view, "Encontrado");
            }

        }
    }
    
    //metodo CARREGAR TABELA
    
    public void loadTable(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"CPF", "Nome do Cliente", "Nome do Animal"}, 0);
        for (int i = 0; i < clientes.getClientes().size(); i++) {
            Object linha[] = new Object[]
            {clientes.getClientes().get(i).getCpf(), clientes.getClientes().get(i).getNome(), clientes.getClientes().get(i).getAnimal().getNomeAnimal()};

            modelo.addRow(linha);
        }
        view.getTblPesquisar().setModel(modelo);
    }

    public TelaPesquisarCliente getView() {
        return view;
    }

    public void setView(TelaPesquisarCliente view) {
        this.view = view;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    
    
    
}
