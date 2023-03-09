/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;


/**
 *
 * @author nalug
 */
public class Funcionarios {
    
    private  ArrayList<Funcionario> funcionarios;
    private static Funcionarios instancia;
    private File arquivo;
    
    
    private Funcionarios() {
        this.funcionarios = new ArrayList<>();
        arquivo = new File ("src/main/java/data/DataFuncionarios.txt");
        recuperaFuncionarios();
    }
    
    public static Funcionarios getInstancia(){
        
        if(instancia == null){
            Funcionarios.instancia = new Funcionarios();
        }
        return instancia;
    }

    public  ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public  void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        funcionarios = funcionarios;
    }
    
    public void adicionaFuncionario(Funcionario funcionario){

        funcionarios.add(funcionario);
        gravaFuncionario(funcionario);

        
    }
    
   // private void recuperaFuncionarios(){
        
     //   this.funcionarios = new ArrayList<>();
        
        //if(arquivo diferente de vazio){
             //TODO: ler o arquivo texto, e preencher o arraylist com os clientes que estao no arquivo texto
        //}       
   // }
    
    public void gravaFuncionario(Funcionario funcionario){
        try {
            FileWriter fw = new FileWriter("src/main/java/data/DataFuncionarios.txt", true);
            PrintWriter pw= new PrintWriter(fw);//escreve o conteudo no arquivo
            
            pw.println(funcionario.getCpf() + "\t" + funcionario.getNome() + "\t" + funcionario.getEndereco().getRua() + "\t"
                    + funcionario.getEndereco().getNumero() + "\t" + funcionario.getEndereco().getCidade()
                    + "\t" + funcionario.getEndereco().getBairro());// this.nome chma a variavel da classe cliente
            
            pw.flush();//envia os dados no mesmo momento e não armazena no buffer de memoria
            pw.close();
            fw.close();           
            
        } catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void carregarTabela(){
        recuperaFuncionarios();
    }
    
    private void recuperaFuncionarios(){
         try {
            Scanner scan = new Scanner(arquivo);
            while (scan.hasNextLine()) {//enquanto tiver uma nova linha
                String linha = scan.nextLine();
                Scanner scanline = new Scanner(linha);
                scanline.useDelimiter("\t");
                if (scanline.hasNext()) {

                    String cpf = scanline.next();
                    String nome = scanline.next();
                    String senha = scanline.next();
                    String rua = scanline.next();
                    String numero = scanline.next();
                    String cidade = scanline.next();
                    String bairro = scanline.next();
                    Endereco endereco = new Endereco(numero, rua, bairro, cidade);
                    
                    funcionarios.add(new Funcionario(cpf, nome, senha, endereco));
                }
            }
            arquivo.delete();

        } catch (Exception e) {

        }
    }
    
    
}
