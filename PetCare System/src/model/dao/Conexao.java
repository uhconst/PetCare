/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Constancio
 */
public class Conexao{
    /* Criando Gerenciamento de Entidade */
    private static EntityManagerFactory emf;

    /* Criando conexao */
    private static Conexao conexao;

    /* 
     * Construtor, define emf com a criação de uma entidade por uma função no 
     * persistence. Toda vez que cria uma conexao, mapeia ela.
     */
    private Conexao(){
        emf = Persistence.createEntityManagerFactory( "PetCarePU" );
    }

    /*
     * Função sincronizada para retornar a criação do gerenciamento
     * da entidade.
     */
    public synchronized static EntityManager getEntityManager(){
        if( conexao == null ){
            conexao = new Conexao();
        }
        return emf.createEntityManager();
    }
}
