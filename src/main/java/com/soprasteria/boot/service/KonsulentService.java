package com.soprasteria.boot.service;

import java.util.List;

import com.soprasteria.boot.util.GenerateKonsulentData;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.soprasteria.boot.domain.Konsulent;


//TODO: Implementer logikk for å arbeide mot konsulentlista

@Service
@Configurable
public class KonsulentService {

	
	private List<Konsulent> konsulenter; 
	
	public KonsulentService() {

		GenerateKonsulentData gkd = new GenerateKonsulentData();
		konsulenter = gkd.getKonsulentList();

	}
	

	
	public List<Konsulent> hentAlleKonsulenter() {
		return konsulenter;
	}
	
	public Konsulent hentMedId(int id) {
		for(Konsulent konsulent : konsulenter) {
			if(konsulent.getId() == id) {
				return konsulent;
			}
		}

		return null;
	}
	
	public int lagre(Konsulent konsulent){

		konsulenter.add(konsulent);
		return konsulenter.indexOf(konsulent);
	}
	
	public int endre(Konsulent konsulent){
		for(Konsulent k : konsulenter) {
			if(k.getId() == konsulent.getId()) {
				int p = konsulenter.indexOf(k);
				konsulenter.set(p, konsulent);
				return p;
			}
		}
		return -1;
	}
	
	public boolean slett(Konsulent konsulent){

		for(Konsulent k : konsulenter) {
			if(konsulent.getId() == konsulent.getId()) {
				konsulenter.remove(k);
				return true;
			}
		}

		return false;

	}
	
	

}
