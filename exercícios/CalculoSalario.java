import java.util.Scanner;
public class CalculoSalario {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o número de horas trabalhadas: ");
        double horas_Trabalhadas = scanner.nextDouble();

        System.out.print("Digite o valor que recebe por hora: ");
        double valor_Hora = scanner.nextDouble();

        System.out.print("Digite o número de filhos com idade inferior a 14 anos: ");
        int numero_Filhos = scanner.nextInt();

        System.out.print("Digite a idade do funcionário: ");
        int idade = scanner.nextInt();

        System.out.print("Digite o tempo de serviço do funcionário (em anos): ");
        int tempo_Servico = scanner.nextInt();

        System.out.print("Digite o valor do salário família por filho: ");
        double salario_Familia_Filho = scanner.nextDouble();

        double salario_Bruto = horas_Trabalhadas * valor_Hora;
        double inps = salario_Bruto * 0.085;
        double salario_Familia = numero_Filhos * salario_Familia_Filho;

        double ir;
        if (salario_Bruto > 1500) {
            ir = salario_Bruto * 0.15;
        } else if (salario_Bruto > 500) {
            ir = salario_Bruto * 0.08;
        } else {
            ir = 0;
        }
        double adicional = 0;
        if (idade > 40) {
            adicional = salario_Bruto * 0.02;
        } else if (tempo_Servico > 15) {
            adicional = salario_Bruto * 0.035;
        } else if (tempo_Servico > 5 && idade > 30) {
            adicional = salario_Bruto * 0.015;
        }

        double total_Descontos = inps + ir;
        double salario_Liquido = salario_Bruto + salario_Familia + adicional - total_Descontos;

        System.out.println("Número do Funcionário: " + nome);
        System.out.printf("Salário Bruto: %.2f\n", salario_Bruto);
        System.out.printf("Total de Descontos: %.2f\n", total_Descontos);
        System.out.printf("Adicional: %.2f\n", adicional);
        System.out.printf("Salário Líquido: %.2f\n", salario_Liquido);

        scanner.close();
    } }
