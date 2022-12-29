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
public class SenhasRune {//classe que guarda nomes, senhas e número de senhas em memória
    private ArrayList<String> senhas= new ArrayList<>();
    private ArrayList<String> nomes= new ArrayList<>();
    private int num_senhas;
    
    public SenhasRune(){
    }
    
    public void adicionaSenha(String nome,String senha){//função que adiciona nomes e senhas nos ArrayLists e incrementa o número de senhas
        this.nomes.add(nome);
        this.senhas.add(senha);
        num_senhas++;
    }
    
    public void removeSenha(int pos){//remove nomes e senhas dos ArrayLists e decrementa o número de senhas
        this.nomes.remove(pos);
        this.senhas.remove(pos);
        num_senhas--;
    }

    public void verNomes(){//imprime os nomes
        for(int i=0;i<this.senhas.size();i++){
            System.out.println(i+" "+this.nomes.get(i));
        }
    }

    public int getNumSenhas(){//retorna o número de senhas
        return this.num_senhas;
    }
    
    public String getSenhaInd(int index){//retorna a senha do índice
        return this.senhas.get(index);
    }
    
    public String getNomeInd(int index){//retorna o nome do índice
        return this.nomes.get(index);
    }
    
}
