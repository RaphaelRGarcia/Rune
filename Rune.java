/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rune;
import java.lang.String;
import java.util.Scanner;
/**
 *
 * @author rapha
 */
public class Rune {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        SenhasRune senhas= new SenhasRune();
        String entrar;
        CriptografiaEscrita.InicializaSenha();
        System.out.println("Digite sua senha :");
        entrar=teclado.nextLine();
        if(CriptografiaEscrita.getLogin().equals(CriptografiaEscrita.Criptografa(entrar))){
            senhas=CriptografiaEscrita.LeArquivo(senhas);
            int op;
            do{
                System.out.println("Bem Vindo!");
                System.out.println("1 - Adicionar senha");
                System.out.println("2 - Remover senha");
                System.out.println("3 - Ver senhas");
                System.out.println("0 - Sair");
                op=teclado.nextInt();
                teclado.nextLine();//bug scanner
                switch(op){
                    case 1:
                        System.out.println("Digite o nome da senha e a senha");
                        String nome=teclado.nextLine();
                        String pass=teclado.nextLine();
                        SenhaRune senha=new SenhaRune();
                        senha.setSenha(pass);
                        senhas.adicionaSenha(nome, senha.getSenha());
                        CriptografiaEscrita.Salva(senhas);
                        break;
                    case 2:
                        System.out.println("Senhas registradas");
                        senhas.verNomes();
                        System.out.println("Digite o número da senha que gostaria de remover!");
                        int passop=teclado.nextInt();
                        System.out.println("Tem certeza?\n1-Sim\n2-Outra tecla");
                        op=teclado.nextInt();
                        if(op==1)senhas.removeSenha(passop);
                        CriptografiaEscrita.Salva(senhas);
                        break;
                    case 3:
                        System.out.println("Digite senha de login:");
                        entrar=teclado.nextLine();
                        if(CriptografiaEscrita.getLogin().equals(CriptografiaEscrita.Criptografa(entrar))){
                            if(senhas.getNumSenhas()>0){
                                for(int i=0;i<senhas.getNumSenhas();i++){
                                    System.out.println(senhas.getNomeInd(i)+" "+ senhas.getSenhaInd(i));
                                }
                            }
                            else{
                                System.out.println("Não existem senhas");
                            }
                        }
                        else{System.out.println("Senha incorreta!");}
                        break;
                    default:
                        System.out.println("Opção inválida!");
                    }
            }while(op!=0);
        }
        else{
            System.out.println("Senha incorreta");
        }
    }
}
