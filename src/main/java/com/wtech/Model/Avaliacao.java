package com.wtech.Model;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author gabi-
 */

@Entity 
@Table(name="avaliacao")

public class Avaliacao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="status")
    private String status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data",updatable = false)
    private Calendar data;
    
    @ManyToOne(targetEntity = Ocorrencia.class, fetch=FetchType.EAGER)
    @JoinColumn(name="ocorrencia_id")
    private Ocorrencia ocorrencia;
    
    @ManyToOne(targetEntity = Usuario.class, fetch=FetchType.EAGER)
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Avaliacao(){
        this.data = Calendar.getInstance();
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
}
