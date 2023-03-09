/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.table.DefaultTableModel;
import model.Clientes;
import view.TelaRegistrarVenda;

/**
 *
 * @author nalug
 */
public class RegistraVendaController {
    TelaRegistrarVenda view;
    private Clientes clientes;

    public RegistraVendaController() {
        view = new TelaRegistrarVenda();
        this.clientes = Clientes.getInstancia();
        
        
        
    }
    
    public void loadTable(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"CPF", "Cliente", "Serviço"}, 0);
        for (int i = 0; i < clientes.getClientes().size(); i++) {
            Object linha[] = new Object[]
            {clientes.getClientes().get(i).getCpf(), clientes.getClientes().get(i).getNome(), };

            modelo.addRow(linha);
        }

        view.getTblVendas().setModel(modelo);
    }
    
    
    
}
