/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tone
 */
@Entity
@Table(name = "LINEA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linea.findAll", query = "SELECT l FROM Linea l"),
    @NamedQuery(name = "Linea.findByCodigo", query = "SELECT l FROM Linea l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "Linea.findByNumero", query = "SELECT l FROM Linea l WHERE l.numero = :numero"),
    @NamedQuery(name = "Linea.findByPeriodoFacturacion", query = "SELECT l FROM Linea l WHERE l.periodoFacturacion = :periodoFacturacion"),
    @NamedQuery(name = "Linea.findByPublico", query = "SELECT l FROM Linea l WHERE l.publico = :publico")})
public class Linea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "numero")
    private String numero;
    @Column(name = "periodo_facturacion")
    @Temporal(TemporalType.DATE)
    private Date periodoFacturacion;
    @Column(name = "publico")
    private Character publico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "linea")
    private Collection<AsignacionFijo> asignacionFijoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "linea")
    private Llamada llamada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "linea")
    private Collection<AsignacionMovil> asignacionMovilCollection;

    public Linea() {
    }

    public Linea(Integer codigo) {
        this.codigo = codigo;
    }

    public Linea(Integer codigo, String numero) {
        this.codigo = codigo;
        this.numero = numero;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getPeriodoFacturacion() {
        return periodoFacturacion;
    }

    public void setPeriodoFacturacion(Date periodoFacturacion) {
        this.periodoFacturacion = periodoFacturacion;
    }

    public Character getPublico() {
        return publico;
    }

    public void setPublico(Character publico) {
        this.publico = publico;
    }

    @XmlTransient
    public Collection<AsignacionFijo> getAsignacionFijoCollection() {
        return asignacionFijoCollection;
    }

    public void setAsignacionFijoCollection(Collection<AsignacionFijo> asignacionFijoCollection) {
        this.asignacionFijoCollection = asignacionFijoCollection;
    }

    public Llamada getLlamada() {
        return llamada;
    }

    public void setLlamada(Llamada llamada) {
        this.llamada = llamada;
    }

    @XmlTransient
    public Collection<AsignacionMovil> getAsignacionMovilCollection() {
        return asignacionMovilCollection;
    }

    public void setAsignacionMovilCollection(Collection<AsignacionMovil> asignacionMovilCollection) {
        this.asignacionMovilCollection = asignacionMovilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linea)) {
            return false;
        }
        Linea other = (Linea) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Linea[ codigo=" + codigo + " ]";
    }
    
}
