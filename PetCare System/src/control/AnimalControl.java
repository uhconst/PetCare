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
import model.dao.AnimalDao;
import model.domain.Animal;
import model.domain.Pessoa;
import model.domain.Raca;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Constancio
 */
public class AnimalControl{
            
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Animal animalDigitado;
    
    private Animal animalSelecionado;
    
    private List<Animal> animalsTabela;
    
    private final AnimalDao animalDao;
    
    public AnimalControl(){
        animalDao = new AnimalDao();
        animalsTabela = ObservableCollections.observableList( new ArrayList<Animal>() );
        novo();
        pesquisar();
    }
    
    public void pesquisar(){
        animalsTabela.clear();
        animalsTabela.addAll(animalDao.pesquisar(animalDigitado));
    }
    
    public void salvar(){
        animalDao.salvarAtualizar( animalDigitado );
        novo();
        pesquisar();
    }
    
    public void excluir(){
        animalDao.excluir( animalSelecionado );
        novo();
        pesquisar();
    }
    
    public void novo(){
         setAnimalDigitado( new Animal() );
    }

    public Animal getAnimalDigitado(){
        return animalDigitado;
    }

    public void setAnimalDigitado( Animal animalDigitado ){
        Animal oldAnimalDigitado = this.animalDigitado;
        this.animalDigitado = animalDigitado;
        propertyChangeSupport.firePropertyChange( "animalDigitado", oldAnimalDigitado, animalDigitado);
    }

    public Animal getAnimalSelecionado(){
        return animalSelecionado;
    }

    public void setAnimalSelecionado( Animal animalSelecionado ){
        this.animalSelecionado = animalSelecionado;
        if( this.animalSelecionado != null ){
            setAnimalDigitado(animalSelecionado);
        }
    }

    public List<Animal> getAnimalsTabela(){
        return animalsTabela;
    }

    public void setAnimalsTabela( List<Animal> animalsTabela ){
        this.animalsTabela = animalsTabela;
    }

    public void setProprietario( Pessoa pessoaSelecionado ){
        animalDigitado.setPessoa(pessoaSelecionado);
    }
    
    public void setRaca( Raca racaSelecionado ){
        animalDigitado.setRaca(racaSelecionado);
    }
    
    public String getNomeProprietario(){
        return animalDigitado.getNomeCompletoPessoa();
    }
    
    public String getNomeRaca(){
        return animalDigitado.getNomeRaca();
    }
        
   /*
     * Se a animalSelecionado nao for null, entao esta atualizando.
     * Caso esteja vazio, esta salvando
    */
    public int checkAtualizandoOuSalvando(){
        if(animalSelecionado!=null){
            // Atualizando
            return 1;
        }
        else{
            // Salvando
            return 0;
        }
    }
        
     public void addPropertyChangeListener(PropertyChangeListener e){
        propertyChangeSupport.addPropertyChangeListener( e );
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
}
