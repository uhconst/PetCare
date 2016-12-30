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
import model.dao.TelefoneDao;
import model.domain.Pessoa;
import model.domain.Telefone;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Constancio
 */
public class TelefoneControl{
            
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Telefone telefoneDigitado;
    
    //private Pessoa pessoaDigitada;
    
    private Telefone telefoneSelecionado;
    
    private List<Telefone> telefonesTabela;
    
    private final TelefoneDao telefoneDao;
    
    public TelefoneControl(){
        telefoneDao = new TelefoneDao();
        telefonesTabela = ObservableCollections.observableList( new ArrayList<Telefone>() );
        novo();
        pesquisar();
    }
    
    public void pesquisar(){
        telefonesTabela.clear();
        telefonesTabela.addAll(telefoneDao.pesquisar(telefoneDigitado));
    }
    
    public void salvar(){
        /*System.out.println("Nome digitado: " + telefoneDigitado.getNome() + 
                            "\nTelefone digitado: " + telefoneDigitado.getTelefone());*/
        telefoneDao.salvarAtualizar( telefoneDigitado );
        novo();
        pesquisar();
    }
    
    public void excluir(){
        telefoneDao.excluir( telefoneSelecionado );
        novo();
        pesquisar();
    }
    
    public void novo(){
         setTelefoneDigitado( new Telefone() );
    }

    public Telefone getTelefoneDigitado(){
        return telefoneDigitado;
    }

    public void setTelefoneDigitado( Telefone telefoneDigitado ){
        Telefone oldTelefoneDigitado = this.telefoneDigitado;
        this.telefoneDigitado = telefoneDigitado;
        propertyChangeSupport.firePropertyChange( "telefoneDigitado", oldTelefoneDigitado, telefoneDigitado);
    }

    public Telefone getTelefoneSelecionado(){
        return telefoneSelecionado;
    }

    public void setTelefoneSelecionado( Telefone telefoneSelecionado ){
        this.telefoneSelecionado = telefoneSelecionado;
        if( this.telefoneSelecionado != null ){
            setTelefoneDigitado(telefoneSelecionado);
        }
    }

    public List<Telefone> getTelefonesTabela(){
        return telefonesTabela;
    }

    public void setTelefonesTabela( List<Telefone> telefonesTabela ){
        this.telefonesTabela = telefonesTabela;
    }
 
    // Setando a pessoa que foi digitada e salva
    public void setPessoaDigitada( Pessoa pessoaDigitada ){
        telefoneDigitado.setPessoa( pessoaDigitada );
        System.out.println("\n*******Dentro do TelefoneControl. "
                + "Nome da pessoa digitada: " + pessoaDigitada.getNome() +
                "*********");
    }

    public void setPrincipal( Boolean principal ){
        if(principal){
            telefoneDigitado.setPrincipal( "S" );
        }
        else{
            telefoneDigitado.setPrincipal( "N" );
        }
    }
    
    public void addPropertyChangeListener(PropertyChangeListener e){
        propertyChangeSupport.addPropertyChangeListener( e );
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
}
