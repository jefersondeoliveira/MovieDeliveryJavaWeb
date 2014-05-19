package br.com.moviedelivery.service;

import br.com.moviedelivery.entidade.Categoria;
import java.util.List;

public interface ICategoria {
    
    public List<Categoria> listar();
    
    public String salvar(Categoria categoria);
    
    public String remover(Integer id);
    
}
