package br.com.moviedelivery.serviceimp;

import br.com.moviedelivery.entidade.TipoMidia;
import br.com.moviedelivery.service.ITipoMidia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class TipoMidiaService implements ITipoMidia{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<TipoMidia> listar() {
        TypedQuery<TipoMidia> query =
                em.createQuery("select a from Categoria as a",
                TipoMidia.class);
        return query.getResultList();
    }

    @Override
    public String salvar(TipoMidia tipoMidia) {
        try {
            
            em.merge(tipoMidia);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer id) {
        try {
            
           em.remove(em.find(TipoMidia.class, id));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
}
