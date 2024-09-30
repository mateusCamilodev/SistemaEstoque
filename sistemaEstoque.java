package sistemaEstoque;

import java.util.Scanner;

public class sistemaEstoque {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo(a) ao sistema de estoque e compras!");

        int tentativasRestantes = 3;
        double saldo = 0.0;
        int contDeCompra = 0;
        String[] inventario = new String[10];

        // Cadastro do usuário
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.println("Dados cadastrados com sucesso!");

        // Autenticação
        while (true) {
            System.out.print("Login: ");
            String login2 = sc.nextLine();
            System.out.print("Senha: ");
            String senha2 = sc.nextLine();

            if (login2.equals(login) && senha2.equals(senha)) {
                System.out.println("Acesso liberado!");
                break;
            }

            if (--tentativasRestantes == 0) {
                System.out.println("Acesso bloqueado por segurança!");
                return;
            }

            System.out.println("Login ou senha inválidos. Tentativas restantes: " + tentativasRestantes);
        }

        // Menu de opções
        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1) COMPRAS");
            System.out.println("2) VENDER");
            System.out.println("3) ORGANIZAR LOJA");
            System.out.println("4) ACESSAR ESTOQUE");
            System.out.println("5) SAIR");

            int decisao = sc.nextInt();

            if (decisao == 5) {
                System.out.println("Saindo...");
                break;
            }

            String[] produtos = {"unidut", "condulete", "curva", "tampao", "trilho"};
            double[] precos = {3.49, 12.59, 4.29, 1.29, 8.29};

            // Opção de compras
            if (decisao == 1) {
                System.out.printf("Saldo: %.2f\n", saldo);
                for (int i = 0; i < produtos.length; i++) {
                    System.out.printf("%d) %s - R$: %.2f\n", i + 1, produtos[i], precos[i]);
                }

                System.out.print("Escolha um produto para comprar: ");
                int decisaoProduto = sc.nextInt();

                if (decisaoProduto < 1 || decisaoProduto > produtos.length) {
                    System.out.println("Opção inválida!");
                    continue;
                }

                double precoProduto = precos[decisaoProduto - 1];
                if (saldo >= precoProduto) {
                    saldo -= precoProduto;
                    System.out.printf("Você comprou um %s! Saldo restante: %.2f\n", produtos[decisaoProduto - 1], saldo);
                    contDeCompra++;

                    //Loop para verificar se algum índice é nulo, para incrementar no inventário
                    for (int i = 0; i < inventario.length; i++) {
                        if (inventario[i] == null) {
                            inventario[i] = produtos[decisaoProduto - 1];
                            break;
                        }

                    }

                } else {
                    System.out.println("Saldo insuficiente!");
                }
            }

            // Opção de venda
            if (decisao == 2) {
                if (contDeCompra > 0) {
                    System.out.println("Você comprou " + contDeCompra + " item(s).");
                } else {
                    System.out.println("Você não tem itens comprados para vender.");
                }
            }

            // Opção de organizar a loja
            if (decisao == 3) {
                System.out.println("Loja organizada! Você recebeu R$ 23,78.");
                saldo += 23.78;
                System.out.printf("Saldo atualizado: %.2f\n", saldo);
            }

            // Acesso ao estoque
            if (decisao == 4) {
                System.out.println("Itens no inventário:");

                for(int i = 0; i< inventario.length; i++){
                    System.out.println(inventario[i]);
                }
            }


        }
        sc.close();
    }
}
