package poo;

import java.util.ArrayList;

public class BaseDeLancamento
{
    private ArrayList<Foguete> listaFoguetes;
    private int quantidadeDeFoguetes;

    public BaseDeLancamento (int quantidadeDeFoguetes2)
    {
        quantidadeDeFoguetes = quantidadeDeFoguetes2;
    }

    public ArrayList <Foguete> getListaFoguetes()
    {
        return listaFoguetes;
    }

    public void setListaFoguetes(ArrayList <Foguete> listaFoguetes)
    {
        this.listaFoguetes = listaFoguetes;
    }

    public int getQuantidadeDeFoguetes()
    {
        return quantidadeDeFoguetes;
    }

    public void setQuantidadeDeFoguetes(int quantidadeDeFoguetes)
    {
        this.quantidadeDeFoguetes = quantidadeDeFoguetes;
    }

    @Override
    public String toString()
    {
        return "Lista de foguetes: \n" + listaFoguetes;
    }
/*public boolean lancar (String nome)
    {

    }*/
}
