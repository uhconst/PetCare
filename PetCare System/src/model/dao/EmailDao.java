/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Email;

/**
 *
 * @author Constancio
 */
public class EmailDao{
    public void salvarAtualizar(Email email) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(email.getId() !=null){
            email = em.merge(email);
        }
        em.persist(email);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluir(Email email) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        email = em.merge(email);
        em.remove(email);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Email> pesquisar(Email email) {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Email e "
                + "where 1 = 1 ");
        if (email.getId() !=null) {
            sql.append("and e.id = :id_email ");
        }
        /*if (email.getEndereco_Email() !=null &&
                !email.getEndereco_Email().equals("")){
            sql.append("and e.endereco_email like :endereco_email");
            
        }*/
        Query query = em.createQuery(sql.toString());
        if (email.getId() !=null) {
            query.setParameter("id_email",email.getId());
            
        }/*
        if (email.getEndereco_Email() != null &&
                !email.getEndereco_Email().equals("")){
            query.setParameter("endereco_email","%"+email.getEndereco_Email());
        }*/
        return query.getResultList();
    }
}
