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
import javax.persistence.Table;

/**
 *
 * @author Constancio
 */
@Entity
@Table (name="SERVICO")
public class Servico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_SERVICO")
    private Integer id;
    
    @Column(name="DESCRICAO")
    private String descricao;

    @Column(name="TEMPO_ESTIMADO")
    private Integer tempo_estimado;

    @Column(name="VALOR")
    private Float valor;    

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao( String descricao ){
        this.descricao = descricao;
    }

    public Integer getTempo_estimado(){
        return tempo_estimado;
    }

    public void setTempo_estimado( Integer tempo_estimado ){
        this.tempo_estimado = tempo_estimado;
    }

    public Float getValor(){
        return valor;
    }

    public void setValor( Float valor ){
        this.valor = valor;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 19 * hash + Objects.hashCode( this.id );
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
        final Servico other = (Servico) obj;
        if( !Objects.equals( this.id, other.id ) ){
            return false;
        }
        return true;
    }
    
    
}
