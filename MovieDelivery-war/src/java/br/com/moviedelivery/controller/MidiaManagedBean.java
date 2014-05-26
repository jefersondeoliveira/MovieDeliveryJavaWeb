package br.com.moviedelivery.controller;

import br.com.moviedelivery.entidade.Midia;
import br.com.moviedelivery.model.GraficoMidia;
import br.com.moviedelivery.service.IMidiaService;
import br.com.moviedelivery.util.RelatorioFactory;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@Named("midiaManagedBean")
@RequestScoped
public class MidiaManagedBean {
    
    private Midia midia;
    private Midia midiaSelecionada;
    private short idCategoriaSelecionada;
    
    @EJB
    private IMidiaService midiaService;
    
    public List<Midia> listar(){
        return midiaService.listar();
    }
    
    public List<Midia> listarDestaque(){
        return midiaService.listarDestaque();
    }
    
    public List<Midia> listarPorCategoria(){
        return midiaService.listarPorCategoria(idCategoriaSelecionada);
    }
    
    public MidiaManagedBean(){
        midia = new Midia();
    }
    
    public void salvar() {
        String erro = midiaService.salvar(midia);
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Midia salva com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        midia = new Midia();
    }
    
    public void excluir(){
        String erro = midiaService.remover(midiaSelecionada.getIdMidia());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Midia excluida com sucesso", null);
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
        
        List<GraficoMidia> graficoModels = midiaService.gerarGrafico();
        
        for (GraficoMidia graficoModel : graficoModels) {
            ChartSeries cor = new ChartSeries(); 
            cor.setLabel(graficoModel.getCategoria());
            cor.set(graficoModel.getCategoria(), graficoModel.getDuracao());
            model.addSeries(cor);
        }
        
        return model;
    }
    
    public void imprimir(){
        RelatorioFactory.Relatorios("/WEB-INF/relatorios/reportMidia.jasper");
    }
    
    public void editar(){
        midia = midiaSelecionada;
    }
    
    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    public Midia getMidiaSelecionada() {
        return midiaSelecionada;
    }

    public void setMidiaSelecionada(Midia midiaSelecionada) {
        this.midiaSelecionada = midiaSelecionada;
    }

    public short getIdCategoriaSelecionada() {
        return idCategoriaSelecionada;
    }

    public void setIdCategoriaSelecionada(short idCategoriaSelecionada) {
        this.idCategoriaSelecionada = idCategoriaSelecionada;
    }

    public IMidiaService getMidiaService() {
        return midiaService;
    }

    public void setMidiaService(IMidiaService midiaService) {
        this.midiaService = midiaService;
    }
    
    
    
}
