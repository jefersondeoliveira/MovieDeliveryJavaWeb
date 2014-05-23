package br.com.moviedelivery.controller;

import br.com.moviedelivery.entidade.TipoMidia;
import br.com.moviedelivery.model.GraficoTipoDeMidia;
import br.com.moviedelivery.service.ITipoMidiaService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@Named("tipoMidiaManagedBean")
@RequestScoped
public class TipoMidiaManagedBean {
    
    private TipoMidia tipoMidia;
    private TipoMidia tipoMidiaSelecionado;
    
    @EJB
    private ITipoMidiaService tipoMidiaService;
    
    public List<TipoMidia> listar(){
        return tipoMidiaService.listar();
    }
    
    public TipoMidiaManagedBean(){
        tipoMidia = new TipoMidia();
    }
    
    public void salvar() {
        String erro = tipoMidiaService.salvar(tipoMidia);
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Tipo de midia salvo com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        tipoMidia = new TipoMidia();
    }
    
    public void excluir(){
        String erro = tipoMidiaService.remover(tipoMidiaSelecionado.getIdTipoMidia());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Tipo de midia excluido com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
    
    public CartesianChartModel  gerarGrafico(){
        CartesianChartModel model = new CartesianChartModel();
        
        List<GraficoTipoDeMidia> graficoModels = tipoMidiaService.gerarGrafico();
        
        for (GraficoTipoDeMidia graficoModel : graficoModels) {
            ChartSeries cor = new ChartSeries(); 
            cor.setLabel(graficoModel.getCategoria());
            cor.set(graficoModel.getTipoMidia(), graficoModel.getQuantidade());
            model.addSeries(cor);
        }
        
        return model;
    }
    
    public void editar(){
        tipoMidia = tipoMidiaSelecionado;
    }

    public TipoMidia getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(TipoMidia tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public TipoMidia getTipoMidiaSelecionado() {
        return tipoMidiaSelecionado;
    }

    public void setTipoMidiaSelecionado(TipoMidia tipoMidiaSelecionado) {
        this.tipoMidiaSelecionado = tipoMidiaSelecionado;
    }

    
}
