/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiagojsf.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Tiago
 */
@Entity(name = "endereco")
public class Endereco implements Serializable{ 
    private static final long serialVersionUID = 1L;
      
    @Id
    @GeneratedValue
    @Column(name="id_endereco", nullable = false)
    private Integer idEndereco;
    
    @Column(name = "bairro", length = 80)
    private String bairro;
    
    
    @Column(name = "nm_log", length = 80)
    private String nomeLogradouro;
    
    @Column(name = "cep", length = 80)
    private String cep;
    
    @Column(name = "numero", length = 80)
    private Integer numero;
    
    @Column(name = "complemento", length = 80)
    private String complemento;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoPessoa")
    @JoinColumn(name="IdPessoa", referencedColumnName = "IdPessoa")
    private Pessoa pessoa;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoEndereco")
    @JoinColumn(name="id_estado",  nullable = false)
    private Estado estado;
    
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoEndereco")
    @JoinColumn(name="id_cidade", referencedColumnName = "id_cidade")
    private Cidade cidade;
    
    
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "TipoLogradouroEndereco")
    @JoinColumn(name="id_tiplog", referencedColumnName = "id_tiplog")
    private TipoLogradouro tipoLogradouro;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoEndereco")
    @JoinColumn(name="id_tipend", referencedColumnName = "id_tipend")
    private TipoEndereco tipoEndereco;

    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipoLogradouro = new TipoLogradouro();
        this.tipoEndereco = new TipoEndereco();
        this.pessoa = new Pessoa();
        
    }

    
    
    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
    
    
    
    
    
    
    
    
}
