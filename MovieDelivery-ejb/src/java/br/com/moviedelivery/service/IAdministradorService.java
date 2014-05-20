package br.com.moviedelivery.service;

import br.com.moviedelivery.entidade.Administrador;
import java.util.List;

public interface IAdministradorService {
    
    public List<Administrador> listar();
    
    public String salvar(Administrador administrador);
    
    public String remover(Integer id);
}
