/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtech.jersey;

import com.wtech.DAO.OcorrenciaDAO;
import com.wtech.Model.Ocorrencia;
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
@Path("Ocorrencias")
public class OcorrenciaService {

    private OcorrenciaDAO ocorrenciaDao = new OcorrenciaDAO();

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String save(Ocorrencia ocorrencia) {
        
        if (!ocorrenciaDao.saveOcorrencia(ocorrencia)) {
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"not ok\"}";

        }
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Ocorrencia> getAll() {

        return ocorrenciaDao.getAllOcorrencia();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Ocorrencia getById(@PathParam("id") int id) {
        return ocorrenciaDao.getOcorrenciaById(id);
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
 
    public String update(@PathParam("id") int id, Ocorrencia ocorrencia) {
        
        ocorrencia.setId(id);
        if (!ocorrenciaDao.saveOcorrencia(ocorrencia)) {
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"not ok\"}";

        }
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {

        if (!ocorrenciaDao.deleteOcorrencia(id)) {
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"not ok\"}";

        }
    }
}
