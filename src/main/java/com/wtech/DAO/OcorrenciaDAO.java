/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtech.DAO;

import com.wtech.Model.Ocorrencia;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Fernanda Lemos
 */
public class OcorrenciaDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public Ocorrencia getOcorrenciaById(int id) {
        Ocorrencia ocorrencia = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            ocorrencia = (Ocorrencia) session.createQuery("from Ocorrencia where id = :id").setParameter("id", id).uniqueResult();
            
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

        return ocorrencia;
    }

    public List<Ocorrencia> getAllOcorrencia() {
        List<Ocorrencia> ocorrencias = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            ocorrencias = session.createQuery("from Ocorrencia").list();
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

        return ocorrencias;
    }
    
    public boolean saveOcorrencia(Ocorrencia ocorrencia) {
        Session session = null;
        boolean hasError = false;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            
            session.saveOrUpdate(ocorrencia);
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
    
    public boolean deleteOcorrencia(int id) {
        Session session = null;
        boolean hasError = false;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Ocorrencia ocorrencia = this.getOcorrenciaById(id);
            session.delete(ocorrencia);
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
