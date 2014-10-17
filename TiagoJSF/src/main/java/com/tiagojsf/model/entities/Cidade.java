 
package com.tiagojsf.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Tiago
 */

@Entity(name = "cidade")
public class Cidade implements Serializable{ 
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue
    @Column(name="id_cidade", nullable = false)
    private Integer idCidade;
    
    @Column(name = "nm_cidade", length = 80, nullable = false)
    private String nomeCidade;  

    @OneToMany
    @ForeignKey(name = "Cid_End")
    private List<Endereco> enderecos;
    public Cidade() {
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }
    
}
