/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tone
 */
@Entity
@Table(name = "LLAMADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamada.findAll", query = "SELECT l FROM Llamada l"),
    @NamedQuery(name = "Llamada.findByNumeroDestino", query = "SELECT l FROM Llamada l WHERE l.numeroDestino = :numeroDestino"),
    @NamedQuery(name = "Llamada.findByTipo", query = "SELECT l FROM Llamada l WHERE l.tipo = :tipo"),
    @NamedQuery(name = "Llamada.findByDuracion", query = "SELECT l FROM Llamada l WHERE l.duracion = :duracion"),
    @NamedQuery(name = "Llamada.findByCoste", query = "SELECT l FROM Llamada l WHERE l.coste = :coste"),
    @NamedQuery(name = "Llamada.findByCodigoNumero", query = "SELECT l FROM Llamada l WHERE l.codigoNumero = :codigoNumero")})
public class Llamada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "numero_destino")
    private String numeroDestino;
    @Size(max = 40)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coste")
    private long coste;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_numero")
    private Integer codigoNumero;
    @JoinColumn(name = "codigo_numero", referencedColumnName = "codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Linea linea;

    public Llamada() {
    }

    public Llamada(Integer codigoNumero) {
        this.codigoNumero = codigoNumero;
    }

    public Llamada(Integer codigoNumero, String numeroDestino, int duracion, long coste) {
        this.codigoNumero = codigoNumero;
        this.numeroDestino = numeroDestino;
        this.duracion = duracion;
        this.coste = coste;
    }

    public String getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public long getCoste() {
        return coste;
    }

    public void setCoste(long coste) {
        this.coste = coste;
    }

    public Integer getCodigoNumero() {
        return codigoNumero;
    }

    public void setCodigoNumero(Integer codigoNumero) {
        this.codigoNumero = codigoNumero;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoNumero != null ? codigoNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Llamada)) {
            return false;
        }
        Llamada other = (Llamada) object;
        if ((this.codigoNumero == null && other.codigoNumero != null) || (this.codigoNumero != null && !this.codigoNumero.equals(other.codigoNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Llamada[ codigoNumero=" + codigoNumero + " ]";
    }
    
}
