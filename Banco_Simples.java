
import java.util.Scanner;

public class Banco_Simples {

    static double saldo = 0;
    static int escolhaVoltar=0;

    public static void main(String[]args){

        Scanner leia = new Scanner(System.in);
        String confirmacao;


        do {


            System.out.println("------------------------");
            System.out.println("Realize seu login");
            System.out.println("------------------------");
            System.out.println("Digite o seu usuaŕio:");
            String usario = leia.next();
            System.out.println("------------------------");
            System.out.println("Digite sua senha:");
            String senha = leia.next();
            System.out.println("------------------------");

            confirmacao = login(usario, senha, leia);

            if (confirmacao == "correto") {
                menu(leia);
            }
            else{
                System.out.println("Incorreto, tente novamente...");
            }
        }while(confirmacao != "correto");

        leia.close();

    }
    public static String login(String usuario,String senha,Scanner leia){

        String resposta;

        if (usuario.equals("c") && senha.equals("1")){
            resposta = "correto";
        }
        else{
            resposta = "incorreto";
        }

        return resposta;


    }
    public static void voltar(Scanner leia){


        System.out.println("------------------------------------------");
        System.out.println("      Deseja realizar continuar?          ");
        System.out.println("------------------------------------------");
        System.out.println("[1] Não, voltar ao menu                   ");
        System.out.println("[2] Sim, desejo realizar a mesma operação ");
        System.out.println("[3] Gostaria de sair                      ");
        System.out.println("------------------------------------------");
        System.out.print("Digite a opção que deseja:");
        escolhaVoltar = leia.nextInt();

        if (escolhaVoltar == 3){
            System.out.println("Encerrado");
            System.out.println("Obrigado pela preferência");
            System.exit(0);
        }

    }
    public static void menu(Scanner leia){

        int escolha;


        do {
            System.out.println("------------------------");
            System.out.println("      BEM-VINDO !!      ");
            System.out.println("------------------------");
            System.out.println("[1] DEPOSITO            ");
            System.out.println("[2] RETIRADA            ");
            System.out.println("[3] CONSULTA DE SALDO   ");
            System.out.println("[4] PAGAMENTO VIA PIX   ");
            System.out.println("[5] SAIR DO PROGRAMA    ");
            System.out.println("-----------------------------------");
            System.out.print("Digite qual operação deseja realizar:");
            escolha = leia.nextInt();
            System.out.println("-----------------------------------");

            switch (escolha) {

                case 1:
                    deposito(leia);
                    break;

                case 2:
                    retirada(leia);
                    break;
                case 3:
                    consultaSaldo(leia);
                    break;
                case 4:
                    pix(leia);
                    break;
                case 5:
                    System.out.println("Encerrado");
                    System.out.println("Obrigado pela preferência");
                    break;
                default:
                    System.out.println("Inválido, tente de novo");
                    break;

            }

        } while (escolha != 5);

    }
    public static void deposito(Scanner leia){

        double deposito;


        do {
            System.out.println("------------------------------");
            System.out.println("           DEPOSITO           ");
            System.out.println("------------------------------");
            System.out.print("Digite o valor do deposito: R$");
            deposito = leia.nextDouble();
            System.out.println("------------------------------");

            if (deposito < 0){
                System.out.println("--------------");
                System.out.println("Valor inválido");
                System.out.println("--------------");
                voltar(leia);
            }
            else{
                saldo+=deposito;
                System.out.println("--------------------------------");
                System.out.println("Deposito realizado com sucesso!!");
                System.out.println("--------------------------------");
                System.out.println("Valor do deposito: R$"+deposito);
                System.out.println("Saldo atual: R$"+saldo);
                voltar(leia);
            }

        }while(escolhaVoltar ==2);



    }
    public static void retirada(Scanner leia){

        double retirada;

        do {

            System.out.println("------------------------------");
            System.out.println("           RETIRADA           ");
            System.out.println("------------------------------");
            System.out.print("Digite o valor do retirada: R$");
            retirada = leia.nextDouble();
            System.out.println("------------------------------");

            if (retirada < 0 || retirada > saldo){
                System.out.println("---------------------");
                System.out.println("Valor inválido/Insuficiente");
                System.out.println("Saldo atual: R$"+saldo);
                System.out.println("---------------------");
                voltar(leia);
            }
            else{
                saldo-=retirada;
                System.out.println("--------------------------------");
                System.out.println("Retirada realizado com sucesso!!");
                System.out.println("--------------------------------");
                System.out.println("Valor do retirada: R$"+retirada);
                System.out.println("Saldo atual: R$"+saldo);
                voltar(leia);
            }

        }while(escolhaVoltar ==2);



    }

    public static void consultaSaldo(Scanner leia){

        System.out.println("----------------------------");
        System.out.println("Seu saldo atual: R$"+saldo);
        System.out.println("----------------------------");
        System.out.println("Digite qualquer coisa e aperte ENTER");
        leia.next();



    }
    public static void pix(Scanner leia){

        int escolhaPix=0;
        String cpf;
        String telefone;
        String email;

        System.out.println("------------------------");
        System.out.println("         PIX            ");
        System.out.println("------------------------");
        System.out.println("Escolha a forma de envio");
        System.out.println("------------------------");
        System.out.println("[1] CPF                 ");
        System.out.println("[2] TELEFONE            ");
        System.out.println("[3] EMAIL               ");
        System.out.println("[4] VOLTAR              ");
        System.out.println("---------------------------");
        System.out.print("Digite qual a opção desejada:");
        escolhaPix = leia.nextInt();
        System.out.println("---------------------------");

        switch (escolhaPix){

            case 1:
                do {
                    System.out.println("---------------------------");
                    System.out.print("Digite o CPF:");
                    cpf = leia.next();
                    System.out.println("---------------------------");


                    if (cpf.length() == 11) {
                        operacaoPix(leia);
                    } else {
                        System.out.println("Inválido");
                        voltar(leia);
                    }
                }while(escolhaVoltar == 2);
                break;

            case 2:
                do {

                    System.out.println("---------------------------");
                    System.out.print("Digite seu telefone:");
                    telefone = leia.next();
                    System.out.println("---------------------------");

                    if (telefone.length() == 11) {
                        operacaoPix(leia);
                    } else {
                        System.out.println("Inválido");
                        voltar(leia);
                    }
                }while(escolhaVoltar == 2);
                break;

            case 3:
                do {
                    System.out.println("---------------------------");
                    System.out.print("Digite seu email:");
                    email = leia.next();
                    System.out.println("---------------------------");

                    if (email.contains("@gmail.com") || email.contains("@hotmail.com")) {
                        operacaoPix(leia);
                    } else {
                        System.out.println("Inválido");
                        voltar(leia);
                    }
                }while(escolhaVoltar == 2);
                break;

            case 4:

                break;

        }


    }
    public static void operacaoPix(Scanner leia) {

        double pix;
        do {
            System.out.println("----------------------");
            System.out.print("Digite o valor do PIX: R$");
            pix = leia.nextDouble();
            System.out.println("----------------------");

            if (pix < 0 || pix > saldo) {
                System.out.println("---------------------");
                System.out.println("Valor inválido/Insuficiente");
                System.out.println("Saldo atual: R$" + saldo);
                System.out.println("---------------------");
                voltar(leia);
            } else {
                saldo -= pix;
                System.out.println("--------------------------------");
                System.out.println("Pix realizado com sucesso!!");
                System.out.println("--------------------------------");
                System.out.println("Valor do pix: R$" + pix);
                System.out.println("Saldo atual: R$" + saldo);
                voltar(leia);
            }
        }while(escolhaVoltar ==2);
    }

}

