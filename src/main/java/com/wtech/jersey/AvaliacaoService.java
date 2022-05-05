/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtech.jersey;

import com.wtech.DAO.AvaliacaoDAO;
import com.wtech.Model.Avaliacao;
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
@Path("Avaliacoes")
public class AvaliacaoService {

    private AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String save(Avaliacao avaliacao) {
        if (!avaliacaoDao.saveAvaliacao(avaliacao)) {
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"not ok\"}";
        }
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Avaliacao> getAll() {

        return avaliacaoDao.getAllAvaliacao();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Avaliacao getById(@PathParam("id") int id) {
        return avaliacaoDao.getAvaliacaoById(id);
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
 
    public String update(@PathParam("id") int id, Avaliacao avaliacao) {
        
        avaliacao.setId(id);
        if (!avaliacaoDao.saveAvaliacao(avaliacao)) {
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"not ok\"}";

        }
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {

        if (!avaliacaoDao.deleteAvaliacao(id)) {
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"not ok\"}";

        }
    }
}
