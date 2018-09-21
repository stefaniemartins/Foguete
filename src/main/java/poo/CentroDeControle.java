package poo;

import java.util.ArrayList;

public class CentroDeControle
{
    Foguete foguete;

    private BaseDeLancamento baseDeLancamento;

    public void setBaseDeLancamento(BaseDeLancamento baseDeLancamento)
    {
        this.baseDeLancamento = baseDeLancamento;
    }

    public BaseDeLancamento getBaseDeLancamento()
    {
        return baseDeLancamento;
    }

    public Foguete buscarFoguete (String nomeFoguete, int opcao)
    {
        ArrayList<Foguete> listaFoguetes;
        listaFoguetes = baseDeLancamento.getListaFoguetes();

        for (Foguete enderecoFoguete: listaFoguetes)
        {
            if ((nomeFoguete.compareTo(enderecoFoguete.getNome())) == 0)
            {
                if (opcao == 1)
                {
                    if (foguete.combustivelAtual(1) > 0)
                        return enderecoFoguete;

                    else
                        return null;
                }

                else
                    return enderecoFoguete;
            }
        }

        return null;
    }
}
