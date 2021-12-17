package com.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Entreprise {

	@Id
	@GeneratedValue
	@Column(name = "num_ApR")
	private Integer NumApR;

	@Column(name = "denonomination")
	private String denonomination;
	private String addresse;

	@OneToMany(mappedBy = "entreprise")
	List<Post> posts;

	
	
	public Integer getNumApR() {
		return NumApR;
	}



	public void setNumApR(Integer numApR) {
		NumApR = numApR;
	}



	public String getDenonomination() {
		return denonomination;
	}



	public void setDenonomination(String denonomination) {
		this.denonomination = denonomination;
	}



	public String getAddresse() {
		return addresse;
	}



	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}



	public List<Post> getPosts() {
		return posts;
	}



	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}



	@Override
	public String toString() {
		return "Entreprise [NumApR=" + NumApR + ", denonomination=" + denonomination + ", addresse=" + addresse + "]";
	}

}
