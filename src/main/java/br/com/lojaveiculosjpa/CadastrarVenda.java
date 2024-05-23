package br.com.lojaveiculosjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Date;
import java.util.Scanner;

public class CadastrarVenda {

    private EntityManager entityManager;
    private Scanner scanner;

    public CadastrarVenda(EntityManager entityManager, Scanner scanner) {
        this.entityManager = entityManager;
        this.scanner = scanner;
    }

    public void cadastrarVenda() {
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("Cadastro de Venda");
        System.out.print("Digite o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();
        System.out.print("Digite a placa do veículo vendido: ");
        String placaVeiculo = scanner.nextLine();
        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite o valor da venda: ");
        double valorVenda = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer após ler um double
        System.out.print("Digite o status da venda (À venda/Vendido): ");
        String status = scanner.nextLine();

        Venda venda = new Venda();
        venda.setCpfCliente(cpfCliente);
        venda.setPlacaVeiculo(placaVeiculo);
        venda.setMarca(marca);
        venda.setModelo(modelo);
        venda.setValor(valorVenda);
        venda.setData(new Date());
        venda.setStatus(status);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(venda);
        transaction.commit();

        System.out.println("Venda cadastrada com sucesso.");
    }
}

