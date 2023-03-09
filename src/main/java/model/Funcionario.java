/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nalug
 */
public class Funcionario {
    private String cpf;
    private String nome;
    private String senha;
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(String cpf, String nome, String senha, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Funcionario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    

   
    
    
   /* public String cadastrar_funcionario(){
        
        try {
            FileWriter fw = new FileWriter("funcionarios.txt", true);
            PrintWriter pw= new PrintWriter(fw);//escreve o conteudo no arquivo
            
            pw.println("Nome: "+this.nome);// this.nome chma a variavel da classe cliente
            pw.println("CPF: "+this.nome);
            pw.println("Senha: "+this.senha);
            pw.flush();//envia os dados no mesmo momento e não armazena no buffer de memoria
            pw.println("");
            pw.close();
            fw.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Cadastro efetuado com sucesso!";
        
    }*/
    
    
    
}
