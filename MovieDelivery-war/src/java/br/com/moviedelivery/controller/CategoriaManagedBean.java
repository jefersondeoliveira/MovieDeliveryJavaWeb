package br.com.moviedelivery.controller;

import br.com.moviedelivery.entidade.Categoria;
import br.com.moviedelivery.model.GraficoCategoria;
import br.com.moviedelivery.service.ICategoriaService;
import br.com.moviedelivery.util.RelatorioFactory;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

@Named("categoriaManagedBean")
@RequestScoped
public class CategoriaManagedBean {
    
    private Categoria categoria;
    private Categoria categoriaSelecionada;
    
    @EJB
    private ICategoriaService categoriaService;
    
    public List<Categoria> listar(){
        return categoriaService.listar();
    }
    
    public CategoriaManagedBean(){
        categoria = new Categoria();
    }
    
    public String goToListaPorCategoria(){
        return "categorias.xhtml";
    }
    
    public void salvar() {
        String erro = categoriaService.salvar(categoria);
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Categoria salva com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        categoria = new Categoria();
    }
    
    public void excluir(){
        String erro = categoriaService.remover(categoriaSelecionada.getIdCategoria());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Categoria excluida com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
    
    public PieChartModel gerarGrafico(){
        PieChartModel model = new PieChartModel();
        List<GraficoCategoria> graficoModels = categoriaService.gerarGrafico();
        for (GraficoCategoria graficoModel : graficoModels) {
            model.set(graficoModel.getCategoria(), graficoModel.getQuantidade());
        }
        return model;
    }
    
    public void imprimir(){
        RelatorioFactory.Relatorios("/WEB-INFO/relatorios/reportCategoria.jasper");
    }
    
    public void editar(){
        categoria = categoriaSelecionada;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
    }

    
    
}
