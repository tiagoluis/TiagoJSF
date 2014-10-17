 
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

@Entity(name = "tip_end")
public class TipoEndereco implements Serializable{ 
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue
    @Column(name="id_tipend", nullable = false)
    private Integer idEstado;
    
    @Column(name = "descricao", length = 80, nullable = false)
    private String descricao;  

    @OneToMany
    @ForeignKey(name = "EstadoEndereco")
    private List<Endereco> enderecos;

    public TipoEndereco() {
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.idEstado != null ? this.idEstado.hashCode() : 0);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (this.idEstado != other.idEstado && (this.idEstado == null || !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }
      
}
