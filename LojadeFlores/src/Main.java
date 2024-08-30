import repository.FlorRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlorRepository florRepository = new FlorRepository();
        Scanner leitor = new Scanner(System.in);
        int op;

        do {
            System.out.println("Menu" +
                    "\n0- Sair" +
                    "\n1- Cadastrar" +
                    "\n2- Listar" +
                    "\n3- Consultar por codigo" +
                    "\nDigite a operação desejada: ");
            op = leitor.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o código da flor:");
                    int codigo = leitor.nextInt();
                    leitor.nextLine();  // Consumir nova linha
                    System.out.println("Digite o nome da flor:");
                    String nome = leitor.nextLine();
                    System.out.println("Digite o tipo da flor (ROSA, TULIPA, MARGARIDA, ORQUIDEA):");
                    TipoFlor tipo = TipoFlor.valueOf(leitor.nextLine().toUpperCase());
                    System.out.println("Digite o preço da flor:");
                    double preco = leitor.nextDouble();

                    Flor flor = new Flor(codigo, nome, tipo, preco);
                    florRepository.cadastrar(flor);
                    System.out.println("Flor cadastrada com sucesso!");
                    break;
                case 2:
                    List<Flor> flores = florRepository.listar();
                    for (Flor f : flores) {
                        System.out.println(f);
                    }
                    break;
                case 3:
                    System.out.println("Digite o código da flor:");
                    int codigoConsulta = leitor.nextInt();
                    Flor florConsultada = florRepository.consultarPorCodigo(codigoConsulta);
                    if (florConsultada != null) {
                        System.out.println(florConsultada);
                    } else {
                        System.out.println("Flor não encontrada!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);

        leitor.close();
    }
}
