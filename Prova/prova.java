import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Prova {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/escola";
        String user = "root"; 
        String password = "";

        Scanner scanner = new Scanner(System.in); // Scanner movido para fora do try

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            while (true) { // Loop para manter o menu ativo até o usuário escolher sair
                System.out.println("Escolha uma opção:");
                System.out.println("1. Atualizar despesas com soma dos salários");
                System.out.println("2. Excluir aluno por ID");
                System.out.println("3. Excluir funcionário por ID");
                System.out.println("4. Sair");
                System.out.print("Opção: ");

                int opcao;
                try {
                    opcao = Integer.parseInt(scanner.nextLine()); // Validação da entrada
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, insira um número válido.");
                    continue;
                }

                if (opcao == 1) {
                    String query = "UPDATE despesas SET salario_funcionarios = (SELECT SUM(salario) FROM funcionarios)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    int rowsAffected = stmt.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Tabela despesas atualizada com sucesso!");
                    } else {
                        System.out.println("Nenhuma atualização foi feita.");
                    }
                } else if (opcao == 2) {
                    System.out.print("Digite o ID do aluno a ser excluído: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    excluirPorId(conn, "aluno", id);
                } else if (opcao == 3) {
                    System.out.print("Digite o ID do funcionário a ser excluído: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    excluirPorId(conn, "funcionarios", id);
                } else if (opcao == 4) {
                    System.out.println("Saindo...");
                    break; // Encerra o loop e sai do programa
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close(); // Scanner fechado no bloco finally
        }
    }

    // Método para excluir registros por ID
    private static void excluirPorId(Connection conn, String tabela, int id) {
        try {
            String query = "DELETE FROM " + tabela + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(tabela.substring(0, 1).toUpperCase() + tabela.substring(1) + " excluído com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com o ID fornecido na tabela " + tabela + ".");
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir registro: " + e.getMessage());
        }
    }
}