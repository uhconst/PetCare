/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Constancio
 */
@Entity
@Table (name="PESSOA")
public class Pessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PESSOA")
    private Integer id;
    
    @Column(name="NOME")//,length=45,nullable=false)
    private String nome;
    
    @Column(name="SOBRENOME")//,length=45)//,nullable=false)
    private String sobrenome;
    
    //@Temporal(TemporalType.DATE)
    @Column(name="NASCIMENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date nascimento;
    
    //@Column(name="EMAIL",length=50,nullable=true)
    //private String email;
    /*
    @OneToOne
    @JoinColumn(name = "ID_EMAIL")
    private Email email;
    */
    
    /*@Column(name="TELEFONE",length=20,nullable=true)
    private String telefone;*/
    /*
    @OneToOne
    @JoinColumn(name = "ID_TELEFONE")
    private Telefone telefone;
*/
    // REMOVI O RG, REMOVER NA MODELAGEM
    
    
    @Column(name="CPF")
    private String cpf;
    
    @Column(name="CEP")
    private String cep;
 /*   
    @OneToMany(mappedBy = "pessoa")
    private List<Email> emails;
 */   
    @OneToMany(mappedBy = "pessoa")
    private List<Telefone> telefones;
    
    @OneToOne(mappedBy = "pessoa")
    private Email email;
    
    //private String allEmails;
    
    public Pessoa(){
        /*
         * Criando nova pessoa, senao ele fica null ate ser selecionado
         * na tabela. E quando só digitado da erro de null.
         */
        setEmail( new Email() );
    }

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome( String nome ){
        //System.out.println("Nome digitado dentro da classe pessoa ao setar: "+nome);
        this.nome = nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public void setSobrenome( String sobrenome ){
        this.sobrenome = sobrenome;
    }

    public java.util.Date getNascimento(){
        return nascimento;
    }

    public void setNascimento( java.util.Date nascimento ){
        //System.out.println("\nDentro do domain, date como foi recebida:" + nascimento);
        this.nascimento = nascimento;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf( String cpf ){
        /*
         * Usando RegEx para salvar o cpf sem a mascara do
         * JFormatedTextField. Usando Trim para tirar os epaços quando
         * não pesquisa o CPF inteiro.
         */
        System.out.print("\nCPF no Domain com RegEx: " + cpf.replaceAll("[.-]", "").trim() );
        this.cpf = cpf.replaceAll("[.-]", "").trim();
    }

    public String getCep(){
        return cep;
    }

    public void setCep( String cep ){
        /*
         * Usando RegEx para salvar o cep sem a mascara do
         * JFormatedTextField.
         */
        this.cep = cep.replaceAll("[-]", "");
    }
/*
    public List<Email> getEmails(){
        return emails;
    }

    public void setEmails( List<Email> emails ){
        this.emails = emails;
        //setAllEmails( this.emails.get( 0 ).getEndereco_email());
    }
*/
    public List<Telefone> getTelefones(){
        return telefones;
    }

    public void setTelefones( List<Telefone> telefones ){
        this.telefones = telefones;
    }

    public Email getEmail(){
        //System.out.println("Email digitado dentro da classe pessoa: "+email.getEndereco_email());
        return email;
    }

    public void setEmail( Email email ){
        //System.out.println("\n**********Email digitado dentro da classe pessoa para setar!!********** ");
        //System.out.println("Email digitado dentro da classe pessoa ao setar: "+email.getEndereco_email());
        this.email = email;
    }
    
    /*
     * Pra quando for salvar, se nao setar o email antes ele nao salva a pessoa
     *//*
    public void novoEmail(){
        //System.out.println("\n**********Email digitado dentro da classe pessoa para setar!!********** ");
        //System.out.println("Email digitado dentro da classe pessoa ao setar: "+email.getEndereco_email());
        this.email = new Email();
    }*/
/*
    
    public void setAllEmails( String allEmails ){
        this.allEmails = allEmails;
    }

    public String getAllEmails(){
        return allEmails;
    }
    */
 /*   
    public String getAllEmails(){
        //System.out.println("\n*********Email list 0: " + 
          //                  emails.get( 0 ).getEndereco_email() + "*********");
        return (emails.get( 0 ).getEndereco_email());
    }*/
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 83 * hash + Objects.hashCode( this.id );
        return hash;
    }

    @Override
    public boolean equals( Object obj ){
        if( this == obj ){
            return true;
        }
        if( obj == null ){
            return false;
        }
        if( getClass() != obj.getClass() ){
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if( !Objects.equals( this.id, other.id ) ){
            return false;
        }
        return true;
    }
    
    
}
