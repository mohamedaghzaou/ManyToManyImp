package com.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(@NamedQuery(name = "Entreprise", query = "from Post p where p.entreprise.NumApR = :id "))
public class Post {

	@Id
	@GeneratedValue
	@Column(name = "ref_post")
	private Integer refPost;

	@Column(name = "intule_post")
	private String initulePoste;

	private long renumeration;

	public Integer getRefPost() {
		return refPost;
	}

	public void setRefPost(Integer refPost) {
		this.refPost = refPost;
	}

	public String getInitulePoste() {
		return initulePoste;
	}

	public void setInitulePoste(String initulePoste) {
		this.initulePoste = initulePoste;
	}

	public long getRenumeration() {
		return renumeration;
	}

	public void setRenumeration(long renumeration) {
		this.renumeration = renumeration;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Profile getProfiles() {
		return profile;
	}

	public void setProfiles(Profile profile) {
		this.profile = profile;
	}

	@ManyToMany(mappedBy = "posts", fetch = FetchType.LAZY)
	List<Tache> taches;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Entreprise")
	private Entreprise entreprise;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profile")
	private Profile profile;

	@Override
	public String toString() {
		return "Post [refPost=" + refPost + ", initulePoste=" + initulePoste + ", renumeration=" + renumeration + "]";
	}

}
