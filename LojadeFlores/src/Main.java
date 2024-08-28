import models.Flor;
import enums.TipoFlor;
import repository.FlorRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlorRepository florRepository = new FlorRepository();
        Scanner scanner = new Scanner(System.in);
        int op;

        do {
            System.out.println("Menu" +
                    "\n0- Sair" +
                    "\n1- Cadastrar" +
                    "\n2- Listar" +
                    "\n3- Consultar por codigo" +
                    "\nDigite a operação desejada: ");
            op = leitor.nextInt();
        }
    }
}