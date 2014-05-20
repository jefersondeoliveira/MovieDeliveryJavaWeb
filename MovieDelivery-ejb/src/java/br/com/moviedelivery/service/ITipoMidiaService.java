package br.com.moviedelivery.service;

import br.com.moviedelivery.entidade.TipoMidia;
import java.util.List;

public interface ITipoMidiaService {
    
    public List<TipoMidia> listar();
    
    public String salvar(TipoMidia tipoMidia);
    
    public String remover(Integer id);
    
}