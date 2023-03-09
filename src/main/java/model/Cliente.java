/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Animal;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nalug
 */
public class Cliente {
    private String cpf;
    private String nome;

    private Animal animal;
    private Endereco endereco;    

    public Cliente() {
    }

    public Cliente(String cpf, String nome, Animal animal, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.animal = animal;
        this.endereco = endereco;
    }

   

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


   /*public void cadastrar_cliente(){
        
        
        try {
            
            FileWriter fw = new FileWriter("clientes.txt", true);
            
            PrintWriter pw= new PrintWriter(fw);//escreve o conteudo no arquivo
            
            
            pw.println(this.nome+"\t"+ this.cpf+"\t"+this.endereco.getRua()+"\t"+this.endereco.getNumero()+"\t"+this.endereco.getCidade()+"\t"+this.endereco.getBairro()+"\t"+this.animal.getIdade()+"\t"+this.animal.getNomeAnimal()+"\t"+this.animal.getRaca());// this.nome chma a variavel da classe cliente
            
            //pw.println("CPF: "+this.cpf);
            //pw.println("Nome animal: "+this.animal.getNomeAnimal());
            pw.flush();//envia os dados no mesmo momento e não armazena no buffer de memoria
            pw.close();
            fw.close();
            
            
                    
                    
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }*/
    
    
    
    
    
}
