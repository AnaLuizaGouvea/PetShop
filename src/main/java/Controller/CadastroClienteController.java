/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import model.Animal;
import model.Cliente;
import model.Clientes;
import model.Endereco;
import model.State;
import view.TelaCadastroCliente;

/**
 *
 * @author nalug
 */
public class CadastroClienteController {

    TelaCadastroCliente view;
    private Clientes clientes;
    State modo;

    public CadastroClienteController() {//construtor

        view = new TelaCadastroCliente();

        this.clientes = Clientes.getInstancia();
        
        view.getTbl_cliente().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //QUANDO CLICA NA TABELA 
                int index = view.getTbl_cliente().getSelectedRow();

                if (index >= 0 && index < clientes.getClientes().size()) {
                    Cliente C = clientes.getClientes().get(index);
                    view.getTxtCpf().setText(C.getCpf());
                    view.getTxtNome().setText(C.getNome());

                    modo = State.SELECAO;
                    ManipulaInterface();

                }
            }
        });

        view.getBtnExcluir().addActionListener((ActionEvent e) -> {

            int index = view.getTbl_cliente().getSelectedRow();

            if (index >= 0 && index < clientes.getClientes().size()) {
                Cliente C = clientes.getClientes().get(index);
                clientes.getClientes().remove(index);

            }
            LoadTableCliente();
            modo = State.EXCLUIR;
            ManipulaInterface();
            limpar_campo();

        });/////

        view.getBtn_salvar_cliente().addActionListener((ActionEvent e) -> {

            cadastrar();
            limpar_campo();
            modo = State.NAVEGAR;
            ManipulaInterface();
            LoadTableCliente();

        });

        view.getBtn_novo_cliente().addActionListener((ActionEvent e) -> {
            modo = State.NOVO;
            ManipulaInterface();
            view.getBtn_salvar_cliente().setEnabled(true);

        });

        modo = State.NAVEGAR;
        ManipulaInterface();
        LoadTableCliente();
        view.setVisible(true);
    }

    //METODOS
    public void cadastrar() {
        String cpf = view.getTxtCpf().getText();
        String nomeC = view.getTxtNome().getText(); //o GET pega o nome escrito e o SET insere


        String rua = view.getTxtRua().getText();
        String bairro = view.getTxtBairro().getText();
        String cidade = view.getTxtCidade().getText();
        String numero = view.getTxtNumero().getText();

        String nomeAnimal = view.getTxtNomeAnimal().getText();
        String idadeAnimal = view.getTxtIdadeAnimal().getText();
        String racaAnimal = view.getTxtRaca().getText();

        Endereco endereco = new Endereco(numero, rua, bairro, cidade);
        Animal animal = new Animal(nomeAnimal, idadeAnimal, racaAnimal);
        Cliente cliente = new Cliente(cpf, nomeC, animal, endereco);
        clientes.adicionaCliente(cliente);
        JOptionPane.showMessageDialog(view, "Cliente cadastrado com sucesso");

    }

    public void LoadTableCliente() {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"CPF", "Nome do Cliente"}, 0);
        for (int i = 0; i < clientes.getClientes().size(); i++) {
            Object linha[] = new Object[]
            {clientes.getClientes().get(i).getCpf(), clientes.getClientes().get(i).getNome()};

            modelo.addRow(linha);
            
        }

        view.getTbl_cliente().setModel(modelo);
    }

    public void ManipulaInterface() {
        switch (modo) {

            case NAVEGAR -> {
                view.getBtn_salvar_cliente().setEnabled(false);
                view.getTxtNome().setEnabled(false);
                view.getTxtCpf().setEnabled(false);
                view.getTxtCidade().setEnabled(false);
                view.getTxtIdadeAnimal().setEnabled(false);
                view.getTxtNomeAnimal().setEnabled(false);
                view.getTxtNumero().setEnabled(false);
                view.getTxtRaca().setEnabled(false);
                view.getTxtRua().setEnabled(false);
                view.getTxtBairro().setEnabled(false);

                view.getBtn_novo_cliente().setEnabled(true);
                view.getBtnExcluir().setEnabled(false);
            }

            case NOVO -> {
                view.getBtn_salvar_cliente().setEnabled(true);
                view.getTxtNome().setEnabled(true);
                view.getTxtCpf().setEnabled(true);
                view.getTxtCidade().setEnabled(true);
                view.getTxtIdadeAnimal().setEnabled(true);
                view.getTxtNomeAnimal().setEnabled(true);
                view.getTxtNumero().setEnabled(true);
                view.getTxtRaca().setEnabled(true);

                view.getTxtRua().setEnabled(true);
                view.getTxtBairro().setEnabled(true);

                view.getBtn_novo_cliente().setEnabled(false);
                view.getBtnExcluir().setEnabled(false);
            }

            case EXCLUIR -> {
                view.getBtn_salvar_cliente().setEnabled(false);
                view.getTxtNome().setEnabled(false);
                view.getTxtCpf().setEnabled(false);
                view.getTxtCidade().setEnabled(false);
                view.getTxtIdadeAnimal().setEnabled(false);
                view.getTxtNomeAnimal().setEnabled(false);
                view.getTxtNumero().setEnabled(false);
                view.getTxtRaca().setEnabled(false);
                view.getTxtRua().setEnabled(false);
                view.getTxtBairro().setEnabled(false);

                view.getBtn_novo_cliente().setEnabled(true);
                view.getBtnExcluir().setEnabled(false);
            }

            case SELECAO -> {
                view.getBtn_salvar_cliente().setEnabled(false);
                view.getTxtNome().setEnabled(false);
                view.getTxtCpf().setEnabled(false);
                view.getTxtCidade().setEnabled(false);
                view.getTxtIdadeAnimal().setEnabled(false);
                view.getTxtNomeAnimal().setEnabled(false);
                view.getTxtNumero().setEnabled(false);
                view.getTxtRaca().setEnabled(false);
                view.getTxtRua().setEnabled(false);
                view.getTxtBairro().setEnabled(false);

                view.getBtn_novo_cliente().setEnabled(true);
                view.getBtnExcluir().setEnabled(true);
            }

            default -> {
                System.out.println("Modo inválido");
            }
        }

    }

    public void limpar_campo() {
        view.getTxtNome().setText("");//Limpar os campos
        view.getTxtCpf().setText("");
        view.getTxtBairro().setText("");
        view.getTxtRua().setText("");
        view.getTxtCidade().setText("");
        view.getTxtNumero().setText("");
        view.getTxtIdadeAnimal().setText("");
        view.getTxtRaca().setText("");
        view.getTxtNomeAnimal().setText("");

    }

    public TelaCadastroCliente getView() {
        return view;
    }

    public void setView(TelaCadastroCliente view) {
        this.view = view;
    }

}
