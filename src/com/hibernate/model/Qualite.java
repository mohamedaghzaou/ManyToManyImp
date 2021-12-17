package com.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(@NamedQuery(name = "qualitePost", query = "select q from Qualite q join"
		+ " q.profiles p join p.posts pst where pst.refPost =:id"))

public class Qualite {

	@Id
	@GeneratedValue
	@Column(name = "ref_Qualite")
	private Integer refQualite;

	@Column(name = "intule_Qualite")
	private String inituleQualite;

	@ManyToMany
	@JoinTable(name = "qualite_profile", joinColumns = @JoinColumn(name = "id_Qualite"), inverseJoinColumns = @JoinColumn(name = "id_profile"))
	List<Profile> profiles;

	public Integer getRefQualite() {
		return refQualite;
	}

	public void setRefQualite(Integer refQualite) {
		this.refQualite = refQualite;
	}

	public String getInituleQualite() {
		return inituleQualite;
	}

	public void setInituleQualite(String inituleQualite) {
		this.inituleQualite = inituleQualite;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	@Override
	public String toString() {
		return "Qualite [refQualite=" + refQualite + ", inituleQualite=" + inituleQualite + "]";
	}

}
