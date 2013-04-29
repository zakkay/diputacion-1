/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "PLAN_CONCERTACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanConcertacion.findAll", query = "SELECT p FROM PlanConcertacion p"),
    @NamedQuery(name = "PlanConcertacion.findByCodigo", query = "SELECT p FROM PlanConcertacion p WHERE p.planConcertacionPK.codigo = :codigo"),
    @NamedQuery(name = "PlanConcertacion.findByFecha", query = "SELECT p FROM PlanConcertacion p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PlanConcertacion.findByNombre", query = "SELECT p FROM PlanConcertacion p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PlanConcertacion.findByDescripcion", query = "SELECT p FROM PlanConcertacion p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PlanConcertacion.findByPrecio", query = "SELECT p FROM PlanConcertacion p WHERE p.precio = :precio"),
    @NamedQuery(name = "PlanConcertacion.findByCodigoDip", query = "SELECT p FROM PlanConcertacion p WHERE p.planConcertacionPK.codigoDip = :codigoDip"),
    @NamedQuery(name = "PlanConcertacion.findByNombre1", query = "SELECT p FROM PlanConcertacion p WHERE p.planConcertacionPK.nombre1 = :nombre1"),
    @NamedQuery(name = "PlanConcertacion.findByProvincia", query = "SELECT p FROM PlanConcertacion p WHERE p.planConcertacionPK.provincia = :provincia")})
public class PlanConcertacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanConcertacionPK planConcertacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Long precio;
    @JoinColumns({
        @JoinColumn(name = "provincia", referencedColumnName = "provincia", insertable = false, updatable = false),
        @JoinColumn(name = "nombre1", referencedColumnName = "nombre", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Municipio municipio;
    @JoinColumn(name = "codigo_dip", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diputacion diputacion;

    public PlanConcertacion() {
    }

    public PlanConcertacion(PlanConcertacionPK planConcertacionPK) {
        this.planConcertacionPK = planConcertacionPK;
    }

    public PlanConcertacion(PlanConcertacionPK planConcertacionPK, Date fecha, String nombre, String descripcion) {
        this.planConcertacionPK = planConcertacionPK;
        this.fecha = fecha;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public PlanConcertacion(int codigo, int codigoDip, String nombre1, String provincia) {
        this.planConcertacionPK = new PlanConcertacionPK(codigo, codigoDip, nombre1, provincia);
    }

    public PlanConcertacionPK getPlanConcertacionPK() {
        return planConcertacionPK;
    }

    public void setPlanConcertacionPK(PlanConcertacionPK planConcertacionPK) {
        this.planConcertacionPK = planConcertacionPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Diputacion getDiputacion() {
        return diputacion;
    }

    public void setDiputacion(Diputacion diputacion) {
        this.diputacion = diputacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planConcertacionPK != null ? planConcertacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanConcertacion)) {
            return false;
        }
        PlanConcertacion other = (PlanConcertacion) object;
        if ((this.planConcertacionPK == null && other.planConcertacionPK != null) || (this.planConcertacionPK != null && !this.planConcertacionPK.equals(other.planConcertacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.PlanConcertacion[ planConcertacionPK=" + planConcertacionPK + " ]";
    }
    
}
