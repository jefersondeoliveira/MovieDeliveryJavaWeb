package br.com.moviedelivery.service;

import br.com.moviedelivery.entidade.Administrador;
import java.util.List;

public interface IAdministrador {
    
    public List<Administrador> listar();
    
    public String salvar(Administrador administrador);
    
    public String remover(Integer id);
}
