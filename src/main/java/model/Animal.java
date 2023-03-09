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
public class Animal {
    private String nomeAnimal;
    private String idade;
    private String raca;

    public Animal(String nomeAnimal, String idade, String raca) {
        this.nomeAnimal = nomeAnimal;
        this.idade = idade;
        this.raca = raca;
    }

    
    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

   
    
    public void cadastrar_animal(){
        
        try {
           
            FileWriter fw = new FileWriter("clientes.txt", true);
            PrintWriter pw= new PrintWriter(fw);//escreve o conteudo no arquivo
            pw.println("Dados do Animal");
            pw.println("Nome do Animal: "+this.nomeAnimal);// this.nome chma a variavel da classe cliente
            pw.println("Idade: "+this.idade);
            pw.println("Raça: "+this.raca);
            pw.flush();//envia os dados no mesmo momento e não armazena no buffer de memoria
            pw.close();
            fw.close();
            System.out.println("");
            
            
        } catch (IOException ex) {
            Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
        }
           

     
        
    }

   
    
    
    
}
