package com.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Diplome {

	@Id
	@GeneratedValue
	@Column(name = "ref_diplome")
	private Integer refDiplome;

	@Column(name = "intule_diplome")
	private String inituleDiplome;

	@ManyToMany
	@JoinTable(name = "diplome_profile", joinColumns = @JoinColumn(name = "id_Diplome"), inverseJoinColumns = @JoinColumn(name = "id_profile"))
	List<Profile> profiles;

	@Override
	public String toString() {
		return "Diplome [refDiplome=" + refDiplome + ", inituleDiplome=" + inituleDiplome + "]";
	}

	public Integer getRefDiplome() {
		return refDiplome;
	}

	public void setRefDiplome(Integer refDiplome) {
		this.refDiplome = refDiplome;
	}

	public String getInituleDiplome() {
		return inituleDiplome;
	}

	public void setInituleDiplome(String inituleDiplome) {
		this.inituleDiplome = inituleDiplome;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	
	

}
