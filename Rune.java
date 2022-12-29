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
        CriptografiaEscrita.InicializaSenha();//carrega a senha para memória
        System.out.println("Digite sua senha :");
        entrar=teclado.nextLine();//recebe a senha do teclado
        if(CriptografiaEscrita.getLogin().equals(CriptografiaEscrita.Criptografa(entrar))){//compara senha de login com a entrada
            senhas=CriptografiaEscrita.LeArquivo(senhas);//carrega as senhas dos arquivos para a memória
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
                        senha.setSenha(pass);//define a senha
                        senhas.adicionaSenha(nome, senha.getSenha());//adiciona o nome e a senha na memória
                        CriptografiaEscrita.Salva(senhas);//salva as mudanças no arquivo
                        break;
                    case 2:
                        System.out.println("Senhas registradas");
                        senhas.verNomes();//função que imprime os nomes
                        System.out.println("Digite o número da senha que gostaria de remover!");
                        int passop=teclado.nextInt();//recebe o indece da senha para ser removida
                        System.out.println("Tem certeza?\n1-Sim\n2-Outra tecla");
                        op=teclado.nextInt();
                        if(op==1)senhas.removeSenha(passop);//caso seja confirmado remove a senha da memória
                        CriptografiaEscrita.Salva(senhas);//salva mudanças em arquivo
                        break;
                    case 3:
                        System.out.println("Digite senha de login:");
                        entrar=teclado.nextLine();
                        if(CriptografiaEscrita.getLogin().equals(CriptografiaEscrita.Criptografa(entrar))){//verifica a senha com a entrada
                            if(senhas.getNumSenhas()>0){
                                for(int i=0;i<senhas.getNumSenhas();i++){
                                    System.out.println(senhas.getNomeInd(i)+" "+ senhas.getSenhaInd(i));//imprime os nomes e suas senhas
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
