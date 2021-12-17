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

@NamedQueries(@NamedQuery(name = "diplomeTache", query = "select p from Tache p join p.posts pst join "
		+ "  pst.profile prof join prof.diplomes d where d.refDiplome  = :id "))
public class Tache {

	@Id
	@GeneratedValue
	@Column(name = "ref_Tache")
	private Integer refTache;

	@Column(name = "libelle_Tache")
	private String LebelleTache;

	@ManyToMany
	@JoinTable(name = "Tache_post", joinColumns = @JoinColumn(name = "id_Tache"), inverseJoinColumns = @JoinColumn(name = "id_post"))
	List<Post> posts;

	
	
	public Integer getRefTache() {
		return refTache;
	}



	public void setRefTache(Integer refTache) {
		this.refTache = refTache;
	}



	public String getLebelleTache() {
		return LebelleTache;
	}



	public void setLebelleTache(String lebelleTache) {
		LebelleTache = lebelleTache;
	}



	public List<Post> getPosts() {
		return posts;
	}



	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}



	@Override
	public String toString() {
		return "Tache [refTache=" + refTache + ", LebelleTache=" + LebelleTache + "]";
	}
}
