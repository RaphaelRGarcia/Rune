/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rune;

import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
/**
 *
 * @author rapha
 */
public class SenhasRune {
    private ArrayList<String> senhas= new ArrayList<>();
    private ArrayList<String> nomes= new ArrayList<>();
    private int num_senhas;
    
    public SenhasRune(){
    }
    
    public void adicionaSenha(String nome,String senha){
        this.nomes.add(nome);
        this.senhas.add(senha);
        num_senhas++;
    }
    
    public void removeSenha(int pos){
        this.nomes.remove(pos);
        this.senhas.remove(pos);
        num_senhas--;
    }

    public void verNomes(){
        for(int i=0;i<this.senhas.size();i++){
            System.out.println(i+" "+this.nomes.get(i));
        }
    }

    public int getNumSenhas(){
        return this.num_senhas;
    }
    
    public String getSenhaInd(int index){
        return this.senhas.get(index);
    }
    
    public String getNomeInd(int index){
        return this.nomes.get(index);
    }
    
}