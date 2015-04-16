package com.soprasteria.boot.domain;

public class Konsulent {
	private String navn; 
	private int id; 
	private String epost; 
	private String image_url;
	private int pris; 
	private Stilling stilling;
	
	
	
	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEpost() {
		return epost;
	}
	public void setEpost(String epost) {
		this.epost = epost;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public int getPris() {
		return pris;
	}
	public void setPris(int pris) {
		this.pris = pris;
	}
	public Stilling getStilling() {
		return stilling;
	}
	public void setStilling(Stilling stilling) {
		this.stilling = stilling;
	} 
	
	
	
	
	

}
