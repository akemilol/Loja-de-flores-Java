import models.Produto;
import repository.LojaRepository;
import repository.LojaRepositoryImpl;
import enums.CategoriaProduto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LojaRepository produtoRepository = new LojaRepositoryImpl();
        Scanner leitor = new Scanner(System.in);
        int op;

        do {
            System.out.println("Menu" +
                    "\n0- Sair" +
                    "\n1- Cadastrar" +
                    "\n2- Listar" +
                    "\n3- Consultar por código" +
                    "\n4- Consultar por nome" +
                    "\n5- Alterar" +
                    "\n6- Excluir" +
                    "\nDigite a operação desejada: ");
            op = leitor.nextInt();
            leitor.nextLine();  // Consome a nova linha

            switch (op) {
                // Cadastrar
                case 1:
                    System.out.print("Digite o ID do produto: ");
                    int id = leitor.nextInt();
                    leitor.nextLine();  // Consome a nova linha
                    System.out.print("Digite o nome do produto: ");
                    String nome = leitor.nextLine();
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = leitor.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = leitor.nextDouble();
                    leitor.nextLine();  // Consome a nova linha

                    // Escolhendo a categoria
                    System.out.println("Escolha a categoria do produto: ");
                    for (CategoriaProduto c : CategoriaProduto.values()) {
                        System.out.println(c.ordinal() + " - " + c);
                    }
                    int catOrdinal = leitor.nextInt();
                    CategoriaProduto categoria = CategoriaProduto.values()[catOrdinal];

                    Produto produto = new Produto(id, nome, descricao, preco, categoria);
                    produtoRepository.cadastrar(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                // Listar
                case 2:
                    System.out.println("Lista de Produtos:");
                    for (Produto p : produtoRepository.listar()) {
                        System.out.println(p);
                    }
                    break;
                // Consultar Produto por ID
                case 3:
                    System.out.print("Digite o ID do produto: ");
                    int idBusca = leitor.nextInt();
                    Produto produtoEncontrado = produtoRepository.consultarPorId(idBusca);
                    if (produtoEncontrado != null) {
                        System.out.println("Produto encontrado: " + produtoEncontrado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                // Consultar Produto por Nome
                case 4:
                    System.out.print("Digite o nome do produto: ");
                    String nomeBusca = leitor.nextLine();
                    Produto produtoPorNome = produtoRepository.consultarPorNome(nomeBusca);
                    if (produtoPorNome != null) {
                        System.out.println("Produto encontrado: " + produtoPorNome);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                // Alterar Produto
                case 5:
                    System.out.print("Digite o ID do produto a alterar: ");
                    int idAlterar = leitor.nextInt();
                    leitor.nextLine();  // Consome a nova linha
                    System.out.print("Digite o novo nome do produto: ");
                    String novoNome = leitor.nextLine();
                    System.out.print("Digite a nova descrição do produto: ");
                    String novaDescricao = leitor.nextLine();
                    System.out.print("Digite o novo preço do produto: ");
                    double novoPreco = leitor.nextDouble();
                    leitor.nextLine();  // Consome a nova linha

                    // Alterando a categoria
                    System.out.println("Escolha a nova categoria do produto: ");
                    for (CategoriaProduto c : CategoriaProduto.values()) {
                        System.out.println(c.ordinal() + " - " + c);
                    }
                    int novaCatOrdinal = leitor.nextInt();
                    CategoriaProduto novaCategoria = CategoriaProduto.values()[novaCatOrdinal];

                    Produto produtoAlterado = new Produto(idAlterar, novoNome, novaDescricao, novoPreco, novaCategoria);
                    if (produtoRepository.alterar(produtoAlterado)) {
                        System.out.println("Produto alterado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                // Excluir produto
                case 6:
                    System.out.print("Digite o ID do produto a excluir: ");
                    int idExcluir = leitor.nextInt();
                    if (produtoRepository.excluir(idExcluir)) {
                        System.out.println("Produto excluído com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                // Sair
                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();

        } while (op != 0);

        leitor.close();
    }
}
