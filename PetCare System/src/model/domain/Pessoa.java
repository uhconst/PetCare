/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

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
    
    //@Column(name="TELEFONE",length=20,nullable=true)
    //private String telefone;
    private Telefone telefone;

    // REMOVI O RG, REMOVER NA MODELAGEM
    
    private String cpf;
    
    private String cep;
    
    public Pessoa(){

    }
}
