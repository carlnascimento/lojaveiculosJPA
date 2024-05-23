package br.com.lojaveiculosjpa;


import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Menu {

	
	private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static Scanner scanner;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("lojaveiculosjpa");
        entityManager = entityManagerFactory.createEntityManager();
        scanner = new Scanner(System.in);

        while (true) {
            exibirMenuPrincipal();
            int opcaoPrincipal = scanner.nextInt();

            switch (opcaoPrincipal) {
                case 1:
                    gerenciarVeiculo();
                    break;
                case 2:
                    gerenciarLoja();
                    break;
                case 3:
                    gerenciarVendedor();
                    break;
                case 4:
                    gerenciarCliente();
                    break;
                case 5:
                    gerenciarVenda();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("Opção 1 - Gerenciar Veículo");
        System.out.println("Opção 2 - Gerenciar Loja");
        System.out.println("Opção 3 - Gerenciar Vendedor");
        System.out.println("Opção 4 - Gerenciar Cliente");
        System.out.println("Opção 5 - Gerenciar Venda");
        System.out.println("Opção 6 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void gerenciarVeiculo() {
        System.out.println("Opção 1 - Cadastrar Veículo");
        System.out.println("Opção 2 - Voltar para o menu superior");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                gerenciarVeiculo gerenciarVeiculo = new gerenciarVeiculo(entityManager, scanner);
                gerenciarVeiculo.gerenciarVeiculo();
                break;
            case 2:
                return;
            default:
                System.out.println("Opção inválida.");
        }

    private static void consultarVeiculoPorPlaca() {
        // Implementar consulta por placa usando JPA e Hibernate
    }

    private static void gerenciarLoja() {
        System.out.println("Opção 1 - Listar todas as Lojas");
        System.out.println("Opção 2 - Voltar para o menu superior");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                listarTodasAsLojas();
                break;
            case 2:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void listarTodasAsLojas() {
        // Implementar listagem de todas as lojas usando JPA e Hibernate
    }

    private static void gerenciarVendedor() {
        System.out.println("Opção 1 - Consultar Vendedor por Nome");
        System.out.println("Opção 2 - Voltar para o menu superior");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                consultarVendedorPorNome();
                break;
            case 2:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void consultarVendedorPorNome() {
        // Implementar consulta de vendedor por nome usando JPA e Hibernate
    }

    private static void gerenciarCliente() {
        System.out.println("Opção 1 - Cadastrar Cliente");
        System.out.println("Opção 2 - Consultar Cliente por CPF");
        System.out.println("Opção 3 - Voltar para o menu superior");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                consultarClientePorCPF();
                break;
            case 3:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void cadastrarCliente() {
        // Implementar cadastro de cliente usando JPA e Hibernate
    }

    private static void consultarClientePorCPF() {
        // Implementar consulta de cliente por CPF usando JPA e Hibernate
    }

    private static void gerenciarVenda() {
        System.out.println("Opção 1 - Cadastrar Venda");
        System.out.println("Opção 2 - Voltar para o menu superior");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                CadastrarVenda cadastrarVenda = new CadastrarVenda(entityManager, scanner);
                cadastrarVenda.cadastrarVenda();
                break;
            case 2:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }
    
    
}

