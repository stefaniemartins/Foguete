package poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal
{
    public static void main(String[] args)
    {
        CentroDeControle centroDeControle  = new CentroDeControle();

        ArrayList<Foguete> listaNomes;
        double consumo, tanque, combustivel, velocidade2;
        int direcao, opcao = -1, quantidade;
        String nomeFoguete;
        Foguete foguete;
        Scanner teclado = new Scanner(System.in);

        while (opcao != 4)
        {
            System.out.println("\nDigite a opção desejada: ");
            System.out.println("(0) Criação da base de lançamento.");
            System.out.println("(1) Fazer o lançamento do foguete.");
            System.out.println("(2) Mudança de direção do foguete.");
            System.out.println("(3) Mostrar telemetria do foguete.");
            System.out.println("(4) Sair.");
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
                    System.out.println("\nDigite o nome do foguete: " + (i + 1) + ":");
                    nomeFoguete = teclado.next();
                    System.out.println("Digite o consumo do foguete: " + (i + 1) + ":");
                    consumo = teclado.nextDouble();
                    System.out.println("Digite a velocidade do foguete: " + (i + 1) + ":");
                    velocidade2 = teclado.nextDouble();
                    System.out.println("Digite o tamanho do tanque do foguete: " + (i + 1) +":");
                    tanque = teclado.nextDouble();

                    do
                    {
                        System.out.println("Digite a quantidade de combustível do foguete " + (i + 1) + " que seja menor ou igual a " + tanque + ": ");
                        combustivel = teclado.nextDouble();
                    } while (tanque < combustivel);

                    foguete = new Foguete(nomeFoguete, consumo, tanque, combustivel, velocidade2);
                    listaNomes.add(foguete);
                }

                baseDeLancamento.setListaFoguetes(listaNomes);
                centroDeControle.setBaseDeLancamento(baseDeLancamento);
            }

            else if (opcao == 1)
            {
                System.out.println("\nDigite o nome do foguete a ser lançado: ");
                nomeFoguete = teclado.next();
                int retornoLancar = centroDeControle.acionarLancamento(nomeFoguete);

                if (retornoLancar == 0)
                {
                    System.out.println("\nFoguete lançado com sucesso!");
                    System.out.println("\n" + centroDeControle.buscarFogueteNaBase(nomeFoguete));
                    centroDeControle.getBaseDeLancamento().alterarValores(nomeFoguete);
                }

                else if (retornoLancar == 1)
                {
                    System.out.println("\nFoguete não pode ser lançado. Combustível insuficiente!");
                }

                else if (retornoLancar == 2)
                {
                    System.out.println("\nFoguete não encontrado!");
                }
            }

            else if (opcao == 2)
            {
                System.out.println("\nDigite o nome do foguete a ser direcionado: ");
                nomeFoguete = teclado.next();

                if (centroDeControle.buscarFogueteNaBase(nomeFoguete).equals("Erro."))
                {
                    System.out.println("\nFoguete não encontrado!");
                }

                else
                {
                    System.out.println("\nDigite a opção desejada: ");
                    System.out.println("(0) Direção norte.");
                    System.out.println("(1) Direção sul.");
                    System.out.println("(2) Direção leste.");
                    System.out.println("(3) Direção oeste.");
                    direcao = teclado.nextInt();

                    if (centroDeControle.mudarDirecaoNaBase(nomeFoguete, direcao))
                    {
                        System.out.println("\nAção realizada com sucesso");
                        System.out.println("\n" + centroDeControle.buscarFogueteNaBase(nomeFoguete));
                        centroDeControle.getBaseDeLancamento().alterarValores(nomeFoguete);
                    }

                    else
                    {
                        System.out.println("\nNão foi possível realizar esta ação!\nFoguete com combustível insuficiente para mudar sua direção!");
                    }
                }
            }

            else if (opcao == 3)
            {
                System.out.println("\nDigite o nome do foguete: ");
                nomeFoguete = teclado.next();

                if (centroDeControle.buscarFogueteNaBase(nomeFoguete).equals("Erro."))
                {
                    System.out.println("\nFoguete não encontrado!");
                }

                else
                {
                    System.out.println("\n" + centroDeControle.buscarFogueteNaBase(nomeFoguete));
                }
            }

            else if ((opcao < 0) || (opcao > 4))
            {
                System.out.println("\nOpção selecionada não encontrada. Tente novamente!");
            }
        }
    }
}
