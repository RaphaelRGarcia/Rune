package rune;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.lang.String;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
/**
 *
 * @author rapha
 */
public class CriptografiaEscrita {//classe de criptografia e escrita em arquivo
    public CriptografiaEscrita(){}
    
    public static String Criptografa(String senha){//função de criptografia(assinatura para login)
        String senha_criptografada="";
        try{
        MessageDigest criptografia= MessageDigest.getInstance("SHA-256");//variável que armazena a mensagem digerida
        byte messageDigest[]=criptografia.digest(senha.getBytes("UTF-8"));//conversão para UTF-8
        StringBuilder hexStringSenha = new StringBuilder();
        for (byte b : messageDigest) {
              hexStringSenha.append(String.format("%02X", 0xFF & b));//construção da senha criptografada
        }
        senha_criptografada = hexStringSenha.toString();
        }
        catch(Exception e){
            System.err.println("Erro: "+e);
        }
        return senha_criptografada;
    }
    
    public static void Salva(SenhasRune senhas){//salva alterações no arquivo texto
        try{
            File arquivo = new File("#caminho arquivo");
            FileWriter fw;
            BufferedWriter bw;
            fw = new FileWriter(arquivo);
            bw= new BufferedWriter(fw);
            String senha;
            for(int i=0;i<senhas.getNumSenhas();i++){
                senha=Criptografa(senhas.getNomeInd(i),senhas.getSenhaInd(i));//passagem da string para string criptografada
                bw.write(senha);
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        catch(IOException e){
            System.err.println("Erro: "+e);
        }
    }
    
    public static SenhasRune LeArquivo(SenhasRune senhas){//função para leitura do arquivo para memória
        try{
            File arquivo = new File("#caminho arquivo");
            FileReader fr= new FileReader(arquivo);
            BufferedReader br= new BufferedReader(fr);
            String linha;
            String[] vals;
            SenhaRune senha=new SenhaRune();
            linha=br.readLine();
            while(arquivo.length()>0 && linha!=null){
                vals = linha.split(" ");
                senhas.adicionaSenha(Descriptografa(vals[0]), Descriptografa(vals[1]));//descriptografa os nomes e as senhas 
                linha=br.readLine();
                }
            br.close();
            fr.close();
        }
        catch(IOException e){
            System.err.println("Erro: "+e);
        }
        return senhas;
    }
    public static void InicializaSenha(){//função para criação da senha de login
        try{
            File arquivo= new File("#caminho arquivo");
            FileReader fr= new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(arquivo,true);
            BufferedWriter bw =new BufferedWriter(fw);
            if(br.readLine()==null){
                Scanner teclado=new Scanner(System.in);
                System.out.println("Defina uma senha de login");
                String log=teclado.nextLine();//recebe a senha
                log=CriptografiaEscrita.Criptografa(log);//criptografa a senha
                bw.write(log);
            br.close();
            fr.close();
            bw.close();
            fw.close();
            }
        }
        catch(IOException e){
            System.out.println("Erro: "+e);
        }
    }
        public static String getLogin(){//função que trás a senha de login para memória
        String login="";
        try{
            File arquivo= new File("#caminho arquivo");
            FileReader fr= new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            login=br.readLine();
            br.close();
            fr.close();
        }
        catch(IOException e){
            System.out.println("Erro: "+e);
        }
        return login;
    }
        
    public static String Criptografa(String nome,String senha){//função de criptografia(assinatura para senhas e nomes)
        String senha_codificada;
        String nome_codificado;
        nome_codificado= Base64.getEncoder().encodeToString(nome.getBytes());
        senha_codificada= Base64.getEncoder().encodeToString(senha.getBytes());
        String resultado= nome_codificado+" "+senha_codificada;
        return resultado;
    }
    
    public static String Descriptografa(String codigo){
        String resultado = new String(Base64.getDecoder().decode(codigo));
        return resultado;
    }
}   
