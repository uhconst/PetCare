/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Telefone;

/**
 *
 * @author Constancio
 */
public class TelefoneDao{
    public void salvarAtualizar(Telefone telefone) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(telefone.getId() !=null){
            telefone = em.merge(telefone);
        }
        em.persist(telefone);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluir(Telefone telefone) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        telefone = em.merge(telefone);
        em.remove(telefone);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Telefone> pesquisar(Telefone telefone) {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Telefone t "
                + "where 1 = 1 ");
        if (telefone.getId() !=null) {
            sql.append("and t.id = :id_telefone ");
        }
        if (telefone.getNumero() !=null &&
                !telefone.getNumero().equals("")){
            sql.append("and t.numero like :numero");
            
        }
        Query query = em.createQuery(sql.toString());
        if (telefone.getId() !=null) {
            query.setParameter("id_telefone",telefone.getId());
            
        }
        if (telefone.getNumero() != null &&
                !telefone.getNumero().equals("")){
            query.setParameter("numero","%"+telefone.getNumero());
        }
        return query.getResultList();
    }
    
}
