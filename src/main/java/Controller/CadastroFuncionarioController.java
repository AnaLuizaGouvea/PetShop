/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Funcionario;
import view.TelaCadastroFuncionario;
import model.Funcionarios;

/**
 *
 * @author nalug
 */
public class CadastroFuncionarioController {
    
    TelaCadastroFuncionario view;
    private Funcionarios funcionarios;
 

    public CadastroFuncionarioController() {
        view = new TelaCadastroFuncionario();
        
        this.funcionarios= Funcionarios.getInstancia();
        
        view.getBtnSalvar().addActionListener((ActionEvent e) -> {
            cadastrar();
            limpacampo();
            loadTable();
        });
        
        loadTable();
        view.setVisible(true);

    }
    //METODOS
    public void cadastrar(){
            String cpf = view.getTxtCpfFuncionario().getText();
            String nomeC = view.getTxtNomeFuncionario().getText(); //o GET pega o nome escrito e o SET insere
            String senha = view.getTxtSenhaFuncionario().getText();

            String rua = view.getTxtRua().getText();
            String bairro = view.getTxtBairro().getText();
            String cidade = view.getTxtCidade().getText();
            String numero = view.getTxtNumero().getText();
            
            Endereco endereco = new Endereco(numero, rua, bairro, cidade);
            Funcionario funcionario = new Funcionario(cpf, nomeC, senha, endereco);
            funcionarios.adicionaFuncionario(funcionario);
            JOptionPane.showMessageDialog(view,"Funcionario Cadastrado com sucesso"); 
            
            
            
            //AQUI DEVERIA ESTAR CHAMANDO o arraylista
    }
        
    public void loadTable(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"CPF", "Nome", "Senha"}, 0);
        for (int i = 0; i < funcionarios.getFuncionarios().size(); i++){
            Object linha[] = new Object[]
            {funcionarios.getFuncionarios().get(i).getCpf(), funcionarios.getFuncionarios().get(i).getNome(), funcionarios.getFuncionarios().get(i).getSenha()};
           
            modelo.addRow(linha);
        }
        
        view.getTblFuncionarios().setModel(modelo);
        
    }
    
    public void limpacampo(){
        view.getTxtNomeFuncionario().setText("");//Limpar os campos
        view.getTxtCpfFuncionario().setText("");
        view.getTxtSenhaFuncionario().setText("");
        view.getTxtBairro().setText("");
        view.getTxtRua().setText("");
        view.getTxtCidade().setText("");
        view.getTxtNumero().setText("");
    }

    public TelaCadastroFuncionario getView() {
        return view;
    }

    public void setView(TelaCadastroFuncionario view) {
        this.view = view;
    }


    
    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }
    
}
