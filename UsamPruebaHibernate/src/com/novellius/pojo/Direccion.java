package com.novellius.pojo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "direccion")
@XmlRootElement
public class Direccion implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDir")
    private Integer idDir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cp")
    private String cp;
    @JoinColumn(name = "idAd", referencedColumnName = "idAd")
    @ManyToOne(optional = false)
    private Administrador idAd;

    public Direccion() {
    }

    public Direccion(Integer idDir) {
        this.idDir = idDir;
    }

    public Direccion(Integer idDir, String calle, String cp) {
        this.idDir = idDir;
        this.calle = calle;
        this.cp = cp;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Administrador getIdAd() {
        return idAd;
    }

    public void setIdAd(Administrador idAd) {
        this.idAd = idAd;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDir == null) ? 0 : idDir.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		if (idDir == null) {
			if (other.idDir != null)
				return false;
		} else if (!idDir.equals(other.idDir))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Direccion [idDir=" + idDir + ", calle=" + calle + ", cp=" + cp + ", idAd=" + idAd + "]";
	}
}
