/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tone
 */
@Entity
@Table(name = "RMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rma.findAll", query = "SELECT r FROM Rma r"),
    @NamedQuery(name = "Rma.findByFechaEmision", query = "SELECT r FROM Rma r WHERE r.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Rma.findByFechaRecepcion", query = "SELECT r FROM Rma r WHERE r.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "Rma.findByDetalle", query = "SELECT r FROM Rma r WHERE r.detalle = :detalle"),
    @NamedQuery(name = "Rma.findByCodigo", query = "SELECT r FROM Rma r WHERE r.codigo = :codigo")})
public class Rma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Size(max = 200)
    @Column(name = "detalle")
    private String detalle;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "codigo_terminal", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Terminal codigoTerminal;

    public Rma() {
    }

    public Rma(Integer codigo) {
        this.codigo = codigo;
    }

    public Rma(Integer codigo, Date fechaEmision) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Terminal getCodigoTerminal() {
        return codigoTerminal;
    }

    public void setCodigoTerminal(Terminal codigoTerminal) {
        this.codigoTerminal = codigoTerminal;
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
        if (!(object instanceof Rma)) {
            return false;
        }
        Rma other = (Rma) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Rma[ codigo=" + codigo + " ]";
    }
    
}
