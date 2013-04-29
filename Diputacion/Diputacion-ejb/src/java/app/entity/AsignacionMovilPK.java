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
public class AsignacionMovilPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_numero")
    private int codigoNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_terminal")
    private int codigoTerminal;

    public AsignacionMovilPK() {
    }

    public AsignacionMovilPK(String dni, int codigoNumero, int codigoTerminal) {
        this.dni = dni;
        this.codigoNumero = codigoNumero;
        this.codigoTerminal = codigoTerminal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCodigoNumero() {
        return codigoNumero;
    }

    public void setCodigoNumero(int codigoNumero) {
        this.codigoNumero = codigoNumero;
    }

    public int getCodigoTerminal() {
        return codigoTerminal;
    }

    public void setCodigoTerminal(int codigoTerminal) {
        this.codigoTerminal = codigoTerminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        hash += (int) codigoNumero;
        hash += (int) codigoTerminal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionMovilPK)) {
            return false;
        }
        AsignacionMovilPK other = (AsignacionMovilPK) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        if (this.codigoNumero != other.codigoNumero) {
            return false;
        }
        if (this.codigoTerminal != other.codigoTerminal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.AsignacionMovilPK[ dni=" + dni + ", codigoNumero=" + codigoNumero + ", codigoTerminal=" + codigoTerminal + " ]";
    }
    
}
