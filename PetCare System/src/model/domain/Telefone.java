/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Constancio
 */

@Entity
@Table (name="TELEFONE")
public class Telefone{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_TELEFONE")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;
 /*
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_CONTATO")
    private Tipo_Contato tipo_contato;*/
    
    // Na modelagem ta telefone, mudar lá
    @Column(name="NUMERO")
    private String numero;
    
    @Column(name="CATEGORIA")
    private String categoria;
    
    @Column(name="PRINCIPAL")
    private String principal;
    
    public Telefone(){
        
    }

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public Pessoa getPessoa(){
        return pessoa;
    }

    public void setPessoa( Pessoa pessoa ){
        this.pessoa = pessoa;
    }
/*
    public Tipo_Contato getTipo_contato(){
        return tipo_contato;
    }

    public void setTipo_contato( Tipo_Contato tipo_contato ){
        this.tipo_contato = tipo_contato;
    }
*/
    public String getNumero(){
        return numero;
    }

    public void setNumero( String numero ){
        this.numero = numero;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria( String categoria ){
        this.categoria = categoria;
    }

    public String getPrincipal(){
        return principal;
    }

    public void setPrincipal( String principal ){
        this.principal = principal;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 11 * hash + Objects.hashCode( this.id );
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
        final Telefone other = (Telefone) obj;
        if( !Objects.equals( this.id, other.id ) ){
            return false;
        }
        return true;
    }
    
    
}
