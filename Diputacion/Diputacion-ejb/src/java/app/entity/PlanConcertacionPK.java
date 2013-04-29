/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tone
 */
@Embeddable
public class PlanConcertacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_dip")
    private int codigoDip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre1")
    private String nombre1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "provincia")
    private String provincia;

    public PlanConcertacionPK() {
    }

    public PlanConcertacionPK(int codigo, int codigoDip, String nombre1, String provincia) {
        this.codigo = codigo;
        this.codigoDip = codigoDip;
        this.nombre1 = nombre1;
        this.provincia = provincia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoDip() {
        return codigoDip;
    }

    public void setCodigoDip(int codigoDip) {
        this.codigoDip = codigoDip;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigo;
        hash += (int) codigoDip;
        hash += (nombre1 != null ? nombre1.hashCode() : 0);
        hash += (provincia != null ? provincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanConcertacionPK)) {
            return false;
        }
        PlanConcertacionPK other = (PlanConcertacionPK) object;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.codigoDip != other.codigoDip) {
            return false;
        }
        if ((this.nombre1 == null && other.nombre1 != null) || (this.nombre1 != null && !this.nombre1.equals(other.nombre1))) {
            return false;
        }
        if ((this.provincia == null && other.provincia != null) || (this.provincia != null && !this.provincia.equals(other.provincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.PlanConcertacionPK[ codigo=" + codigo + ", codigoDip=" + codigoDip + ", nombre1=" + nombre1 + ", provincia=" + provincia + " ]";
    }
    
}
