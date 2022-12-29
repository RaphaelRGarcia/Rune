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
public class CriptografiaEscrita {
    public CriptografiaEscrita(){}
    
    public static String Criptografa(String senha){
        String senha_criptografada="";
        try{
        MessageDigest criptografia= MessageDigest.getInstance("SHA-256");
        byte messageDigest[]=criptografia.digest(senha.getBytes("UTF-8"));
        StringBuilder hexStringSenha = new StringBuilder();
        for (byte b : messageDigest) {
              hexStringSenha.append(String.format("%02X", 0xFF & b));
        }
        senha_criptografada = hexStringSenha.toString();
        }
        catch(Exception e){
            System.err.println("Erro: "+e);
        }
        return senha_criptografada;
    }
    
    public static void Salva(SenhasRune senhas){
        try{
            File arquivo = new File("C:\\Users\\rapha\\OneDrive\\Documents\\Testes\\Cripto\\Arquivo de armazenamento de senhas");
            FileWriter fw;
            BufferedWriter bw;
            fw = new FileWriter(arquivo);
            bw= new BufferedWriter(fw);
            String senha;
            for(int i=0;i<senhas.getNumSenhas();i++){
                senha=Criptografa(senhas.getNomeInd(i),senhas.getSenhaInd(i));
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
    
    public static SenhasRune LeArquivo(SenhasRune senhas){
        try{
            File arquivo = new File("C:\\Users\\rapha\\OneDrive\\Documents\\Testes\\Cripto\\Arquivo de armazenamento de senhas");
            FileReader fr= new FileReader(arquivo);
            BufferedReader br= new BufferedReader(fr);
            String linha;
            String[] vals;
            SenhaRune senha=new SenhaRune();
            linha=br.readLine();
            while(linha!=null){
                vals = linha.split(" ");
                senhas.adicionaSenha(Descriptografa(vals[0]), Descriptografa(vals[1]));
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
    public static void InicializaSenha(){
        try{
            File arquivo= new File("C:\\Users\\rapha\\OneDrive\\Documents\\Testes\\Cripto\\login.txt");
            FileReader fr= new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(arquivo,true);
            BufferedWriter bw =new BufferedWriter(fw);
            if(br.readLine()==null){
                Scanner teclado=new Scanner(System.in);
                System.out.println("Defina uma senha de login");
                String log=teclado.nextLine();
                log=CriptografiaEscrita.Criptografa(log);
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
        public static String getLogin(){
        String login="";
        try{
            File arquivo= new File("C:\\Users\\rapha\\OneDrive\\Documents\\Testes\\Cripto\\login.txt");
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
        
    public static String Criptografa(String nome,String senha){
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