package poo;

public class Foguete
{
    private String nome;
    private double consumo, altitude, tanque, quantidadeCombustivelAtual, combustivelAtualizado, litros, gasto, velocidade;
    private int propulsor[];

    public Foguete (String nome2, double consumo2, double tanque2, double combustivel, double velocidade2)
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
        velocidade = velocidade2;
    }

    public String getNome()
    {
        return nome;
    }

    public double getTanque()
    {
        return tanque;
    }

    public double getConsumo()
    {
        return consumo;
    }

    public double combustivelAtual()
    {
        return quantidadeCombustivelAtual;
    }

    public double atualizarCombustivelAtual()
    {
            gasto = 2.5 * consumo * 5;
            litros = combustivelAtual();
            combustivelAtualizado = litros - gasto;

            if (combustivelAtualizado > 0)
            {
                quantidadeCombustivelAtual = combustivelAtualizado;
                return combustivelAtualizado;
            }

            else
            {
                combustivelAtualizado = quantidadeCombustivelAtual ;
                return combustivelAtualizado;
            }
    }

    public void propulsores (int potencia[])
    {
        for (int i = 0; i < potencia.length; i++)
        {
            propulsor[i] = potencia[i];
        }
    }

    public void lancarFoguete ()
    {
        propulsores(new int [] {100,100,100,100});
        quantidadeCombustivelAtual -= (4 * 60 * consumo);
        altitude += velocidade * 60;
    }

    public boolean alterarDirecao (int sentido)
    {

        if (sentido == 0) // Sentido Norte.
        {
            if (atualizarCombustivelAtual() > gasto)
            {
                propulsores(new int [] {50,100,50,50});
                altitude += velocidade * 5;
                return true;
            }
        }

        else if (sentido == 1) // Sentido Sul.
        {
            if (atualizarCombustivelAtual() > gasto)
            {
                propulsores(new int [] {100,50,50,50});
                altitude += velocidade * 5;
                return true;
            }
        }

        else if (sentido == 2) // Sentido Leste.
        {
            if (atualizarCombustivelAtual() > gasto)
            {
                propulsores(new int [] {50,50,50,100});
                altitude += velocidade * 5;
                return true;
            }
        }

        else if (sentido == 3) // Sentido Oeste.
        {
            if (atualizarCombustivelAtual() > gasto)
            {
                propulsores(new int [] {50,50,100,50});
                altitude += velocidade * 5;
                return true;
            }
        }

        return false;
    }

    public double getAltitude()
    {
        return altitude;
    }
    @Override
    public String toString()
    {
            return "\n|Nome: " + nome + "\n|Consumo: " + consumo + "\n|Tamanho do tanque: " + tanque +
                    "\n|Quantidade de combustível atual: " + quantidadeCombustivelAtual + "\n|Altitude: " + altitude +
                    "\n|Propulsor[0]: " + propulsor[0] + "\n|Propulsor[1]: " + propulsor[1] + "\n|Propulsor[2]: " + propulsor[2]
                    + "\n|Propulsor[3]: " + propulsor[3];
    }
}
