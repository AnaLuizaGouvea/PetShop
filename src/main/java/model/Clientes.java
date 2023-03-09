/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nalug
 */
public class Clientes {

    private ArrayList<Cliente> clientes;
    private static Clientes instancia;
    private File arquivo;

    private Clientes() {
        this.clientes = new ArrayList<>();
        arquivo = new File("src/main/java/data/DataClientes.txt");
        recuperaClientes();
    }

    public static Clientes getInstancia() {

        if (instancia == null) {
            Clientes.instancia = new Clientes();
        }
        return instancia;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        clientes = clientes;
    }

    public void adicionaCliente(Cliente cliente) {

        //add na lista
        clientes.add(cliente);
        // add no arquivo texto
        gravaCliente(cliente);
    }

    private void gravaCliente(Cliente cliente) {

        try {
            FileWriter fw = new FileWriter("src/main/java/data/DataClientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);//escreve o conteudo no arquivo

            pw.println(cliente.getCpf() + "\t" + cliente.getNome() + "\t" + cliente.getEndereco().getRua() + "\t" + cliente.getEndereco().getNumero() + "\t" + cliente.getEndereco().getCidade() + "\t" + cliente.getEndereco().getBairro() + "\t" + cliente.getAnimal().getIdade() + "\t" + cliente.getAnimal().getNomeAnimal() + "\t" + cliente.getAnimal().getRaca());// this.nome chma a variavel da classe cliente
            pw.flush();//envia os dados no mesmo momento e não armazena no buffer de memoria
            pw.close();
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluiCliente(Cliente cliente) {
        boolean acharCpf = false;
        for (int i = 0; i < clientes.size(); i++) {

        }

    }

    public void carregarTabela(Cliente cliente) {

        recuperaClientes();

    }

    private void recuperaClientes() {

        // zerar o arraylist
        try {
            Scanner scan = new Scanner(arquivo);
            while (scan.hasNextLine()) {//enquanto tiver uma nova linha
                String linha = scan.nextLine();
                Scanner scanline = new Scanner(linha);
                scanline.useDelimiter("\t");
                if (scanline.hasNext()) {

                    String cpf = scanline.next();
                    String nome = scanline.next();
                    String rua = scanline.next();
                    String numero = scanline.next();
                    String cidade = scanline.next();
                    String bairro = scanline.next();
                    String idade = scanline.next();
                    String nomeAnimal = scanline.next();
                    String raca = scanline.next();

                    Endereco endereco = new Endereco(numero, rua, bairro, cidade);
                    Animal animal = new Animal(nomeAnimal, idade, raca);
                    clientes.add(new Cliente(cpf, nome, animal, endereco));
                }
            }
            arquivo.delete();

        } catch (Exception e) {

        }
        //if(arquivo diferente de vazio){
        //TODO: ler o arquivo texto, e preencher o arraylist com os clientes que estao no arquivo texto
        //}
    }

}
