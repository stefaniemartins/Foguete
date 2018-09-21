package poo;

public class CentroDeControle
{
    private BaseDeLancamento baseDeLancamento;

    public void setBaseDeLancamento(BaseDeLancamento baseDeLancamento)
    {
        this.baseDeLancamento = baseDeLancamento;
    }

    public BaseDeLancamento getBaseDeLancamento()
    {
        return baseDeLancamento;
    }

    public String buscarFogueteNaBase (String nomeFoguete)
    {
        if (baseDeLancamento.buscarFoguete(nomeFoguete).equals("Erro."))
        {
            return "Erro.";
        }

        else
        {
            return baseDeLancamento.buscarFoguete(nomeFoguete);
        }

    }

    public boolean mudarDirecaoNaBase(String nomeFoguete, int direcao)
    {
        return (baseDeLancamento.mudarDirecao(nomeFoguete, direcao));
    }

    public int acionarLancamento (String nomeFoguete)
    {
        return baseDeLancamento.lancarFoguete(nomeFoguete);
    }
}
