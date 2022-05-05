/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtech.jersey;

import com.wtech.DAO.UsuarioDAO;
import com.wtech.Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Fernanda Lemos
 */
@Path("Usuarios")
public class UsuarioService {

    private UsuarioDAO userDao = new UsuarioDAO();
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Usuario getUserByIdJSON(@PathParam("id") int id) {
        return userDao.getUserById(id);
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Usuario> getAllUsersInJSON() {

        return userDao.getAllUsers();
    }
    
    @GET
    @Path("/login/{email}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)

    public String getEmail(@PathParam("email") String email, @PathParam("senha") String senha) {

        boolean resultado = userDao.getLogin(email, senha);
        
        if(resultado != true){
			return "{\"status\":\"login efetuado com sucesso\"}";
		}else{
			return "{\"status\":\"e-mail ou senha errado\"}";
		}
    }
 //inserindo novas pessoas e retornando json como ok or not
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveNewUser(Usuario user) {
        boolean resultado = userDao.getEmail(user.getEmail());
		if(resultado == true){
			if (!userDao.saveUser(user)){
				return "{\"status\":\"cadastrado com sucesso\"}";
			}else{
				return "{\"status\":\"problemas no cadastro\"}";
			}
		}else{
			return "{\"status\":\"email já cadastrado\"}";
		}
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(@PathParam("id") int id) {

        if (!userDao.deleteUser(id)) {
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"not ok\"}";

        }
    }

 //atualizando pessoa existente
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
 
    public String updateUser(@PathParam("id") int id, Usuario user) {
        
        user.setId(id);
        if (!userDao.saveUser(user)) {
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"not ok\"}";

        }
    }
}
