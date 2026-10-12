import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o limite do cartão: ");
        double limite = sc.nextDouble();
        double saldo = limite;

        List<Compra> compras = new ArrayList<>();

        int opcao = 1;
        while (opcao != 0) {
            System.out.print("Digite a descrição da compra: ");
            String descricao = sc.next();

            System.out.print("Digite o valor da compra: ");
            double valor = sc.nextDouble();

            Compra compra = new Compra(descricao, valor);

            if (valor <= saldo) {
                saldo -= valor;
                compras.add(compra);
                System.out.println("Compra realizada!");

                System.out.println("Digite 0 para sair ou 1 para continuar");
                opcao = sc.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                opcao = 0;
            }
        }

        Collections.sort(compras);

        System.out.println("\n***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        for (Compra item : compras) {
            System.out.println(item);
        }

        System.out.println("\nSaldo do cartão: " + saldo);
        System.out.println("***********************");

        sc.close();
    }
}