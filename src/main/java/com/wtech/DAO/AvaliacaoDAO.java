/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtech.DAO;

import com.wtech.Model.Avaliacao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Fernanda Lemos
 */
public class AvaliacaoDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public Avaliacao getAvaliacaoById(int id) {
        Avaliacao avaliacao = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            avaliacao = (Avaliacao) session.createQuery("from Avaliacao where id = :id").setParameter("id", id).uniqueResult();
            
            session.getTransaction().commit();

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            
            throw ex;

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return avaliacao;
    }

    public List<Avaliacao> getAllAvaliacao() {
        List<Avaliacao> avaliacoes = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            avaliacoes = session.createQuery("from Avaliacao").list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return avaliacoes;
    }
    
    public boolean saveAvaliacao(Avaliacao avaliacao) {
        Session session = null;
        boolean hasError = false;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            
            session.saveOrUpdate(avaliacao);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            hasError = true;
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return hasError;
    }
    
    public boolean deleteAvaliacao(int id) {
        Session session = null;
        boolean hasError = false;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Avaliacao avaliacao = this.getAvaliacaoById(id);
            session.delete(avaliacao);
//            session.persist(user);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            hasError = true;
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return hasError;
    }
}
