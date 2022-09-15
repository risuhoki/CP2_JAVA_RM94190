package br.com.fiap;

import java.util.Comparator;

public class ListarPorTitular implements Comparator<Usuario>{

    @Override
    public int compare(Usuario o1, Usuario o2) {
        return o1.getTitular().compareTo(o2.getTitular());
    }
    
}
