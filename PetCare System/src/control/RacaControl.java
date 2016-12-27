/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import model.dao.RacaDao;
import model.domain.Raca;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Constancio
 */
public class RacaControl{
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Raca racaDigitado;
    
    private Raca racaSelecionado;
    
    private List<Raca> racasTabela;
    
    private final RacaDao racaDao;
    
    public RacaControl(){
        racaDao = new RacaDao();
        racasTabela = ObservableCollections.observableList( new ArrayList<Raca>() );
        novo();
        pesquisar();
    }
    
    public void pesquisar(){
        racasTabela.clear();
        racasTabela.addAll(racaDao.pesquisar(racaDigitado));
    }
    
    public void salvar(){
        racaDao.salvarAtualizar( racaDigitado );
        novo();
        pesquisar();
    }
    
    public void excluir(){
        racaDao.excluir( racaSelecionado );
        novo();
        pesquisar();
    }
    
    public void novo(){
         setRacaDigitado( new Raca() );
    }

    public Raca getRacaDigitado(){
        return racaDigitado;
    }

    public void setRacaDigitado( Raca racaDigitado ){
        Raca oldRacaDigitado = this.racaDigitado;
        this.racaDigitado = racaDigitado;
        propertyChangeSupport.firePropertyChange( "racaDigitado", oldRacaDigitado, racaDigitado);
    }

    public Raca getRacaSelecionado(){
        return racaSelecionado;
    }

    public void setRacaSelecionado( Raca racaSelecionado ){
        this.racaSelecionado = racaSelecionado;
        if( this.racaSelecionado != null ){
            setRacaDigitado(racaSelecionado);
        }
    }

    public List<Raca> getRacasTabela(){
        return racasTabela;
    }

    public void setRacasTabela( List<Raca> racasTabela ){
        this.racasTabela = racasTabela;
    }
 
     public void addPropertyChangeListener(PropertyChangeListener e){
        propertyChangeSupport.addPropertyChangeListener( e );
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
}
