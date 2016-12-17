/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Objects;

/**
 *
 * @author Constancio
 */
public class Pessoa{
    private Integer id;
    
    //@Column(name="NOME",length=50,nullable=false)
    private String nome;
    
    //@Column(name="SOBRENOME",length=50,nullable=false)
    private String sobrenome;
    
    private String nascimento;
    
    //@Column(name="EMAIL",length=50,nullable=true)
    //private String email;
    private Email email;
    
    /*@Column(name="TELEFONE",length=20,nullable=true)
    private String telefone;*/
    private Telefone telefone;

    // REMOVI O RG, REMOVER NA MODELAGEM
    
    private String cpf;
    
    private String cep;
    
    public Pessoa(){

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
        this.nome = nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public void setSobrenome( String sobrenome ){
        this.sobrenome = sobrenome;
    }

    public String getNascimento(){
        return nascimento;
    }

    public void setNascimento( String nascimento ){
        this.nascimento = nascimento;
    }

    public Email getEmail(){
        return email;
    }

    public void setEmail( Email email ){
        this.email = email;
    }

    public Telefone getTelefone(){
        return telefone;
    }

    public void setTelefone( Telefone telefone ){
        this.telefone = telefone;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf( String cpf ){
        this.cpf = cpf;
    }

    public String getCep(){
        return cep;
    }

    public void setCep( String cep ){
        this.cep = cep;
    }

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
