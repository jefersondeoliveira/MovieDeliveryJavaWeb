package br.com.moviedelivery.serviceimp;

import br.com.moviedelivery.entidade.Midia;
import br.com.moviedelivery.model.GraficoMidia;
import br.com.moviedelivery.service.IMidiaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MidiaService implements IMidiaService{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Midia> listar() {
        TypedQuery<Midia> query =
                em.createQuery("select a from Midia as a order by a.tituloMidia",
                Midia.class);
        return query.getResultList();
    }

    @Override
    public String salvar(Midia midia) {
        try {
            
            em.merge(midia);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer id) {
        try {
            
           em.remove(em.find(Midia.class, id));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public List<Midia> listarDestaque() {
        TypedQuery<Midia> query =
                em.createQuery("select a from Midia as a ORDER BY a.idMidia DESC ",
                Midia.class);
        return query.setMaxResults(5).getResultList();
    }

    @Override
    public List<Midia> listarPorCategoria(short id) {
         TypedQuery<Midia> query =
                em.createQuery("select a from Midia as a Where a.categoria.idCategoria = "+id,
                Midia.class);
        return query.getResultList();
    }

    @Override
    public List<GraficoMidia> gerarGrafico() {
        TypedQuery<GraficoMidia> query 
                = em.createQuery("select new br.com.moviedelivery.model.GraficoMidia"
                + "( m.ano, m.categoria.descricao, m.duracao) from Midia as m", 
                GraficoMidia.class);
        
        return query.getResultList();
    }
    
}
