import java.util.Scanner;

public class Condicao {

 public static void main(String[] args){
    
 
    Scanner N1 = new Scanner (System.in);
    System.out.println ("insira um número");
    int Valor1 = N1.nextInt();
    Scanner N2 = new Scanner(System.in);
    System.out.println("insira outro número");
    int Valor2 = N2.nextInt();
    N1.close();
    N2.close();

     if(Valor2 > Valor1) {
        System.out.println(Valor2 +" é maior que " + Valor1);
        System.out.println(Valor1 + " é menor que " + Valor2);
    }
 } 
}