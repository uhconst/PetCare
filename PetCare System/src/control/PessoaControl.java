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
import model.dao.PessoaDao;
import model.domain.Email;
import model.domain.Pessoa;
import model.domain.Telefone;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Constancio
 */
public class PessoaControl{
        
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Pessoa pessoaDigitado;
    
    private Pessoa pessoaSelecionado;
    
    private List<Pessoa> pessoasTabela;
    
    private final PessoaDao pessoaDao;
    
    public PessoaControl(){
        pessoaDao = new PessoaDao();
        pessoasTabela = ObservableCollections.observableList( new ArrayList<Pessoa>() );
        novo();
        pesquisar();
    }
    
    public void pesquisar(){
        pessoasTabela.clear();
        pessoasTabela.addAll(pessoaDao.pesquisar(pessoaDigitado));
    }
    
    public void salvar(){
        //System.out.println("\nBotao salvar, dendo do control, data: " + pessoaDigitado.getNascimento());
        //pessoaDigitado.novoEmail();
        
        /*
         * Tendo que setar o email como null primeiro, senão ele nao dava o
         * commit no Dao.
         */
        pessoaDigitado.setEmail( null);
        //pessoaSelecionado.setEmail( null); //testeee
        pessoaDao.salvarAtualizar( pessoaDigitado );
        //pessoaDigitado.setEmail( new Email() ); //teste
        novo();
        pesquisar();
    }
    
    public void excluir(){
        /* Setando os Telefones e emails como null, pq senão ao excluir
         * primeiro o telefone, e email, quando exclui a pessoa ele ta vinculado
         * a um telefone email não mais existente, caindo em uma excpetion e só
         * não excluia a Pessoa. Setando como Null antes resolve o problema.
        */
        //pessoaSelecionado.setEmails( null);
        pessoaSelecionado.setTelefones( null);
        
        pessoaDao.excluir( pessoaSelecionado );
        novo();
        pesquisar();
    }
    
    public void novo(){
         setPessoaDigitado( new Pessoa() );
    }

    public Pessoa getPessoaDigitado(){
        //System.out.println("\nPessoaDigitada: "+ pessoaDigitado.getNome() );
        return pessoaDigitado;
    }

    public void setPessoaDigitado( Pessoa pessoaDigitado ){
        Pessoa oldPessoaDigitado = this.pessoaDigitado;
        this.pessoaDigitado = pessoaDigitado;
        propertyChangeSupport.firePropertyChange( "pessoaDigitado", oldPessoaDigitado, pessoaDigitado);
    }

    public Pessoa getPessoaSelecionado(){
        //System.out.println("\nPessoaSelecionada: "+ pessoaSelecionado.getNome() );
        return pessoaSelecionado;
    }

    public void setPessoaSelecionado( Pessoa pessoaSelecionado ){
        this.pessoaSelecionado = pessoaSelecionado;
        if( this.pessoaSelecionado != null ){
            setPessoaDigitado(pessoaSelecionado);
        }
    }

    //test
    /*public void teste(){
        //test
        //this.pessoaSelecionado.getAllEmails();
    }*/
    public List<Pessoa> getPessoasTabela(){
        return pessoasTabela;
    }

    public void setPessoasTabela( List<Pessoa> pessoasTabela ){
        this.pessoasTabela = pessoasTabela;
    }
    
    /*
     * Retorna a lista de emails associada a pessoa que estara
     * sendo excluida. Para assim excluir os emails tambem.
    *//*
    public List<Email> getEmailList(){
        return pessoaSelecionado.getEmails();
    }*/
    
    public Email getEmail(){
        return pessoaSelecionado.getEmail();
    }

    /*
     * Retorna o email digitado para Salvar() o email.
     */
    public Email getEmailDigitado(){
        return pessoaDigitado.getEmail();
    }
    /*
     * Retorna a lista de telefones associada a pessoa que estara
     * sendo excluida. Para assim excluir os telefones tambem.
     */
    public List<Telefone> getTelefoneList(){
        return pessoaSelecionado.getTelefones();
    }
    
     public void addPropertyChangeListener(PropertyChangeListener e){
        propertyChangeSupport.addPropertyChangeListener( e );
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
    
    public void testPodeApagar(){
        System.out.println("Email digitado dentro da classe pessoa: "+pessoaDigitado.getEmail().getEndereco_email());
        //pessoaDigitado.getEmail();
        //System.out.println("Pessoa digitado dentro da classe pessoa: "+pessoaDigitado.getNome());
    }
}
