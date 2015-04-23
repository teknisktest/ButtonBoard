package com.soprasteria.boot.domain;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Prosjekt {
	private int id; 
	private List<Konsulent> konsulenter;
	private String navn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Konsulent> getKonsulenter() {
		return konsulenter;
	}

	public void setKonsulenter(List<Konsulent> konsulenter) {
		this.konsulenter = konsulenter;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
}
