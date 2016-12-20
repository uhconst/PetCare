/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    
    @Column(name="NASCIMENTO")
    private Date nascimento;
    
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

    public Date getNascimento(){
        return nascimento;
    }

    public void setNascimento( Date nascimento ){
        /*        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dataNascimento = null;  
        //java.util.Date dataReuniao = null;
        try {
            dataNascimento = (java.util.Date) formatter.parse(nascimento.toString());
            //dataReuniao = (java.util.Date) formatter.parse(txtDataReuniao.getValue().toString()); 
        } catch (ParseException ex) {
            //Logger.getLogger(CadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date dataNascimento_Sql = new java.sql.Date(dataNascimento.getTime());
        System.out.println("\nDentro do model.domain , data: " + dataNascimento_Sql);
        this.nascimento = dataNascimento_Sql;*/
        
        this.nascimento = nascimento;
        //this.nascimento = new java.sql.Date(nascimento.getTime());
        //SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        //this.nascimento = new java.sql.Date(formatarDate.parse(nascimento).getTime());
        //DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
        //try{
        //this.nascimento = (Date)formatter.parse(nascimento);
        //}
        //catch(E ex){}
        
    }
/*
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
*/
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
