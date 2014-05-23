package br.com.moviedelivery.serviceimp;

import br.com.moviedelivery.entidade.TipoMidia;
import br.com.moviedelivery.model.GraficoTipoDeMidia;
import br.com.moviedelivery.service.ITipoMidiaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class TipoMidiaService implements ITipoMidiaService{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<TipoMidia> listar() {
        TypedQuery<TipoMidia> query =
                em.createQuery("select t from TipoMidia as t",
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
    public String remover(Short id) {
        try {
            
           em.remove(em.find(TipoMidia.class, id));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public List<GraficoTipoDeMidia> gerarGrafico() {
        TypedQuery<GraficoTipoDeMidia> query 
                = em.createQuery("select new br.com.moviedelivery.model.GraficoTipoDeMidia"
                + "(m.categoria.descricao ,m.descricao, SIZE(m.midias)) from TipoMidia as m ", 
                GraficoTipoDeMidia.class);
        
        return query.getResultList();
    }
    
}
