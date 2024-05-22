package view;
import java.io.IOException;
import controller.GerenciadorObras;
import model.ObraDeArte;

public class Sistema {

    private static void exibirMenu() {

        System.out.println("\nGERENCIADOR DE OBRAS DE ARTE");
        System.out.println("1) Cadastrar Obra de Arte");
        System.out.println("2) Buscar Obra de Arte");
        System.out.println("3) Excluir Obra de Arte");
        System.out.println("4) Atualizar Obra de Arte Existente");
        System.out.println("5) Listar todas as Obras de Arte");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");

    }

    private static void verificarOpcao(int op) {

        switch (op) {
            case 1:
                salvarObra();
                break;
            case 2:
                buscarObra(); 
                break;
            case 3:
                apagarObra();
                break;
            case 4:
                atualizarObra();
                break;
            case 5:
                listarTodos();
                break;
            case 0:
                System.out.println("\nO sistema foi finalizado...");
                break;
            default:
                System.out.println("\nOpção inválida. Digite novamente");
                break;
        }
    }

     private static void salvarObra() {

        System.out.println("\nNova Obra de Arte:");
        
        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        System.out.print("Informe o artista que criou a obra: ");
        String artista = Console.lerString();

        System.out.print("Informe o ano de criação: ");
        int anoCriacao = Console.lerInt();

        System.out.print("Informe o tipo de obra (pintura, escultura, etc.): ");
        String tipoObra = Console.lerString();

        System.out.print("Informe o local do museu onde a obra está sendo exposta: ");
        String local = Console.lerString();

        ObraDeArte obra = new ObraDeArte(titulo, artista, anoCriacao, tipoObra, local);

        try {

            GerenciadorObras.salvarObra(obra);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }


    }

    private static void buscarObra() {

        System.out.println("\nBuscar Obra de Arte");
        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        try {

            ObraDeArte obra = GerenciadorObras.buscarObra(titulo);
            System.out.println("\nObra de Arte encontrada: " + obra);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void apagarObra() {

        System.out.println("\nApagar Obra de Arte");
        System.out.print("Informe o título da obra que deseja apagar: ");
        String titulo = Console.lerString();

        try {

            GerenciadorObras.apagarObra(titulo);
            System.out.println("\nObra de Arte excluída com sucesso!");
        
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }

    private static void listarTodos() {

        System.out.println("\nObras de Arte Cadastradas:");

        try {

            for (ObraDeArte tempObra : GerenciadorObras.listarObras())
            {
                System.out.println(tempObra);
            }
        
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public static void atualizarObra() {
        System.out.println("\nAtualizar Obra de Arte:");

        System.out.print("Informe o título da obra que deseja atualizar: ");
        String titulo = Console.lerString();

        System.out.print("Informe o novo título (deixe vazio para não alterar): ");
        String novoTitulo = Console.lerString();

        System.out.print("Informe o novo artista (deixe vazio para não alterar): ");
        String novoArtista = Console.lerString();

        System.out.print("Informe o novo ano de criação (ou 0 para não alterar): ");
        int novoAnoCriacao = Console.lerInt();

        System.out.print("Informe o novo tipo de obra (deixe vazio para não alterar): ");
        String novoTipoObra = Console.lerString();

        System.out.print("Informe o novo local do museu (deixe vazio para não alterar): ");
        String novoLocal = Console.lerString();

        try {
            GerenciadorObras.atualizarObra(titulo, novoTitulo, novoArtista, novoAnoCriacao, novoTipoObra, novoLocal);
            System.out.println("Obra de arte atualizada com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    

    public static void executar() {

        int op;

        do {

            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);

        } while (op != 0);

    }

}