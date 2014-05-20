package br.com.moviedelivery.service;

import br.com.moviedelivery.entidade.Midia;
import java.util.List;

public interface IMidiaService {
    
    public List<Midia> listar();
    
    public String salvar(Midia midia);
    
    public String remover(Integer id);
    
}
