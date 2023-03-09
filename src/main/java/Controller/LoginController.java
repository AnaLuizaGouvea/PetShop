/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import view.TelaLogin;
import view.TelaPrincipalFuncionario;
import view.TelaPrincipalGerente;

/**
 *
 * @author nalug
 */
public class LoginController {
    
    private static LoginController instancia;
    TelaLogin view;

    public LoginController() {
        view = new TelaLogin();
        
        
        view.getBtnEntrar().addActionListener((ActionEvent e) -> {
            if(view.getTxtCpf().getText().equals("999.999.999-99")&& view.getTxtSenha().getText().equals("1234")){ //SECRETARIO
                new TelaPrincipalFuncionario().setVisible(true); //LEVAR PARA PAG SECRETARIO
                view.dispose();
            }
            else if(view.getTxtCpf().getText().equals("111.111.111-11") && view.getTxtSenha().getText().equals("4321")){
                new TelaPrincipalGerente().setVisible(true);//LEVAR PARA PAGINA do gerente
                view.dispose();
            } 
            else{ //ERRO 
                JOptionPane.showMessageDialog(null, "Falha ao realizar o login!");

            }            
        });
        
        view.setVisible(true);
    }
    
    public static LoginController getInstancia(){
        if(instancia==null){
            instancia = new LoginController();
        }
        return instancia;
    }
    
    
}
