// Fazer tratamento de erro para quando a variável recebe int e é String.

package poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal
{
    public static void main(String[] args)
    {
        CentroDeControle centroDeControle  = new CentroDeControle();

        ArrayList<Foguete> listaNomes;
        double consumo, tanque, combustivel;
        int direcao, opcao = -1, quantidade;
        String nome;
        Foguete foguete;
        Scanner teclado = new Scanner(System.in);

        while (opcao != 9)
        {
            System.out.println("\nDigite a opção desejada: ");
            System.out.println("(0) Criação da base de lançamento.");
            System.out.println("(1) Mudança de direção do foguete.");
            System.out.println("(2) Mostrar telemetria do foguete.");
            opcao = teclado.nextInt();

            if (opcao == 0)
            {
                BaseDeLancamento baseDeLancamento;

                System.out.println("\nDigite a quantidade de foguetes desejada: ");
                quantidade = teclado.nextInt();

                baseDeLancamento = new BaseDeLancamento(quantidade);
                listaNomes = new ArrayList <>();

                for (int i = 0; i < quantidade; i++)
                {
                    System.out.println("\nDigite o nome do foguete " + i + ":");
                    nome = teclado.next();
                    System.out.println("Digite o consumo do foguete " + i + ":");
                    consumo = teclado.nextDouble();
                    System.out.println("Digite o tamanho do tanque do foguete " + i + ":");
                    tanque = teclado.nextDouble();
                    System.out.println("Digite a quantidade de combustível atual do foguete " + i + ":");
                    combustivel = teclado.nextDouble();

                    foguete = new Foguete(nome, consumo, tanque, combustivel);
                    listaNomes.add(foguete);
                }

                baseDeLancamento.setListaFoguetes(listaNomes);
                centroDeControle.setBaseDeLancamento(baseDeLancamento);
            }

            else if (opcao == 1)
            {
                System.out.println("\nDigite o nome do foguete a ser direcionado: ");
                nome = teclado.next();

                Foguete enderecoFoguete = centroDeControle.buscarFoguete(nome);

                if (enderecoFoguete != null)
                {
                    System.out.println("\nDigite a opção desejada: ");
                    System.out.println("(0) Direção norte.");
                    System.out.println("(1) Direção sul.");
                    System.out.println("(2) Direção leste.");
                    System.out.println("(3) Direção oeste.");
                    direcao = teclado.nextInt();
                    enderecoFoguete.alterarDirecao(direcao);
                }

                else
                    System.out.println("\nFoguete não encontrado!");
            }

            else if (opcao == 2)
            {
                System.out.println("\nDigite o nome do foguete: ");
                nome = teclado.next();

                Foguete enderecoFoguete = centroDeControle.buscarFoguete(nome, 0);

                if (enderecoFoguete != null)
                {
                    System.out.println(enderecoFoguete);
                }

                else
                    System.out.println("\nFoguete não encontrado!");
            }
        }
    }
}
