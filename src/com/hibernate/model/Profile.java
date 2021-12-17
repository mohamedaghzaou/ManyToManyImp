package com.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(@NamedQuery(name = "diplomeProfile", query = "select p from Profile p join p.diplomes d where d.refDiplome = :id "))
public class Profile {

	@Id
	@GeneratedValue
	@Column(name = "ref_Profile")
	private Integer refProfile;

	@Column(name = "intule_profile")
	private String inituleProfile;
	private String niveauscolaire;

	public Integer getRefProfile() {
		return refProfile;
	}

	public void setRefProfile(Integer refProfile) {
		this.refProfile = refProfile;
	}

	public String getInituleProfile() {
		return inituleProfile;
	}

	public void setInituleProfile(String inituleProfile) {
		this.inituleProfile = inituleProfile;
	}

	public String getNiveauscolaire() {
		return niveauscolaire;
	}

	public void setNiveauscolaire(String niveauscolaire) {
		this.niveauscolaire = niveauscolaire;
	}

	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

	public List<Qualite> getQualites() {
		return qualites;
	}

	public void setQualites(List<Qualite> qualites) {
		this.qualites = qualites;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@ManyToMany(mappedBy = "profiles")
	List<Diplome> diplomes;

	@ManyToMany(mappedBy = "profiles")
	List<Qualite> qualites;

	@OneToMany(mappedBy = "profile")
	List<Post> posts;

	@Override
	public String toString() {
		return "Profile [refProfile=" + refProfile + ", inituleProfile=" + inituleProfile + ", niveauscolaire="
				+ niveauscolaire + "]";
	}

}
