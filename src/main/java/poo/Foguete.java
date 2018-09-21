package poo;

public class Foguete
{
    private String nome;
    private double consumo, altitude, tanque, quantidadeCombustivelAtual, litros;
    private int propulsor[];

    public Foguete (String nome2, double consumo2, double tanque2, double combustivel)
    {
        propulsor = new int[4];
        propulsor[0] = 0; // Norte.
        propulsor[1] = 0; // Sul.
        propulsor[2] = 0; // Leste.
        propulsor[3] = 0; // Oeste.
        altitude = 0;
        nome = nome2;
        consumo = consumo2;
        tanque = tanque2;
        quantidadeCombustivelAtual = combustivel;
        litros = getTanque();
    }

    public String getNome()
    {
        return nome;
    }

    public double getTanque()
    {
        return tanque;
    }

    public void setTanque(double tanque)
    {
        tanque = quantidadeCombustivelAtual;
    }

    public double combustivelAtual(int opcao)
    {
        if (opcao == 0)
        {
            double gasto = 2.5 * consumo;
            quantidadeCombustivelAtual = litros - (5 * gasto);
            litros = quantidadeCombustivelAtual;

            if (litros > 0)
                return quantidadeCombustivelAtual;

            else
                return -1;
        }

        else
        {
            if (litros > 0)
                return quantidadeCombustivelAtual;

            else
                return -1;
        }
    }

    public void propulsores (int potencia[])
    {
        for (int i = 0; i < potencia.length; i++)
        {
            propulsor[i] = potencia[i];
        }
    }

    public boolean alterarDirecao (int sentido)
    {

        if (sentido == 0) // Sentido Norte.
        {


            combustivelAtual(0);

            propulsores(new int [] {50,100,50,50});

            return true;
        }

        else if (sentido == 1) // Sentido Sul.
        {
            combustivelAtual(0);

            propulsores(new int [] {100,50,50,50});

            return true;
        }

        else if (sentido == 2) // Sentido Leste.
        {
            combustivelAtual(0);

            propulsores(new int [] {50,50,50,100});

            return true;
        }

        else if (sentido == 3) // Sentido Oeste.
        {
            combustivelAtual(0);

            propulsores(new int [] {50,50,100,50});

            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        if (combustivelAtual(1) == -1)
        {
            return "Tanque com combustível insuficiente.";
        }

        else
        {
            return "\nNome: " + nome + "\nConsumo: " + consumo + "\nTamanho do tanque: " + tanque +
                    "\nQuantidade de combustível atual: " + quantidadeCombustivelAtual + "\nAltitude: " + altitude +
                    "\nPropulsor[0]: " + propulsor[0] + "\nPropulsor[1]: " + propulsor[1] + "\nPropulsor[2]: " + propulsor[2]
                    + "\nPropulsor[3]: " + propulsor[3];
        }

    }
}
