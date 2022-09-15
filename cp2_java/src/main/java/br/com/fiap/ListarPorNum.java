package br.com.fiap;

import java.util.Comparator;

public class ListarPorNum implements Comparator<Usuario>{

    @Override
    public int compare(Usuario o1, Usuario o2) {
        return Double.compare(o1.getSaldo(), o2.getSaldo());    
    }
    
}
