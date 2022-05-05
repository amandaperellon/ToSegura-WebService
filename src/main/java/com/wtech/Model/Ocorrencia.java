package com.wtech.Model;

import com.wtech.Model.Usuario;
import java.util.Calendar;
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
@Table(name="ocorrencia")
public class Ocorrencia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data",updatable = false)
    private Calendar data;
    
    @Column(name="descricao")
    private String descricao;
    
    @Column(name="situacao")
    private String situacao;
    
    @Column(name="ponto")
    private String ponto;
   
    @ManyToOne(targetEntity = TipoOcorrencia.class, fetch=FetchType.EAGER)
    @JoinColumn(name="tipo_ocorrencia_id")
    private TipoOcorrencia tipo_ocorrencia;
    
    @ManyToOne(targetEntity = Usuario.class, fetch=FetchType.EAGER)
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
    
    @ManyToOne(targetEntity = TipoEstaturaAgressor.class, fetch=FetchType.EAGER)
    @JoinColumn(name="tipo_estatura_agressor_id")
    private TipoEstaturaAgressor tipo_estatura_agressor;
    
    @ManyToOne(targetEntity = TipoTomPele.class, fetch=FetchType.EAGER)
    @JoinColumn(name="tipo_tom_pele_id")
    private TipoTomPele tipo_tom_pele;
    
    @ManyToOne(targetEntity = TipoColoracaoCabelo.class, fetch=FetchType.EAGER)
    @JoinColumn(name="tipo_coloracao_cabelo_id")
    private TipoColoracaoCabelo tipo_coloracao_cabelo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPonto() {
        return ponto;
    }

    public void setPonto(String ponto) {
        this.ponto = ponto;
    }

    public TipoOcorrencia getTipo_ocorrencia() {
        return tipo_ocorrencia;
    }

    public void setTipo_ocorrencia(TipoOcorrencia tipo_ocorrencia) {
        this.tipo_ocorrencia = tipo_ocorrencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoEstaturaAgressor getTipo_estatura_agressor() {
        return tipo_estatura_agressor;
    }

    public void setTipo_estatura_agressor(TipoEstaturaAgressor tipo_estatura_agressor) {
        this.tipo_estatura_agressor = tipo_estatura_agressor;
    }

    public TipoTomPele getTipo_tom_pele() {
        return tipo_tom_pele;
    }

    public void setTipo_tom_pele(TipoTomPele tipo_tom_pele) {
        this.tipo_tom_pele = tipo_tom_pele;
    }

    public TipoColoracaoCabelo getTipo_coloracao_cabelo() {
        return tipo_coloracao_cabelo;
    }

    public void setTipo_coloracao_cabelo(TipoColoracaoCabelo tipo_coloracao_cabelo) {
        this.tipo_coloracao_cabelo = tipo_coloracao_cabelo;
    }
    
    public Ocorrencia(){
        this.data = Calendar.getInstance();
    }
 
}
