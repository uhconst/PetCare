/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Servico;

/**
 *
 * @author Constancio
 */
public class ServicoDao{
    public void salvarAtualizar(Servico servico) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(servico.getId() != null){
            servico = em.merge(servico);
        }
        em.persist(servico);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluir(Servico servico) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        servico = em.merge(servico);
        em.remove(servico);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Servico> pesquisar(Servico servico) {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Servico r "
                + "where 1 = 1 ");
        if (servico.getId() !=null) {
            sql.append("and r.id = :id_servico ");
        }
        if (servico.getDescricao() !=null &&
                !servico.getDescricao().equals("")){
            sql.append("and LOWER(r.servico) like '%'||LOWER(:servico)||'%'");
            
        }
        Query query = em.createQuery(sql.toString());
        if (servico.getId() !=null) {
            query.setParameter("id_servico",servico.getId());
            
        }
        if (servico.getDescricao() != null &&
                !servico.getDescricao().equals("")){
            query.setParameter("servico","%"+servico.getDescricao());
        }
        return query.getResultList();
    }
}
