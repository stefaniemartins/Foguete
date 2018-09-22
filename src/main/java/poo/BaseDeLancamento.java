package poo;

import java.util.ArrayList;

public class BaseDeLancamento
{
    private ArrayList<Foguete> listaFoguetes;

    public void setListaFoguetes(ArrayList <Foguete> listaFoguetes)
    {

        this.listaFoguetes = listaFoguetes;
    }

    public String buscarFoguete (String nomeFoguete)
    {
        for (Foguete enderecoFoguete: listaFoguetes)
        {
            if (enderecoFoguete.getNome().equals(nomeFoguete))
            {
                return enderecoFoguete.toString();
            }
        }

        return "Erro.";
    }

    public int lancarFoguete (String nomeFoguete)
    {
        double consumo, gasto = 0;

        for (Foguete enderecoFoguete : listaFoguetes)
        {
            if (enderecoFoguete.getNome().equals(nomeFoguete))
            {
                consumo = enderecoFoguete.getConsumo();
                gasto = (4 * 60 * consumo);

                if (enderecoFoguete.combustivelAtual() >= gasto)
                {
                    enderecoFoguete.lancarFoguete();
                     return 0;
                }

                return 1;
            }
        }

        return 2;
    }

    public boolean mudarDirecao (String nomeFoguete, int direcao)
    {
        for (Foguete enderecoFoguete: listaFoguetes)
        {
            if (enderecoFoguete.getNome().equals(nomeFoguete))
            {
                return (enderecoFoguete.alterarDirecao(direcao));
            }
        }

        return false;
    }

    public void alterarValores (String nomeFoguete)
    {
        for (Foguete enderecoFoguete: listaFoguetes)
        {
            if (enderecoFoguete.getNome().equals(nomeFoguete))
            {
                enderecoFoguete.propulsores(new int [] {50,50,50,50});
            }
        }
    }

    @Override
    public String toString()
    {
        return "\nLista de foguetes: \n" + listaFoguetes;
    }
}
