/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtech.DAO;

import com.wtech.Model.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;

/**
 *
 * @author Fernanda Lemos
 */
public class UsuarioDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public Usuario getUserById(int id) {
        Usuario usermodel = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            usermodel = (Usuario) session.createQuery("from Usuario where id = :id").setParameter("id", id).uniqueResult();
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
        return usermodel;
    }
    
    public boolean getEmail(String email) {
        Usuario usermodel = null;
        Session session = null;
        boolean resultado = false;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            usermodel = (Usuario) session.createQuery("from Usuario where email = :email").setParameter("email", email).uniqueResult();
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
        
        if(usermodel == null){
			resultado = true;
		}
        
        return resultado;
    }
    
	public boolean getLogin(String email, String senha) {
		Usuario usermodel = null;
		Session session = null;
		boolean resultado = false;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			usermodel = (Usuario) session.createQuery("from Usuario where email = :email AND senha = :senha").setParameter("email", email).setParameter("senha", senha).uniqueResult();
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

		if(usermodel == null){
			resultado = true;
		}

		return resultado;
	}

    public List<Usuario> getAllUsers() {
        List<Usuario> users = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            users = session.createQuery("from Usuario").list();
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
        return users;
    }
    
    public boolean saveUser(Usuario user) {
        Session session = null;
        boolean hasError = false;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            
            session.saveOrUpdate(user);
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
    
    public boolean deleteUser(int id) {
        Session session = null;
        boolean hasError = false;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Usuario user = this.getUserById(id);
            session.delete(user);
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
