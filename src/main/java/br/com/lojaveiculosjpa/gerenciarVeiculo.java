package br.com.lojaveiculosjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.entidade.Veiculo;

public class gerenciarVeiculo {

    private EntityManager entityManager;
    private Scanner scanner;

    public gerenciarVeiculo(EntityManager entityManager, Scanner scanner) {
        this.entityManager = entityManager;
        this.scanner = scanner;
    }

    public void menuVeiculo() {
        while (true) {
            System.out.println("Opção 1 - Consultar Veículo por Placa");
            System.out.println("Opção 2 - Listar todos os Veículos");
            System.out.println("Opção 3 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    consultarVeiculoPorPlaca();
                    break;
                case 2:
                    listarTodosOsVeiculos();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void consultarVeiculoPorPlaca() {
        System.out.print("Digite a placa do veículo: ");
        scanner.nextLine(); // Limpar o buffer do scanner
        String placa = scanner.nextLine();

        entityManager.getTransaction().begin();
        Veiculo veiculo = entityManager.find(Veiculo.class, placa);
        entityManager.getTransaction().commit();

        if (veiculo != null) {
            System.out.println("Veículo encontrado:");
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Marca: " + veiculo.getMarca());
            System.out.println("Modelo: " + veiculo.getModelo());
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private void listarTodosOsVeiculos() {
        entityManager.getTransaction().begin();
        TypedQuery<Veiculo> query = entityManager.createQuery("SELECT v FROM Veiculo v", Veiculo.class);
        List<Veiculo> veiculos = query.getResultList();
        entityManager.getTransaction().commit();

        if (!veiculos.isEmpty()) {
            System.out.println("Todos os veículos:");
            for (Veiculo veiculo : veiculos) {
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("-----------------------------------");
            }
        } else {
            System.out.println("Não há veículos cadastrados.");
        }
    }

	public void gerenciarVeiculo() {
		// TODO Auto-generated method stub
		
	}
}

