package sistemaEstoque;

import java.util.Scanner;

public class sistemaEstoque {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário

        System.out.println("Bem vindo(a) ao sistema do estoque e compras!!!"); // Mensagem de boas-vindas
        System.out.println("Faça seu cadastro..."); // Solicita cadastro do usuário

        int tentativasRestantes = 3; // Define o número de tentativas de login
        double saldo = 0.0; // Inicializa o saldo do usuário
        int soma =0;
        int contDeCompra = 0; // Contador de compras realizadas
        String inventario[] = new String[10];

        // Solicita o login e a senha
        System.out.print("Login : ");
        String login = sc.nextLine(); // Lê o login

        System.out.print("Senha : ");
        String senha = sc.nextLine(); // Lê a senha

        System.out.println("Seus dados foram cadastrados"); // Confirma cadastro
        System.out.println("Coloque o login e senha que você informou..."); // Solicita login e senha
        System.out.println("-----------------------");

        // Novamente solicita o login e a senha para autenticação
        System.out.print("Login : ");
        String login2 = sc.nextLine(); // Lê o login para validação

        System.out.print("Senha : ");
        String senha2 = sc.nextLine(); // Lê a senha para validação

        // Loop para validar login e senha
        while (!login2.equals(login) || !senha2.equals(senha)) {
            System.out.println("Login ou senha estão inválidos..."); // Mensagem de erro
            System.out.println("-----------------------");

            // Verifica tentativas restantes
            if (tentativasRestantes > 0) {
                System.out.println("Tente novamente... tentativas restantes " + tentativasRestantes);
                tentativasRestantes--; // Decrementa tentativas restantes

            }

            else {
                System.out.println("Acesso bloqueado por segurança!!!"); // Bloqueia acesso se tentativas esgotadas
                break; // Sai do loop
            }

            // Solicita novo login e senha
            System.out.print("Login : ");
            login2 = sc.nextLine(); // Lê novo login

            System.out.print("Senha : ");
            senha2 = sc.nextLine(); // Lê nova senha
        }

        // Mensagem de acesso liberado
        System.out.println("Acesso liberado!!!");
        System.out.println("-----------------------");

        // Menu de opções para o usuário
        System.out.println("Deseja acessar qual aba???");

        while (true) { // Loop para opções de menu
            // Opções disponíveis
            System.out.println("1) COMPRAS");
            System.out.println("2) VENDER");
            System.out.println("3) ORGANIZAR LOJA");
            System.out.println("4) ACESSAR ESTOQUE");
            System.out.println("5) SAIR");

            int decisao = sc.nextInt(); // Lê a opção escolhida

            // Se a opção for sair, termina o programa
            if (decisao == 5) {
                System.out.println("Saindo...");
                break; // Sai do loop
            }

            // Arrays dos produtos
            String produtos[] = new String[5]; // Cria um array de produtos
            produtos[0] = "unidut"; // Adiciona produtos ao array
            produtos[1] = "condulete";
            produtos[2] = "curva";
            produtos[3] = "tampao";
            produtos[4] = "trilho";

            double precos[] = new double[5]; // Cria um array de preços
            precos[0] = 3.49; // Adiciona preços ao array
            precos[1] = 12.59;
            precos[2] = 4.29;
            precos[3] = 1.29;
            precos[4] = 8.29;

            // Se a opção escolhida for compras
            if (decisao == 1) {
                for(int i = 0; i<10; i++){
                    System.out.println("Carregando..." + i*10 + "%");
                }
                System.out.println("-----------------------");
                System.out.println("Saldo: " + "R$" + saldo); // Exibe saldo atual
                System.out.println("Qual item deseja comprar?");// Solicita escolha de produto

                for (int i = 0; i < 5; i++) { // Loop para mostrar produtos disponíveis
                    System.out.println((i + 1) + ") " + produtos[i] + " " + "R$: " + precos[i]); // Mostra produto e preço
                }

                System.out.print("Escolha qual produto deseja comprar :");
                int decisaoProduto = sc.nextInt();// Lê a escolha do produto

                // Valida a escolha do produto
                if (decisaoProduto < 1 || decisaoProduto > 5) {
                    System.out.println("Opção inválida!"); // Mensagem de erro se a opção for inválida

                }

                double precoProduto = precos[decisaoProduto - 1]; // Obtém o preço do produto escolhido



                // Verifica se há saldo suficiente para a compra
                if (saldo >= precoProduto) {
                    saldo -= precoProduto; // Deduz o preço do saldo
                    System.out.println("Parabéns você comprou um " + produtos[decisaoProduto] + "!!!");
                    System.out.printf("Compra realizada!!! Saldo: %.2f%n" , saldo); // Confirma compra
                    contDeCompra++;
                    // Incrementa contador de compras

                    inventario[0] = produtos[decisaoProduto];

                }

                else {
                    System.out.println("Saldo insuficiente..."); // Mensagem de erro se o saldo for insuficiente

                }

            }

            // Lógica para venda, caso compras tenham sido realizadas
            if (decisao == 2 && contDeCompra > 0) {
                // Implementar lógica de venda aqui
                for(int i = 0; i<10; i++){
                    System.out.println("Carregando..." + i*10 + "%");
                }
                System.out.println("-----------------------");
                System.out.println("Itens comprados : " + contDeCompra);
            }

            //lógica para venda, caso nenhuma compras tenham sido realizadas
            else if (decisao == 2 && contDeCompra == 0){

                for(int i = 0; i<10; i++){
                    System.out.println("Carregando..." + i*10 + "%");
                }
                System.out.println("-----------------------");
                System.out.println("Itens comprados : "+ contDeCompra);
                System.out.println("Você não consegue vender pois não tem nada comprado...");
            }

            //Se a opção escolhida for organizar a loja
            if(decisao == 3){
                System.out.println("Organizando loja...");

                for(int i = 0; i<10; i++){
                    System.out.println("Carrendo... " + i*10 + "%");
                }

                System.out.println("Você organizou a loja...");
                System.out.println("-----------------------");
                System.out.println("Você recebeu 23,78 de Saldo");
                saldo = saldo + 23.78;
                System.out.println("Saldo : " + saldo);
            }

            if (decisao == 4){
                System.out.println("Acessando o estoque...");

                for(int i = 0; i<10; i++){
                    System.out.println("Carrendo... " + i*10 + "%");
                }

                System.out.println("Seus itens : " + inventario[0]);

            }
        }
        sc.close();

    }
}

























